package com.dwarvesf.griffin_survey.view.base.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.dwarvesf.griffin_survey.util.listener.EndlessRecyclerOnScrollListener
import com.dwarvesf.griffin_survey.view.base.BaseActivity
import kotlinx.android.synthetic.main.fragment_base_list.*
import kotlinx.android.synthetic.main.layout_load_more.*

abstract class BaseListActivity<T> : BaseActivity(), BaseListView<T> {

    lateinit var onScrollListener: EndlessRecyclerOnScrollListener
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayoutManager = LinearLayoutManager(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun setupRecyclerView() {
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.addOnScrollListener(onScrollListener)
    }

    override fun showRefreshing() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideRefreshing() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showLoadMore() {
        layoutLoadMore.visibility = View.VISIBLE
    }

    override fun hideLoadMore() {
        layoutLoadMore.visibility = View.GONE
    }
}