package com.mukesh.headlines.presentation.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.SharedViewModel
import com.mukesh.headlines.presentation.common.component.GroupedRadioButton

/**
Created by Mukesh on 02/11/22
 **/

@Composable
fun HomeScreenBottomSheet(
    text: String? = null,
    bottomSheetType: Int? = null,
    sharedViewModel: SharedViewModel? = null,
) {
    Column(
        modifier = Modifier.padding(top = 16.dp, bottom = 32.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Theme",
            style = MaterialTheme.typography.subtitle2
        )
        sharedViewModel?.ThemeList?.let {
            GroupedRadioButton(
                mItems = it,
                initialSelectedItem = sharedViewModel.themeOption.value,
                onSelected = { selected ->
                    sharedViewModel.setThemeOption(selected)
                }
            )
        }
    }
}
