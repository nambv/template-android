package com.dwarvesf.griffin_survey.util

import timber.log.Timber

class LoggerManager  : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement?): String {
        val tag = super.createStackElementTag(element)
        val methodName = element?.methodName
        val lineNumber = element?.lineNumber
        return "$tag $methodName:$lineNumber"
    }
}