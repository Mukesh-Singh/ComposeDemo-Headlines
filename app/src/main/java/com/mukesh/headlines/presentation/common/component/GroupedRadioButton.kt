package com.mukesh.headlines.presentation.common.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukesh.headlines.ui.theme.HeadlinesTheme

/**
Created by Mukesh on 03/11/22
 **/

@Composable
fun GroupedRadioButton(modifier: Modifier = Modifier, mItems: List<String>, initialSelectedItem: String, onSelected: ((value: String) -> Unit)? = null) {
    val mRememberObserver = remember { mutableStateOf(initialSelectedItem) }

    Column {
        mItems.forEach { mItem ->
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 32.dp)
                    .padding(horizontal = 8.dp)
                    .clickable(
                        onClick = {
                            mRememberObserver.value = mItem
                            onSelected?.invoke(mItem)
                        }
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = mRememberObserver.value == mItem,
                    enabled = true,
                    onClick = {
                        mRememberObserver.value = mItem
                        onSelected?.invoke(mItem)
                    },
                    //colors = RadioButtonDefaults.colors(selectedColor = Color.Yellow)
                )
                Text(text = mItem, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}

@Preview
@Composable
fun Preview_GroupedRadioButton() {
    HeadlinesTheme() {
        GroupedRadioButton(mItems = listOf("A", "B", "C"), initialSelectedItem ="A" )
    }
}