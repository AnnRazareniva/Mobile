package com.example.myapplication.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.Button
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = YellowBackground,
    onBackground = RedBut
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    // Создаём стиль для кнопок

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    fontSize: TextUnit,
    buttonSize: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = RedBut, // Цвет фона кнопки
            contentColor = Color.White // Цвет текста кнопки
        ),
        modifier = buttonSize

    )
    {
        Text(text,
            style = TextStyle(
                fontFamily = shantellSans,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        )
    }
}

@Composable
fun CustomButtonSmall(
    onClick: () -> Unit,
    text: String,
    fontSize: TextUnit,
    buttonSize: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = RedBut, // Цвет фона кнопки
            contentColor = Color.White // Цвет текста кнопки
        ),
        modifier = buttonSize

    )
    {
        Text(text,
            style = TextStyle(
                fontFamily = shantellSans,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun CustomButtonMilde(
    onClick: () -> Unit,
    text: String,
    fontSize: TextUnit,
    buttonSize: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = RedBut, // Цвет фона кнопки
            contentColor = Color.White // Цвет текста кнопки
        ),
        modifier = buttonSize

    )
    {
        Text(text,
            style = TextStyle(
                fontFamily = shantellSans,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp
            )
        )
    }
}
