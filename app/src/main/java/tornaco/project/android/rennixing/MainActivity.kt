package tornaco.project.android.rennixing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            androidx.compose.material.Surface(
                modifier = Modifier.fillMaxSize()
            ) {
             //   OrderList()
            }
        }

        AlertDialog.Builder(this).setTitle("提示").setMessage("行程取消成功").show()
    }

    @ExperimentalFoundationApi
    @Composable
    fun OrderList() {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray)
                .padding(16.dp)
        ) {
            stickyHeader {
                Text(text = "我的订单", style = MaterialTheme.typography.h4)
                Spacer(modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.size(16.dp))
            }

            items(arrayOf(1, 2, 3, 4, 5, 6, 7, 8)) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(16.dp)
                ) {
                    Text(text = "北京---上海", style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "订单金额: 999元")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "预订日期：2022-0${it}-1${it} 12:32")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(
                        text = "ORDER ID: $it ",
                        style = MaterialTheme.typography.caption.copy(fontSize = 12.sp)
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
            }
        }

    }
}