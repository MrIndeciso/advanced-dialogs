package com.mrindeciso.advanced_dialogs.customDialog

import android.content.Context
import androidx.viewbinding.ViewBinding

open class DialogManager(
    private val context: Context
) {

    private var systematicOperation: ((ViewBinding) -> Unit)? = null

    fun <T : ViewBinding> show(impl: CustomDialogInterface<T>): CustomDialog<T> {
        return object : CustomDialog<T>(
            context,
            impl::render,
            impl::onDismiss,
            impl.autoDismiss,
            systematicOperation
        ) {}.also { it.show() }
    }

    fun <T : ViewBinding> show(impl: DialogInflater<T>): CustomDialog<T> {
        return object : CustomDialog<T>(
            context,
            impl::render,
            systematicLayoutOperation = systematicOperation
        ) {}.also { it.show() }
    }

}