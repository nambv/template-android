package com.dwarvesf.griffin_survey

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric



class GriffinSurveyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
    }
}