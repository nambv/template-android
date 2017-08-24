package com.dwarvesf.griffin_survey.di.module

import android.app.Application
import android.content.res.Resources
import com.dwarvesf.griffin_survey.GriffinSurveyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    var app: GriffinSurveyApp

    constructor(app: GriffinSurveyApp) {
        this.app = app
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideResources(): Resources = app.resources
}