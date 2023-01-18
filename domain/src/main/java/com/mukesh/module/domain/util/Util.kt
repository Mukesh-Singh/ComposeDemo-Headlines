package com.mukesh.module.domain.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

/**
Created by Mukesh on 27/10/22
 **/

object Util {
    private const val NEWS_PUBLISHED_AT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    const val UI_NEWS_PUBLISHED_AT_FORMAT_DATE = "dd MMM yy"
    const val UI_NEWS_PUBLISHED_AT_FORMAT_TIME = "h:mm a"
    const val UI_NEWS_PUBLISHED_AT_FORMAT_DATE_WITH_DAY = "EEEE, dd MMM yy"


    @SuppressLint("NewApi")
    private fun getPublishedData(publishedTime: String?, outputFormat: String? = UI_NEWS_PUBLISHED_AT_FORMAT_DATE): String {
        if (publishedTime.isNullOrBlank())
            return ""

        val inputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern(NEWS_PUBLISHED_AT_FORMAT)
        val outputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern(outputFormat, Locale.getDefault())
        val date: LocalDate = LocalDate.parse(publishedTime, inputFormatter)
        return outputFormatter.format(date)


    }

    @SuppressLint("NewApi")
    fun getFormattedPublishedData(publishedTime: String?): String {
        return getPublishedData(publishedTime)
    }

    @SuppressLint("NewApi")
    fun getFormattedPublishedData(publishedTime: String?, outputFormat: String): String {
        return getPublishedData(publishedTime, outputFormat)
    }


    @SuppressLint("NewApi")
    fun getFormattedPublishedTime(publishedTime: String?): String {
        if (publishedTime.isNullOrBlank())
            return ""

        val inputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern(NEWS_PUBLISHED_AT_FORMAT)
        val outputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern(UI_NEWS_PUBLISHED_AT_FORMAT_TIME, Locale.getDefault())
        val date: LocalTime = LocalTime.parse(publishedTime, inputFormatter)
        return outputFormatter.format(date)

    }
}