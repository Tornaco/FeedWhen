package tornaco.project.android.rennixing

import com.android.build.api.instrumentation.*
import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes


fun Project.log(log: Any?) {
    logger.error(">>>>>>>>>>> ${log?.toString() ?: "null"}")
}

class RennixingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.log("RennixingPlugin apply.")


        project.pluginManager.withPlugin("com.android.application") {
            val androidExtension = project.extensions.getByType(AppExtension::class.java)
            val androidComponentsExtension =
                project.extensions.getByType(AndroidComponentsExtension::class.java)

            project.log("androidExtension: $androidExtension")
            project.log("androidComponentsExtension: $androidComponentsExtension")


            androidComponentsExtension.onVariants { variant ->
                project.log("variant: ${variant.name}")

                variant.instrumentation.transformClassesWith(
                    SpanAddingClassVisitorFactory::class.java,
                    InstrumentationScope.ALL
                ) { params ->

                }
            }
        }
    }

}


abstract class SpanAddingClassVisitorFactory :
    AsmClassVisitorFactory<SpanAddingClassVisitorFactory.SpanAddingParameters> {

    interface SpanAddingParameters : InstrumentationParameters {
    }

    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor,
    ): ClassVisitor {
        return CommonClassVisitor(
            instrumentationContext.apiVersion.get(),
            nextClassVisitor
        )
    }

    override fun isInstrumentable(classData: ClassData): Boolean =
        classData.className.contains("Activity")
}

class CommonClassVisitor(api: Int, classVisitor: ClassVisitor?) : ClassVisitor(api, classVisitor) {

    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?,
    ): MethodVisitor {
        System.err.println("visitMethod: $name")
        return MyMethodVisitor(api,
            super.visitMethod(access, name, descriptor, signature, exceptions))
    }
}

class MyMethodVisitor(api: Int, mv: MethodVisitor?) :
    MethodVisitor(api, mv), Opcodes {
    override fun visitCode() {
        super.visitCode()
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
        mv.visitLdcInsn("start")
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
            "java/io/PrintStream",
            "println",
            "(Ljava/lang/String;)V",
            false)
    }

    override fun visitInsn(opcode: Int) {
        if (opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN
            || opcode == Opcodes.ATHROW
        ) {
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
            mv.visitLdcInsn("end")
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                "java/io/PrintStream",
                "println",
                "(Ljava/lang/String;)V",
                false)
        }
        mv.visitInsn(opcode)
    }
}