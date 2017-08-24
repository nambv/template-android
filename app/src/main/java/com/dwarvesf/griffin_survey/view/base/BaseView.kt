package com.dwarvesf.griffin_survey.view.base

import android.content.Context
import android.content.DialogInterface
import android.support.annotation.StringRes

interface BaseView {
    fun getContext(): Context
    fun showMessage(message: String)
    fun showMessage(@StringRes messageResId: Int)
    fun showAlertDialog(title: String?, message: String)
    fun showAlertDialog(@StringRes titleResId: Int, @StringRes messageResId: Int)
    fun showAlertDialog(@StringRes title: Int, messageResId: String, listener: DialogInterface.OnClickListener)
}