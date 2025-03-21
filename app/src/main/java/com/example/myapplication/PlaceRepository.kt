package com.example.myapplication

import kotlinx.coroutines.delay

class PlaceRepository {
    private val places = listOf(
        Place(R.drawable.image3, "Ресторан “Дичь”", "Предлагает блюда из дичи и редких видов мяса в русском стиле.", "Категория • \$\$ • 1,2 км от вас", "Время • 18:00-20:00"),
        Place(R.drawable.image4, "Ресторан “Plita”", "Уютное место домашней кухни, блюда на открытом огне и в печи.", "Категория • \$ • 1 км от вас", "Время • 13:00-16:00"),
        Place(R.drawable.image2, "Уютная бухта", "Коттедж на побережье с рыбалкой и прогулками на лодке.", "Категория • \$\$\$ • 10 км от вас", "Время • 10:00-23:00"),
        Place(R.drawable.image1, "Верхушка", "Коттедж в горах с потрясающим видом и спа-зоной.", "Категория • \$\$\$ • 10 км от вас", "Время • 10:00-23:00")
    )

    suspend fun getPlaces(): List<Place> {
        delay(3000)
        return places
    }
}