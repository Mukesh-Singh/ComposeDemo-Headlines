package com.mukesh.module.domain.model.network


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.mukesh.module.domain.util.Util
import java.util.*

@Parcelize
data class News(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("publishedAt")
    val publishedAt: String? = null,
    @SerializedName("source")
    val source: Source? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("urlToImage")
    val urlToImage: String? = null
) : Parcelable {
    @Parcelize
    data class Source(
        @SerializedName("id")
        val id: String? = null,
        @SerializedName("name")
        val name: String? = null
    ) : Parcelable

    fun toLocalNewsObject(): com.mukesh.module.domain.model.local.News{
        return com.mukesh.module.domain.model.local.News(
            author = author,
            content = content,
            description = description,
            publishedAt = publishedAt,
            title = title,
            url = url,
            urlToImage = urlToImage,
            sourceId = source?.id,
            sourceName = source?.name,
        )

    }

    companion object{
        @JvmStatic
        fun getSampleNews(): News{
            return News(
                author = "Zach Crizer",
                content ="The Astros walloped three home runs off the Yankees bullpen and Justin Verlander clicked into Cy Young form as Houston seized Game 1 of the ALCS, 4-2.\\r\\nAfter an early exchange of runs, the teams ente… [+2644 chars]",
                 description = "The Astros have felled the Yankees in their last two ALCS appearances, and they took the first step toward winning a third in Game 1.",
                 publishedAt = "2022-10-20T06:45:19Z",
                source = Source(id = "cnn" , name = "CNN"),
                title = "MLB playoffs: Astros slug three homers off Yankees bullpen, take ALCS Game 1 behind Justin Verlander gem - Yahoo Sports",
                url = "https://sports.yahoo.com/mlb-playoffs-yankees-astros-alcs-game-1-justin-verlander-aaron-judge-jameson-taillon-222714652.html",
                urlToImage = "https://s.yimg.com/ny/api/res/1.2/ZB2XNsVs.Qe4l1Mofh14jw--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDA-/https://s.yimg.com/os/creatr-uploaded-images/2022-10/9055b060-501a-11ed-bdbf-ddf1a0f6d329"
            )
        }
    }

    fun getPublishedDate(): String{
       return Util.getFormattedPublishedData(publishedAt)
    }

    fun getPublishedDateWithDay(): String{
        return Util.getFormattedPublishedData(publishedAt, Util.UI_NEWS_PUBLISHED_AT_FORMAT_DATE_WITH_DAY)
    }

    fun getPublishedTime(): String{
        return Util.getFormattedPublishedTime(publishedAt)
    }
}