package com.github.mrindeciso.advanced_dialogs.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

abstract class BaseBottomSheetDialog(
        context: Context,
        private val onDismiss: (() -> Boolean)?,
        private val autoDismiss: Boolean
) {

    private val _dialog = BottomSheetDialog(context)
    protected val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    protected fun <T: ViewBinding> render(binding: T) {
        _dialog.setContentView(binding.root)
    }

    protected fun render(view: View) {
        _dialog.setContentView(view)
    }

    protected fun render(@LayoutRes viewRes: Int) {
        _dialog.setContentView(viewRes)
    }

    protected fun show() {
        _dialog.show()
    }

}