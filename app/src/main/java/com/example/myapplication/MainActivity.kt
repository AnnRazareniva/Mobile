package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.CustomButton
import com.example.myapplication.ui.theme.MyApplicationTheme

import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.myapplication.ui.theme.CustomButtonSmall
import com.example.myapplication.ui.theme.RedBut
import com.example.myapplication.ui.theme.YellowBackground
import com.example.myapplication.ui.theme.YellowYellowBackground
import com.example.myapplication.ui.theme.shantellSans
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.MutableState



@Composable
fun MyApp() {
    // Создаем NavController для управления навигацией
    val navController = rememberNavController()

    // Настройка NavHost, которая управляет переходами между экранами
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            ScreenLogin(navController) //Экран регистрации/входа
        }
        composable("main") {
            ScreenMain(navController) //Главный экран
        }
        composable("newparty") {
            NewPartyScreen(navController) //Экран создания вечеринки
        }
        composable("Place") {
            PlaceListScreen(navController) //Экран выбора места
        }
        composable("friends") {
            FriendsListScreen(navController) //Экран создания списка друзей
        }
        composable("dishes") {
            DishListScreen(navController) //Экран выбора блюд
        }
        composable("endfriends") {
            EndPartyScreen(navController) //Экран отправки приглашений
        }
        composable("oldfriends") {
            OldPartyListScreen(navController) //Экран старой вечеринки
        }
        composable("currentparty") {
            PartyCurrentScreen(navController) //Экран текущ вечеринки
        }
        composable("settings") {
            SettingsScreen(navController) //Экран настроек
        }
        composable("data") {
            CalendarScreen(navController) //Экран настроек
        }
    }
}


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MyApp()
                }
            }
        }
    }

//Экран регистрации/входа
@Composable
fun ScreenLogin(navController: NavController, modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background))

    {

        Column(
            modifier = Modifier

                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //кнопка войти
            CustomButton(

                onClick = { navController.navigate("main") },
                text = "Войти",
                fontSize = 20.sp,
                Modifier.size(188.dp, 48.dp)
            )

            Spacer(modifier = Modifier.height(32.dp)) // Отступ между кнопками
            //кнопка регистрации
            CustomButton(

                onClick = { navController.navigate("main") },
                text = "Зарегистрироваться",
                fontSize = 20.sp,
                Modifier.size(282.dp, 48.dp)
            )
            Spacer(modifier = Modifier.height(256.dp))
        }
    }
}


