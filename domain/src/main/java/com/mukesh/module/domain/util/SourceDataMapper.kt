package com.mukesh.module.domain.util

import java.util.*
import kotlin.collections.HashMap

/**
Created by Mukesh on 28/10/22
 **/

internal class SourceLanguage {
    private val languageMap: HashMap<String, String> = hashMapOf<String, String>()
    init {
        languageMap["ar"] = "Arabic"
        languageMap["de"] = "German"
        languageMap["en"] = "English"
        languageMap["es"] = "Spanish"
        languageMap["fr"] = "French"
        languageMap["he"] = "Hebrew"
        languageMap["it"] = "Italian"
        languageMap["nl"] = "Dutch"
        languageMap["no"] = "Norwegian"
        languageMap["pt"] = "Portuguese"
        languageMap["ru"] = "Russian"
        languageMap["sv"] = "Swedish"
        languageMap["ud"] = "Urdu"
        languageMap["zh"] = "Chinese"
    }

    companion object{
        private val instance: SourceLanguage= SourceLanguage()
        fun getLanguageName(languageId: String): String? {
            val name = instance.languageMap[languageId]
            name?.let {
                return it
            }?: kotlin.run {
                return languageId.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
        }
    }
}


internal class SourceCountry {
    private val countryMap: HashMap<String, String> = hashMapOf<String, String>()
    init {
        countryMap["ae"] = "United Arab Emirates"
        countryMap["ar"] = "Argentina"
        countryMap["at"] = "Austria"
        countryMap["au"] = "Australia"
        countryMap["be"] = "Belgium"
        countryMap["bg"] = "Bulgaria"
        countryMap["br"] = "Brazil"
        countryMap["ca"] = "Canada"
        countryMap["ch"] = "Switzerland"
        countryMap["cn"] = "China"
        countryMap["co"] = "Colombia"
        countryMap["cu"] = "Cuba"
        countryMap["cz"] = "Czech Republic"
        countryMap["de"] = "Germany"
        countryMap["eg"] = "Egypt"
        countryMap["fr"] = "France"
        countryMap["gb"] = "United Kingdom"
        countryMap["gr"] = "Greece"
        countryMap["hk"] = "Hong Kong"
        countryMap["hu"] = "Hungary"
        countryMap["id"] = "Indonesia"
        countryMap["ie"] = "Ireland"
        countryMap["il"] = "Israel"
        countryMap["in"] = "India"
        countryMap["it"] = "Italy"
        countryMap["jp"] = "Japan"
        countryMap["kr"] = "South Korea"
        countryMap["lt"] = "Lithuania"
        countryMap["lv"] = "Latvia"
        countryMap["ma"] = "Morocco"
        countryMap["mx"] = "Mexico"
        countryMap["my"] = "Malaysia"
        countryMap["ng"] = "Nigeria"
        countryMap["nl"] = "Netherlands"
        countryMap["no"] = "Norway"
        countryMap["nz"] = "New Zealand"
        countryMap["ph"] = "Philippines"
        countryMap["pl"] = "Poland"
        countryMap["pt"] = "Portugal"
        countryMap["ro"] = "Romania"
        countryMap["rs"] = "Serbia"
        countryMap["ru"] = "Russia"
        countryMap["sa"] = "Saudi Arabia"
        countryMap["se"] = "Sweden"
        countryMap["sg"] = "Singapore"
        countryMap["si"] = "Slovenia"
        countryMap["sk"] = "Slovakia"
        countryMap["th"] = "Thailand"
        countryMap["tr"] = "Turkey"
        countryMap["tw"] = "Taiwan"
        countryMap["ua"] = "Ukraine"
        countryMap["us"] = "United States"
        countryMap["ve"] = "Venezuela"
        countryMap["za"] = "Zambia"
    }

    companion object{
        private val instance: SourceCountry= SourceCountry()
        fun getCountryName(countryId: String): String? {
            val name = instance.countryMap[countryId]
            name?.let {
                return it
            }?: kotlin.run {
                return countryId.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            }
        }
    }
}