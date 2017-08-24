package com.dwarvesf.griffin_survey.view.login

import android.os.Bundle
import com.dwarvesf.griffin_survey.R
import com.dwarvesf.griffin_survey.view.base.BaseActivity
import com.dwarvesf.griffin_survey.view.base.FormView

class LoginActivity : BaseActivity(), FormView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSubmitCompleted() {
    }
}