//Главный экран
@Composable
fun ScreenMain( navController: NavController, modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background))

    {

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //кнопка Новая вечеринка
            CustomButton(

                onClick = { navController.navigate("newparty") },
                text = "Новая вечеринка",
                fontSize = 20.sp,
                Modifier.size(284.dp, 84.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            //кнопка Старая вечеринка
            CustomButton(

                onClick = { navController.navigate("oldfriends") },
                text = "Старая вечеринка",
                fontSize = 20.sp,
                Modifier.size(284.dp, 84.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            //кнопка Текущая вечеринка
            CustomButton(

                onClick = { navController.navigate("currentparty") },
                text = "Текущая вечеринка",
                fontSize = 20.sp,
                Modifier.size(284.dp, 84.dp)
            )
            Spacer(modifier = Modifier.height(256.dp))
        }
        // Кнопка шестерёнки настройки
        IconButton(
                onClick = { navController.navigate("settings") },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 64.dp, end = 16.dp)
                    .size(48.dp)
                    .background(
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = CircleShape
                    )

            ) {
            Image(
                painter = painterResource(id = R.drawable.icon_button),
                contentDescription = "Custom Icon",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(48.dp)
                    .fillMaxSize()
            )
            }
        }
}

//Экран создания вечеринки
@Composable
fun NewPartyScreen(navController: NavController, modifier: Modifier = Modifier) {
    val textState = remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize().background(YellowBackground)
    ) {
        IconButton(
            onClick = { navController.navigate("main") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(124.dp))

            TextField(
                value = textState.value,
                onValueChange = { newText -> textState.value = newText },
                label = { Text("Название вечеринки") },
                modifier = Modifier
                    .size(284.dp, 56.dp)
                    .padding(4.dp)
                    .background(Color.Black.copy(alpha = 0.5f)),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(
                    color = Color.Black.copy(alpha = 0.5f),
                    fontSize = 20.sp
                )
            )
            Spacer(modifier = Modifier.height(64.dp))
            // выбрать дату
            CustomButton(
                onClick = { navController.navigate("data") },
                text = "Выбрать дату",
                fontSize = 20.sp,
                Modifier.size(284.dp, 69.dp)
            )
            Spacer(modifier = Modifier.weight(1f).heightIn(min = 32.dp))
            // выбрать место
            CustomButton(
                onClick = { navController.navigate("Place") },
                text = "Выбрать место",
                fontSize = 20.sp,
                Modifier.size(284.dp, 69.dp)
            )
            Spacer(modifier = Modifier.weight(1f).heightIn(min = 32.dp))
            // список гостей
            CustomButton(
                onClick = { navController.navigate("friends") },
                text = "Список гостей",
                fontSize = 20.sp,
                Modifier.size(284.dp, 69.dp)
            )
            Spacer(modifier = Modifier.weight(1f).heightIn(min = 32.dp))
            // список блюд
            CustomButton(
                onClick = { navController.navigate("dishes") },
                text = "Список блюд",
                fontSize = 20.sp,
                Modifier.size(284.dp, 69.dp)
            )
            Spacer(modifier = Modifier.weight(1f).heightIn(min = 64.dp))
            // Переход "готово"
            CustomButtonSmall(
                onClick = { navController.navigate("endfriends")  },
                text = "Готово",
                fontSize = 16.sp,
                Modifier.size(156.dp, 53.dp)
            )
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}

//Экран выбора места
data class Place(
    val imageResId: Int,
    val headline: String,
    val supportingText: String,
    val supportingText1: String,
    val supportingText2: String
)
@Composable
fun PlaceListScreen(navController: NavController, modifier: Modifier = Modifier) {
    val places = listOf(
        Place(R.drawable.image3, "Ресторан “Дичь”", "Предлагает блюда из дичи и редких видов мяса в русском стиле.", "Категория • \$\$ • 1,2 км от вас", "Время • 18:00-20:00"),
        Place(R.drawable.image4, "Ресторан “Plita”", "Уютное место домашней кухни, блюда на открытом огне и в печи.", "Категория • \$ • 1 км от вас", "Время • 13:00-16:00"),
        Place(R.drawable.image2, "Уютная бухта", "Коттедж на побережье с рыбалкой и прогулками на лодке.", "Категория • \$\$\$ • 10 км от вас", "Время • 10:00-23:00"),
        Place(R.drawable.image1, "Верхушка", "Коттедж в горах с потрясающим видом и спа-зоной.", "Категория • \$\$\$ • 10 км от вас  ", "Время • 10:00-23:00")
    )

    val textState = remember { mutableStateOf("") }
    val selectedPlaceIndex = remember { mutableStateOf<Int?>(null) } // для хранения индекса выбранного элемента

    Box(
        modifier = modifier.fillMaxSize().background(YellowBackground)
    ) {
        IconButton(
            onClick = { navController.navigate("newparty") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                SearchField(value = textState.value, onValueChange = { textState.value = it })
            }

            Spacer(modifier = Modifier.height(33.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 143.dp)
            ) {
                places.forEachIndexed { index, place ->
                    val borderColor = if (selectedPlaceIndex.value == index) RedBut else Color.Transparent
                    val borderWidth = if (selectedPlaceIndex.value == index) 2.dp else 0.dp

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
//                            .padding(horizontal = 16.dp)
                            .border(width = borderWidth, color = borderColor, shape = RoundedCornerShape(8.dp))
                            .clickable {
                                selectedPlaceIndex.value = index
                            }
                    ) {
                        ListItem(place = place)
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(143.dp)
                .background(YellowBackground)
                .align(Alignment.BottomCenter)
                .padding(bottom = 64.dp)
        ) {
            CustomButtonSmall(
                onClick = { navController.navigate("newparty") },
                text = "Далее",
                fontSize = 18.sp,
                Modifier.size(156.dp, 53.dp).align(Alignment.BottomCenter)
            )
        }
    }
}
@Composable
fun ListItem(place: Place) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .padding(16.dp)
            .height(151.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(16.dp))
        // Картинка слева
        Image(
            painter = painterResource(id = place.imageResId),
            contentDescription = "Item Image",
            modifier = Modifier
                .size(80.dp)
//                .padding(start=16.dp, end = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = place.headline,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = shantellSans
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .padding(end = 24.dp)
                ) {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star",
                            tint = RedBut.copy(alpha = 0.6f),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = place.supportingText,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF49454F),
                    fontFamily = shantellSans
                )
            )
            Text(
                text = place.supportingText1,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF49454F),
                    fontFamily = shantellSans
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = place.supportingText2,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF49454F),
                    fontFamily = shantellSans
                )
            )
        }

    }
    Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 16.dp, end = 16.dp)
                .background(Color.Black)
            )

}
@Composable
fun SearchField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("") },
        modifier = Modifier
            .size(380.dp, 56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color.Black.copy(alpha = 0.5f)),
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 18.sp,
        ),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "",
                tint = Color.Black
            )
        }
    )
}


