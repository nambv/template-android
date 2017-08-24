package com.dwarvesf.griffin_survey.interactor

import com.dwarvesf.griffin_survey.service.NetworkService
import javax.inject.Inject

class MainInteractorImpl @Inject constructor() : MainInteractor {

    @Inject lateinit var networkService: NetworkService
}
