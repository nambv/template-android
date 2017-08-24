package com.dwarvesf.griffin_survey.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import com.dwarvesf.griffin_survey.R
import com.dwarvesf.griffin_survey.model.ErrorBody
import retrofit2.HttpException
import retrofit2.Retrofit
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.util.concurrent.TimeoutException

/**
 * Check: http://antonioleiva.com/kotlin-awesome-tricks-for-android/
 * For API examples: http://antonioleiva.com/api-request-kotlin/
 */

fun View.snackBarMessage(message: String, duration: Int = Snackbar.LENGTH_SHORT, init: Snackbar.() -> Unit = {}): Snackbar {
    val snackBar = Snackbar.make(this, message, duration)
    snackBar.init()
    snackBar.show()
    return snackBar
}

fun View.snackBarMessageResId(@StringRes text: Int, duration: Int = Snackbar.LENGTH_SHORT, init: Snackbar.() -> Unit = {}): Snackbar {
    val snackBar = Snackbar.make(this, text, duration)
    snackBar.init()
    snackBar.show()
    return snackBar
}

fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun createMessage(context: Context, throwable: Throwable, retrofit: Retrofit): String {

    if (throwable is HttpException) {
        if (throwable.response().errorBody() != null) {
            val errorConverter = retrofit.responseBodyConverter<ErrorBody>(ErrorBody::class.java, arrayOfNulls<Annotation>(0))
            val errorBody = errorConverter.convert(throwable.response().errorBody())
            return errorBody.error
        }
    } else if (throwable is TimeoutException || throwable is SocketTimeoutException || throwable is ConnectException) {
        return context.getString(R.string.msg_connection_timeout)
    }

    return ""
}

fun isNetworkConnected(context: Context): Boolean {
    val activeNetwork = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
}