//Экран создания списка друзей
data class Friend(
    val imageResId: Int,
    val name: String,
    val surname: String,
    var isSelected: Boolean = false
)
@Composable
fun FriendsListScreen(navController: NavController, modifier: Modifier = Modifier) {
    val friends = listOf(
        Friend(R.drawable.image16, "Давид ", "Бабаджанян"),
        Friend(R.drawable.image12, "Стас ", "Васильев"),
        Friend(R.drawable.image14, "Никита ", "Гридин"),
        Friend(R.drawable.image5, "Сергей ", "Калугин"),
        Friend(R.drawable.image6, "Дмитрий ", "Куплинов"),
        Friend(R.drawable.image7, "Полина ", "Лимонова"),
        Friend(R.drawable.image8, "Педро ", "Паскаль"),
        Friend(R.drawable.image9, "Эдик ", "Повидлыч"),
        Friend(R.drawable.image10, "Артём ", "Смагин"),
        Friend(R.drawable.image11, "Владислав ", "Тисленко")
    )

    // Состояние для поиска
    val textState = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize().background(YellowBackground)
    ) {
        IconButton(
            onClick = { navController.navigate("newparty") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                SearchField(value = textState.value, onValueChange = { textState.value = it })
            }

            Spacer(modifier = Modifier.height(33.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(start = 16.dp, end = 16.dp, bottom = 143.dp)

            ) {
                friends.forEach { friend ->
                    FriendListItem(friend = friend)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(143.dp)
                .background(YellowBackground)
                .align(Alignment.BottomCenter).padding(bottom = 64.dp)
        )
        {
            CustomButtonSmall(
                onClick = { navController.navigate("newparty") },
                text = "Далее",
                fontSize = 18.sp,
                Modifier.size(156.dp, 53.dp).align(Alignment.BottomCenter)
            )
        }
    }
}
@Composable
fun FriendListItem(friend: Friend) {
    Row(
        modifier = Modifier
            .fillMaxWidth().background(YellowYellowBackground)
            .height(56.dp)
            .padding(start = 16.dp, end = 24.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


        Image(
            painter = painterResource(id = friend.imageResId),
            contentDescription = "Friend Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "${friend.name} ${friend.surname}",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = shantellSans
                )
            )
        }

        val isSelected = remember { mutableStateOf(friend.isSelected) }

        Box(
            modifier = Modifier
                .size(24.dp)  // Размер квадратика
                .clip(RoundedCornerShape(4.dp))  // Скругляем углы для более мягкого вида
                .background(if (isSelected.value) RedBut else Color.White)  // Цвет меняется
                .clickable {
                    isSelected.value = !isSelected.value  // Изменяем состояние по клику
                }
                .padding(4.dp),  // Внутренний отступ для галочки
            contentAlignment = Alignment.Center
        ) {
            // Галочка
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Select",
                tint = if (isSelected.value) Color.White else Color.White,  // Галочка будет видна только если выбрана
                modifier = Modifier.size(16.dp)  // Размер галочки
            )
        }
    }
}


