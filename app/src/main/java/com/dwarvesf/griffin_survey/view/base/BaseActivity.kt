@file:Suppress("DEPRECATION")

package com.dwarvesf.griffin_survey.view.base

import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.dwarvesf.griffin_survey.util.hideSoftKeyboard
import com.dwarvesf.griffin_survey.util.toast


open class BaseActivity : AppCompatActivity(), BaseView {

    private var mProgressDialog: ProgressDialog? = null
    private var mAlertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mProgressDialog = ProgressDialog(this)
        mAlertDialog = AlertDialog.Builder(this).create()

    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun setupUI(view: View) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (view !is EditText) {
            view.setOnTouchListener { _, _ ->
                hideSoftKeyboard()
                false
            }
        }

        // If a layout container, iterate over children and seed recursion.
        if (view is ViewGroup) {
            for (i in 0..(view as ViewGroup).childCount - 1) {
                val innerView = (view as ViewGroup).getChildAt(i)
                setupUI(innerView)
            }
        }
    }

    fun setTitleActionBar(@StringRes titleResId: Int) = supportActionBar?.setTitle(titleResId)

    fun showProgressDialog(message: String) {
        mProgressDialog?.setCancelable(false)
        mProgressDialog?.setMessage(message)
        if (mProgressDialog?.isShowing == false) mProgressDialog?.show()
    }

    fun showProgressDialog(@StringRes messageResId: Int) {
        mProgressDialog?.setCancelable(false)
        mProgressDialog?.setMessage(getString(messageResId))
        if (mProgressDialog?.isShowing == false) mProgressDialog?.show()
    }

    fun dismissProgressDialog() {
        if (mProgressDialog?.isShowing == true) mProgressDialog?.dismiss()
    }

    fun showAlertDialog() {
        if (mAlertDialog?.isShowing == false) mAlertDialog?.show()
    }

    fun dismissAlertDialog() {
        if (mAlertDialog?.isShowing == true) mAlertDialog?.dismiss()
    }

    override fun showAlertDialog(@StringRes title: Int, messageResId: String, listener: DialogInterface.OnClickListener) {
        mAlertDialog?.setTitle(getString(title))
        mAlertDialog?.setMessage(messageResId)
        mAlertDialog?.setButton(AlertDialog.BUTTON_POSITIVE, "OK", listener)
        if (mAlertDialog?.isShowing == false) mAlertDialog?.show()
    }

    override fun showAlertDialog(title: String?, message: String) {
        if (title != null) mAlertDialog?.setTitle(title)
        mAlertDialog?.setMessage(message)
        mAlertDialog?.setButton(AlertDialog.BUTTON_POSITIVE, "OK", { _, _ -> mAlertDialog?.dismiss() })
        mAlertDialog?.show()
    }

    override fun showAlertDialog(titleResId: Int, messageResId: Int) {
        mAlertDialog?.setTitle(getString(titleResId))
        mAlertDialog?.setMessage(getString(messageResId))
        mAlertDialog?.setButton(AlertDialog.BUTTON_POSITIVE, "OK", { _, _ -> mAlertDialog?.dismiss() })
        mAlertDialog?.show()
    }

    override fun getContext(): Context = this
    override fun showMessage(message: String) = toast(message)
    override fun showMessage(messageResId: Int) = toast(getString(messageResId))
}