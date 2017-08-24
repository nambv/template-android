package com.dwarvesf.griffin_survey.util

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View

/**
 * @author timmutton
 */
fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit = {}) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}

fun Snackbar.action(@StringRes action: Int, color: Int? = null, listener: (View) -> Unit = {}) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}

fun Snackbar.actionClick(@StringRes action: Int, color: Int? = null, listener: View.OnClickListener) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}

fun Snackbar.actionDismiss(@StringRes action: Int, color: Int? = null, listener: (View) -> Unit = { this.dismiss() }) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}
