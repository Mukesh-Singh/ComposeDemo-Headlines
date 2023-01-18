package com.mukesh.module.domain.model.network


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.mukesh.module.domain.util.SourceCountry
import com.mukesh.module.domain.util.SourceLanguage
import org.json.JSONObject
import java.util.*


@Parcelize
data class Source(
    @SerializedName("category")
    val category: String? = null, // general
    @SerializedName("country")
    val country: String? = null, // us
    @SerializedName("description")
    val description: String? = null, // Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.
    @SerializedName("id")
    val id: String? = null, // abc-news
    @SerializedName("language")
    val language: String? = null, // en
    @SerializedName("name")
    val name: String? = null, // ABC News
    @SerializedName("url")
    val url: String? = null // https://abcnews.go.com
) : Parcelable {
    fun getCategoryName(): String?{
        category?.let {
            return it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }?: kotlin.run { return null }
    }
    fun getCountryName(): String?{
        return country?.let { SourceCountry.getCountryName(it) }
    }

    fun getLanguageName(): String?{
        return language?.let { SourceLanguage.getLanguageName(it) }
    }

    companion object {
        private const val sampleJSon = """
            {
            "id": "abc-news",
            "name": "ABC News",
            "description": "Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.",
            "url": "https://abcnews.go.com",
            "category": "general",
            "language": "en",
            "country": "us"
        }
        """
        @JvmStatic
        fun buildFromJson(jsonObject: JSONObject?): Source? {

            jsonObject?.run {
                return Source(
                    optString("category"),
                    optString("country"),
                    optString("description"),
                    optString("id"),
                    optString("language"),
                    optString("name"),
                    optString("url")
                )
            }
            return null
        }

        fun getSampleSource(): Source?{
            return buildFromJson(JSONObject(sampleJSon))
        }
    }
}