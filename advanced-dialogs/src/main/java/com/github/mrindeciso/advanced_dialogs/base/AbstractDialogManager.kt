package com.github.mrindeciso.advanced_dialogs.base

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.github.mrindeciso.advanced_dialogs.customDialog.CustomDialog
import com.github.mrindeciso.advanced_dialogs.customDialog.CustomDialogInterface
import com.github.mrindeciso.advanced_dialogs.customDialog.DialogInflater

abstract class AbstractDialogManager {

    abstract var systematicOperation: ((ViewBinding) -> Unit)?

    open fun <T : ViewBinding> show(
        context: Context,
        impl: CustomDialogInterface<T>
    ): CustomDialog<T> {
        return object : CustomDialog<T>(
            context,
            impl::render,
            impl::onDismiss,
            impl.autoDismiss,
            systematicOperation
        ) {}.also {
            it.show()
            impl.dismiss = { it.dismiss() }
            if (impl.makeBackgroundTransparent) {
                it.overrideBackgroundDrawable()
            }
        }
    }

    open fun <T : ViewBinding> show(context: Context, impl: DialogInflater<T>): CustomDialog<T> {
        return object : CustomDialog<T>(
            context,
            impl::render,
            systematicLayoutOperation = systematicOperation
        ) {}.also { it.show() }
    }

}