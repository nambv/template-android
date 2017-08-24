package com.dwarvesf.griffin_survey.view.base.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dwarvesf.griffin_survey.R
import com.dwarvesf.griffin_survey.util.listener.EndlessRecyclerOnScrollListener
import com.dwarvesf.griffin_survey.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_base_list.*
import kotlinx.android.synthetic.main.layout_load_more.*

abstract class BaseListFragment<T> : BaseFragment(), BaseListView<T> {

    lateinit var onScrollListener: EndlessRecyclerOnScrollListener
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_base_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager = LinearLayoutManager(activity)
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
