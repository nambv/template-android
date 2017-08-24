package com.dwarvesf.griffin_survey.view.base

import android.support.annotation.StringRes

interface FormView  : BaseView {
    fun onSubmitCompleted()
    fun showProgressDialog(@StringRes messageResId: Int)
    fun dismissProgressDialog()
}