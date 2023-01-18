package com.mukesh.headlines.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mukesh.headlines.R

private val fontFamilyNewYork = FontFamily(
    listOf(
        Font(
            resId = R.font.newyork_medium_regular,
            weight = FontWeight.Normal,
        ),
        Font(
            resId = R.font.newyork_medium_semibold,
            weight = FontWeight.SemiBold
        ),
        Font(
            resId = R.font.newyork_medium_bold,
            weight = FontWeight.Bold
        ),

        Font(
            resId = R.font.newyork_medium_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.newyork_medium_semibold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic
        ),

        Font(
            resId = R.font.newyork_medium_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),


        )
)

private val nunito = FontFamily(
    listOf(
        Font(
            resId = R.font.nunito_variablefont_wght,
            weight = FontWeight.Normal

        )
    )
)

val typography = Typography(
    defaultFontFamily = fontFamilyNewYork,
    h1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 40.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 36.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = fontFamilyNewYork,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = fontFamilyNewYork,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    body2 = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        fontFamily = fontFamilyNewYork,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        fontFamily = fontFamilyNewYork,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    overline = TextStyle(
        fontFamily = nunito,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    ),
)
sealed class CustomFont {
    companion object {
        val NewYourSemiBold = TextStyle(
            fontFamily = fontFamilyNewYork,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
        )

        val NewYourBold = TextStyle(
            fontFamily = fontFamilyNewYork,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        val NewYourBoldSmall = TextStyle(
            fontFamily = fontFamilyNewYork,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
        )

        val NunitoLight = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
        )
        val NunitoRegularSmall = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
        )
        val NunitoRegularMedium = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        )

        val NunitoSemiboldSmall = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
        )

        val NunitoExtraLightSmall = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.ExtraLight,
            fontSize = 12.sp,
        )

        val NunitoSemiboldMedium = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
        )

        val NunitoBoldSmall = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
        )

        val NunitoBoldLarge = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
        )

        val NunitoExtraBoldSmall = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 10.sp,
        )

        val NunitoExtramBoldMedium = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
        )

        val NunitoBlack = TextStyle(
            fontFamily = nunito,
            fontWeight = FontWeight.Black,
            fontSize = 14.sp,
        )
    }

}
