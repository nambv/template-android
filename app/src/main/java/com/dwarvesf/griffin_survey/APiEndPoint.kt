package com.dwarvesf.griffin_survey

object APiEndPoint {

    const val STAGING_API = "http://griffin.dwarvesf.com"

    // region OnBoarding

    const val LOGIN_API = "/api/v1/users/login"
    const val LOGOUT_API = "/api/v1/users/logout"
    const val ME_API = "/api/v1/users/me"
    const val REGISTER_API = "/api/v1/users/register"
    const val UPDATE_PASSWORD_API = "/api/v1/users/update_password"

    // endregion

    // region Campaigns

    const val CAMPAIGNS_API = "/api/v1/campaigns"
    const val CAMPAIGN_API = "/api/v1/campaigns/{id}"

    // endregion

    // region Surveys

    const val SURVEYS_API = "/api/v1/surveys"
    const val SURVEY_API = "/api/v1/surveys/{id}"
    const val SURVEY_MEDIA_API = "/api/v1/surveys/{id}/upload_media"
    const val SURVEY_UPLOAD_API = "/api/v1/surveys/{id}/submit"

    // endregion

    // region Stores

    const val STORES_API = "/api/v1/stores"
    const val STORE_API = "/api/v1/stores/{id}"

    // endregion

    // region User Stores / Surveys

    const val USER_STORES_API = "/api/v1/users/stores"
    const val USER_SURVEYS_API = "/api/v1/users/stores/{store_id}/surveys"

    // endregion
}