package com.mukesh.headlines.presentation.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.mukesh.headlines.R


sealed class OptionMenuItem(val id: Int = 0, @StringRes val resourceId : Int, val imageVector: ImageVector){
    companion object{
        const val ID_SETTING = 100
    }
    object Setting: OptionMenuItem(ID_SETTING,R.string.setting, Icons.Default.Settings)
    object Setting_2: OptionMenuItem(101,R.string.setting, Icons.Default.Settings)
}