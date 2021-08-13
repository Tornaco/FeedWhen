package tornaco.project.android.feedwhen.domain.model

class Start(cityName: String, cityCode: Int) : City(cityName, cityCode)

class Dest(cityName: String, cityCode: Int) : City(cityName, cityCode)

open class City(val cityName: String, val cityCode: Int)