package com.dwarvesf.griffin_survey.di.component

import com.dwarvesf.griffin_survey.di.module.AppModule
import com.dwarvesf.griffin_survey.di.module.NetworkModule
import com.dwarvesf.griffin_survey.di.module.StorageModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, StorageModule::class))
interface AppComponent {
}