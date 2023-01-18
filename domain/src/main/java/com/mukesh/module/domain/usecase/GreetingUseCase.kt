package com.mukesh.module.domain.usecase

import java.util.*

/**
Created by Mukesh on 31/10/22
 **/

class GreetingUseCase {
    operator fun invoke (): String{
        val c = Calendar.getInstance(Locale.getDefault())
        return when (c.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Morning"
            in 12..15 -> "Afternoon"
            in 16..23 -> "Evening"
            //in 21..23 -> "Good Night"
            else -> ""
        }
    }
}