//Экран выбора блюд
data class Dishes(
    val imageResId: Int,
    val headline: String,
    val supportingText: String,
    val supportingText1: String,
    var isSelected: Boolean = false
)
@Composable
fun DishListScreen(navController: NavController, modifier: Modifier = Modifier) {
    val dish = listOf(
        Dishes(R.drawable.image17, "Оладушки от бабушки”", "490 р.", "Оладушки со сгущёнкой и вареньем."),
        Dishes(R.drawable.image19, "Сэндвич Маца”", "890 р.", "Чиабатта, вяленые помидоры в масле, моцарелла, горчица, салат."),
        Dishes(R.drawable.image18, "Бэйгл с икрой", "990 р.", "Бэйгл, авокадо, варёное яйцо, маринованные огурцы, красная икра."),
        Dishes(R.drawable.image, "Манты", "520 р.", "Тесто для мантов, свинной фарш."),
        Dishes(R.drawable.image20, "Рататуй", "720 р", "Кабачок, баклажан, помидор, лук")
    )

    Box(
        modifier = modifier.fillMaxSize().background(YellowBackground)
    ) {

        IconButton(
            onClick = { navController.navigate("newparty") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                SearchField(value = "", onValueChange = { })
            }
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 143.dp)
            ) {
                dish.forEach { dish ->
                    ListItemDish(dish = dish)
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(143.dp)
                .background(YellowBackground)
                .align(Alignment.BottomCenter).padding(bottom = 64.dp)
        ) {
            CustomButtonSmall(
                onClick = { navController.navigate("newparty") },
                text = "Далее",
                fontSize = 18.sp,
                Modifier.size(156.dp, 53.dp).align(Alignment.BottomCenter)
            )
        }
    }
}
@Composable
fun ListItemDish(dish: Dishes) {
    val isSelected = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(117.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(16.dp))

        Image(
            painter = painterResource(id = dish.imageResId),
            contentDescription = "Item Image",
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = dish.headline,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = shantellSans
                    )
                )

                Spacer(modifier = Modifier.weight(1f))


                Row(
                    modifier = Modifier
                        .padding(end = 24.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(if (isSelected.value) RedBut else Color.White)
                            .border(2.dp, if (isSelected.value) RedBut else Color.Gray, RoundedCornerShape(4.dp))
                            .clickable {
                                isSelected.value = !isSelected.value
                            }
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Select",
                            tint = if (isSelected.value) Color.White else Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dish.supportingText,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF49454F),
                    fontFamily = shantellSans
                )
            )
            Text(
                text = dish.supportingText1,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF49454F),
                    fontFamily = shantellSans
                )
            )
            Spacer(modifier = Modifier.height(12.dp))

        }

    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.Black)
    )
}


