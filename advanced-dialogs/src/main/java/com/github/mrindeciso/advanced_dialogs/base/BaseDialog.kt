package com.github.mrindeciso.advanced_dialogs.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.viewbinding.ViewBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

abstract class BaseDialog(
        context: Context,
        private val onDismiss: (() -> Unit)?,
        private val autoDismiss: Boolean
) {

    private val _dialogBuilder = MaterialAlertDialogBuilder(context)
    private var _dialog: AlertDialog? = null
    protected val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    init {
        _dialogBuilder.setOnDismissListener {
            onDismiss?.invoke()
        }
    }

    protected val dialogInterface = object: DialogInterface {
        override fun dismiss() = _dialog!!.dismiss()
    }

    protected fun <T: ViewBinding> render(binding: T) {
        _dialogBuilder.setView(binding.root)
    }

    protected fun render(view: View) {
        _dialogBuilder.setView(view)
    }

    protected fun render(@LayoutRes viewRes: Int) {
        _dialogBuilder.setView(viewRes)
    }

    protected fun showDialog() {
        _dialog = _dialogBuilder.show()
        _dialog?.setCanceledOnTouchOutside(autoDismiss)
    }

}