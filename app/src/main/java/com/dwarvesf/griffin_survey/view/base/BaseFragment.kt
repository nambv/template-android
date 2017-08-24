package com.dwarvesf.griffin_survey.view.base

import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.KeyEvent
import android.view.View
import com.dwarvesf.griffin_survey.util.toast


open class BaseFragment : Fragment(), BaseView, View.OnKeyListener {

    var fetchDataInterface: FetchData? = null
    var isLoaded = false
    var isFragmentVisible = false

    override fun showMessage(message: String) = activity.toast(message)
    override fun showMessage(messageResId: Int) = activity.toast(getString(messageResId))
    override fun showAlertDialog(title: String?, message: String) = (activity as BaseActivity).showAlertDialog(title, message)
    override fun showAlertDialog(titleResId: Int, messageResId: Int) = (activity as BaseActivity).showAlertDialog(titleResId, messageResId)
    override fun showAlertDialog(title: Int, messageResId: String, listener: DialogInterface.OnClickListener)
            = (activity as BaseActivity).showAlertDialog(title, messageResId, listener)

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
        if (event.action == KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                onBackButtonPressed()
                return true
            }
        }
        return false
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        if (isVisibleToUser) {
            isFragmentVisible = true
            if (view != null && !isLoaded) {
                isLoaded = true
                fetchDataInterface?.fetchData()
            }
        }
        super.setUserVisibleHint(isVisibleToUser)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isLoaded && isFragmentVisible) {
            Log.d("api", "load on view created")
            isLoaded = true
            fetchDataInterface?.fetchData()
        }
    }

    interface FetchData {
        fun fetchData()
    }

    open fun onBackButtonPressed() {
        activity.onBackPressed()
    }
}