//Экран оправки приглашений
data class EndFriend(
    val imageResId: Int,
    val name: String,
    val surname: String,
    var isSelected: Boolean = true
)
@Composable
fun EndPartyScreen(navController: NavController, modifier: Modifier = Modifier) {
    val endfriends = listOf(
        EndFriend(R.drawable.image16, "Давид ", "Бабаджанян"),
        EndFriend(R.drawable.image12, "Стас ", "Васильев"),
        EndFriend(R.drawable.image14, "Никита ", "Гридин"),
        EndFriend(R.drawable.image5, "Сергей ", "Калугин"),
        EndFriend(R.drawable.image6, "Дмитрий ", "Куплинов"),
        EndFriend(R.drawable.image7, "Полина ", "Лимонова"),
        EndFriend(R.drawable.image8, "Педро ", "Паскаль"),
        EndFriend(R.drawable.image9, "Эдик ", "Повидлыч"),
        EndFriend(R.drawable.image10, "Артём ", "Смагин"),
        EndFriend(R.drawable.image11, "Владислав ", "Тисленко")
    )
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(YellowBackground)
    ) {
        IconButton(
            onClick = { navController.navigate("newparty") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp)
        ) {

            Box(
                modifier = Modifier
                    .width(284.dp)
                    .height(71.dp)
                    .background(Color(0xFFF4B3C8), shape = RoundedCornerShape(28.dp))
                    .align(Alignment.CenterHorizontally)
                    ,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Приглашаем Вас на вечеринку!",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = shantellSans
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(start = 16.dp, end = 16.dp, bottom = 143.dp)
            ) {
                endfriends.forEach { endfriends ->
                    EndFriendListItem(endfriends = endfriends)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(143.dp)
                .background(YellowBackground)
                .align(Alignment.BottomCenter)
                .padding(bottom = 64.dp)
        ) {
            CustomButtonSmall(
                onClick = { navController.navigate("main") },
                text = "Отправить приглашения",
                fontSize = 18.sp,
                Modifier.size(284.dp, 53.dp).align(Alignment.BottomCenter)
            )
        }
    }
}
@Composable
fun EndFriendListItem(endfriends: EndFriend) {
    Row(
        modifier = Modifier
            .fillMaxWidth().background(YellowYellowBackground)
            .height(56.dp)
            .padding(start = 16.dp, end = 24.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


        Image(
            painter = painterResource(id = endfriends.imageResId),
            contentDescription = "Friend Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "${endfriends.name} ${endfriends.surname}",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = shantellSans
                )
            )
        }

        val isSelected = remember { mutableStateOf(endfriends.isSelected) }

        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(if (isSelected.value) RedBut else Color.White)
                .clickable {
                    isSelected.value = !isSelected.value
                }
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Select",
                tint = if (isSelected.value) Color.White else Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}


//Экран старой вечеринки
data class Party(
    val headline: String,
    val supportingText: String,
    val supportingText1: String,
    val supportingText2: String
)
@Composable
fun OldPartyListScreen(navController: NavController, modifier: Modifier = Modifier) {
    val parties = listOf(
        Party("День рождения Артёма", "Дата: 14 Мая", "Место: Ресторан “Дичь”", "Друзья: Влад Тисленко, Сергей Калугин..."),
        Party("День рождения Серёжи", "Дата: 23 Сен", "Место: Ресторан “Дичь”", "Друзья: Влад Тисленко, Артём Смагин..."),
        Party("Веселье", "Дата: 20 Июн", "Место: Ресторан “Plita”", "Друзья: Влад Тисленко, Артём Смагин..."),
        Party("Корпоротив", "Дата: 25 Авг", "Место: Ресторан “Plita”", "Друзья: Влад Тисленко, Артём Смагин..."),
        Party("Выпускной", "Дата: 10 Июл", "Место: Коттедж “Верхушка”", "Друзья: Влад Тисленко, Артём Смагин...")
    )

    Box(
        modifier = modifier.fillMaxSize().background(YellowBackground)
    ) {
        IconButton(
            onClick = { navController.navigate("main") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                SearchField(value = "", onValueChange = { })
            }

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 143.dp)
            ) {
                parties.forEach { party ->
                    ListItemParty(party = party)
                }
            }
        }
    }
}
@Composable
fun ListItemParty(party: Party) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(122.dp)
    ) {
        Text(
            text = party.headline,
            style = TextStyle(
                fontSize = 22.sp,
                color = Color.Black,
                fontFamily = shantellSans
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = party.supportingText,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color(0xFF49454F),
                fontFamily = shantellSans
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = party.supportingText1,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color(0xFF49454F),
                fontFamily = shantellSans
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = party.supportingText2,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color(0xFF49454F),
                fontFamily = shantellSans
            )
        )
    }

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Black)
    )
}

