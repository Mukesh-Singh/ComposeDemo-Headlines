package com.mukesh.module.data.exceptions

import java.io.IOException

/**
Created by Mukesh on 21/10/22
 **/

class APIConnectivityException(override val message: String?, override val cause: Throwable?) : IOException(message, cause) {
companion object{
    const val CODE= 800
}

}