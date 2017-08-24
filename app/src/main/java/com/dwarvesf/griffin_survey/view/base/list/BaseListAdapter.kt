package com.dwarvesf.griffin_survey.view.base.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup

/**
 * Used to extended list adapter for RecyclerView
 */
abstract class BaseListAdapter<T>(protected var mContext: Context, objects: MutableList<T>) : RecyclerView.Adapter<ViewHolder>() {

    protected var mObjects: MutableList<T> = mutableListOf()

    abstract fun setViewHolder(parent: ViewGroup): ViewHolder
    abstract fun onBindData(holder: ViewHolder, `val`: T, position: Int)

    init {
        mObjects = objects
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = setViewHolder(parent)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBindData(holder, mObjects[position], position)
    }

    override fun getItemCount(): Int {
        return mObjects.size
    }

    open fun removeItem(position: Int) {
        mObjects.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, mObjects.size)
    }
}