//Экран текущей вечеринки
data class DishesCurrent(
    val imageResId: Int,
    val name: String
)
@Composable
fun PartyCurrentScreen(navController: NavController, modifier: Modifier = Modifier) {
    val place = Place(
        imageResId = R.drawable.image3,
        headline = "Ресторан “Дичь”",
        supportingText = "Предлагает блюда из дичи и редких видов мяса в русском стиле.",
        supportingText1 = "Время • 18:00-20:00",
        supportingText2 = "Дата: 17 Авг"
    )

    val endfriends = listOf(
        EndFriend(R.drawable.image16, "Давид ", "Бабаджанян"),
        EndFriend(R.drawable.image12, "Стас ", "Васильев"),
        EndFriend(R.drawable.image14, "Никита ", "Гридин"),
        EndFriend(R.drawable.image5, "Сергей ", "Калугин"),
        EndFriend(R.drawable.image6, "Дмитрий ", "Куплинов"),
        EndFriend(R.drawable.image7, "Полина ", "Лимонова"),
        EndFriend(R.drawable.image8, "Педро ", "Паскаль"),
        EndFriend(R.drawable.image9, "Эдик ", "Повидлыч"),
        EndFriend(R.drawable.image10, "Артём ", "Смагин"),
        EndFriend(R.drawable.image11, "Владислав ", "Тисленко")
    )

    val dishes = listOf(
        DishesCurrent(R.drawable.image17, "Оладушки от бабушки”"),
        DishesCurrent(R.drawable.image18, "Бэйгл с икрой"),
        DishesCurrent(R.drawable.image19, "Сэндвич Маца”"),
        DishesCurrent(R.drawable.image21, "Свекольный суп"),
        DishesCurrent(R.drawable.image20, "Рататуй"),
        DishesCurrent(R.drawable.image, "Манты")
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(YellowBackground)
    ) {
        IconButton(
            onClick = { navController.navigate("main") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 140.dp)
        ) {

            ListItemPlace(place = place)

            Spacer(modifier = Modifier.height(8.dp))


            // Список блюд
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxHeight()
                ) {
                    dishes.forEach { dish ->
                        DishListItem(dish = dish)
                    }
                }
            }

// Список друзей
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxHeight()
                ) {
                    endfriends.forEach { endfriend ->
                        FriendCurrentListItem(endfriends = endfriend)
                    }
                }
            }


        }
        //block dlya niza
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(143.dp)
                .background(YellowBackground)
                .align(Alignment.BottomCenter).padding(bottom = 64.dp)
        )
        {

        }
    }
}
@Composable
fun ListItemPlace(place: Place) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(151.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(16.dp))

        // Картинка слева
        Image(
            painter = painterResource(id = place.imageResId),
            contentDescription = "Place Image",
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = place.headline,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = shantellSans
                    )
                )

                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = place.supportingText,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF49454F),
                    fontFamily = shantellSans
                )
            )
            Text(
                text = place.supportingText1,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF49454F),
                    fontFamily = shantellSans
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = place.supportingText2,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF49454F),
                    fontFamily = shantellSans
                )
            )
        }
    }
}
@Composable
fun FriendCurrentListItem(endfriends: EndFriend) {
    Row(
        modifier = Modifier
            .fillMaxWidth().background(YellowYellowBackground)
            .height(56.dp)
            .padding(start = 16.dp, end = 24.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


        Image(
            painter = painterResource(id = endfriends.imageResId),
            contentDescription = "Friend Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "${endfriends.name} ${endfriends.surname}",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = shantellSans
                )
            )
        }
    }
}
@Composable
fun DishListItem(dish: DishesCurrent) {
    Row(
        modifier = Modifier
            .fillMaxWidth().background(YellowYellowBackground)
            .height(56.dp)
            .padding(start = 16.dp, end = 24.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {


        Image(
            painter = painterResource(id = dish.imageResId),
            contentDescription = "Friend Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = dish.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = shantellSans
                )
            )
        }
    }
}


