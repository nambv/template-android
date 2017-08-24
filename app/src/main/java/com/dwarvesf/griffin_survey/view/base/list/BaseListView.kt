package com.dwarvesf.griffin_survey.view.base.list

import com.dwarvesf.griffin_survey.view.base.BaseView

interface BaseListView<T> : BaseView {
    fun showRefreshing()
    fun hideRefreshing()
    fun showLoadMore()
    fun hideLoadMore()
    fun onResultsReceived(data: MutableList<T>, offset: Int)
}