package com.mukesh.headlines.presentation.rout

/**
Created by Mukesh on 02/11/22
 **/

sealed class Rout (val rout: String){
    companion object{
        //paths
        private const val SEGMENT_HOME = "home"
        private const val SEGMENT_HEADLINE_VIEW_ALL = "view_all"
        private const val SEGMENT_NEWS_DETAILS = "news_details"
    }

    //Routs
    object HOME : Rout(rout = SEGMENT_HOME)
    object HEADLINE_VIEW_ALL: Rout(rout = SEGMENT_HEADLINE_VIEW_ALL)
    object NEWS_DETAILS: Rout(rout = "$SEGMENT_NEWS_DETAILS/{news_id}"){
        fun buildUrl(newsId: String): String{
            return "$SEGMENT_NEWS_DETAILS/$newsId"
        }
    }
}