//Экран настроек
@Composable
fun SettingsScreen(navController: NavController, modifier: Modifier = Modifier) {

       Box(
        modifier = modifier.fillMaxSize().background(YellowBackground)
            .padding(bottom = 64.dp)
    ) {
        IconButton(
            onClick = { navController.navigate("main") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(top = 128.dp)
                   .padding(start = 64.dp, end = 64.dp)
                   .align(Alignment.TopCenter)
           ) {
               SettingRow(label = "Уведомления", switchState = remember { mutableStateOf(false) })
               Spacer(modifier = Modifier.height(42.dp))

               SettingRow(label = "Звук уведомлений", switchState = remember { mutableStateOf(false) })
               Spacer(modifier = Modifier.height(42.dp))

               SettingRow(label = "Звук приложения", switchState = remember { mutableStateOf(false) })
           }

           CustomButtonSmall(
               onClick = { navController.navigate("main") },
               text = "Сохранить изменения",
               fontSize = 18.sp,
               Modifier.size(284.dp, 53.dp).align(Alignment.BottomCenter)
           )
       }
}
@Composable
fun SettingRow(label: String, switchState: MutableState<Boolean>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontFamily = shantellSans
            ),
            modifier = Modifier.weight(1f)
        )
        Switch(
            checked = switchState.value,
            onCheckedChange = { switchState.value = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                uncheckedThumbColor = RedBut.copy(alpha = 0.6f),
                checkedTrackColor = RedBut,
                uncheckedTrackColor = Color(0xFFF0C9D6),
                checkedBorderColor = RedBut,
                uncheckedBorderColor = RedBut.copy(alpha = 0.6f)
            )
        )
    }
}


//Экран выбора даты

@Composable
fun CalendarScreen(navController: NavController, modifier: Modifier = Modifier) {
    val currentDate = remember { mutableStateOf(17) }
    val selectedDate = remember { mutableStateOf(0) }

    val firstDayOfMonth = 5

    Box(modifier = Modifier
        .fillMaxSize()
        .background(YellowBackground)
        .padding(start = 16.dp, end = 16.dp)) {

        IconButton(
            onClick = { navController.navigate("newparty") },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp,top = 76.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 144.dp)
        ) {
            Box(modifier = Modifier
                .background(YellowYellowBackground, shape = RoundedCornerShape(28.dp))
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)) {

                Column(modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()) {
                    Text(text = "Select Date", style = TextStyle(fontSize = 16.sp, fontFamily = shantellSans))
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = "Aug 17, 2025", style = TextStyle(fontSize = 20.sp, fontFamily = shantellSans))
                }


                Column(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 112.dp)
                    .fillMaxWidth()) {

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        DayHeader(day = "M")
                        DayHeader(day = "T")
                        DayHeader(day = "W")
                        DayHeader(day = "T")
                        DayHeader(day = "F")
                        DayHeader(day = "S")
                        DayHeader(day = "S")
                    }

                    // Даты месяца
                    val daysInMonth = (1..31).toList()
                    val paddedDays = List(firstDayOfMonth) { 0 } + daysInMonth

                    val rows = paddedDays.chunked(7)

                    rows.forEach { week ->
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            week.forEach { day ->
                                DateBlock(day = day, currentDate = currentDate.value, selectedDate = selectedDate.value, onClick = { selectedDate.value = day })
                            }
                        }
                    }

                }
                Box(modifier = Modifier.height(32.dp))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(143.dp)
                .background(YellowBackground)
                .align(Alignment.BottomCenter).padding(bottom = 64.dp)
        )
        {
            CustomButtonSmall(
                onClick = { navController.navigate("newparty") },
                text = "Далее",
                fontSize = 18.sp,
                Modifier.size(156.dp, 53.dp).align(Alignment.BottomCenter)
            )
        }
    }
}
@Composable
fun DayHeader(day: String) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = day, style = TextStyle(fontSize = 12.sp, fontFamily = shantellSans))
    }
}
@Composable
fun DateBlock(day: Int, currentDate: Int, selectedDate: Int, onClick: () -> Unit) {
    val backgroundColor = when {
        day == selectedDate -> RedBut
        day == currentDate -> Color.Transparent
        day != 0 -> Color.Transparent
        else -> Color.Transparent
    }
    val borderColor = if (day == currentDate) Color.Black else Color.Transparent

    // Убираем окраску пустых дней
    if (day != 0) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(backgroundColor, shape = CircleShape)
                .border(2.dp, borderColor, shape = CircleShape)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Text(text = day.toString(), style = TextStyle(fontSize = 12.sp, fontFamily = shantellSans))
        }
    } else {
        Box(modifier = Modifier.size(32.dp))
    }
}