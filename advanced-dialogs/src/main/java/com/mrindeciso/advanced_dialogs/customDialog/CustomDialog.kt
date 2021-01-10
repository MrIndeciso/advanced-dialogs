package com.mrindeciso.advanced_dialogs.customDialog

import android.content.Context
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.mrindeciso.advanced_dialogs.base.BaseDialog

open class CustomDialog<T : ViewBinding> internal constructor(
    context: Context,
    render: (LayoutInflater) -> T,
    onDismiss: (() -> Unit)? = null,
    autoDismiss: Boolean = true,
    systematicLayoutOperation: ((T) -> Unit)? = null,
) : BaseDialog(context, onDismiss, autoDismiss) {

    constructor(
        context: Context,
        render: (LayoutInflater) -> T,
        onDismiss: (() -> Unit)? = null,
        autoDismiss: Boolean = true,
    ) : this(context, render, onDismiss, autoDismiss, null)

    init {
        val layout = render(layoutInflater)
        systematicLayoutOperation?.invoke(layout)
        render(layout)
    }

    fun show() = showDialog()

}