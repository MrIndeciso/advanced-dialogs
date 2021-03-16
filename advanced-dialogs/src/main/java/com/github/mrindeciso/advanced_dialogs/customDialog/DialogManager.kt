package com.github.mrindeciso.advanced_dialogs.customDialog

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.github.mrindeciso.advanced_dialogs.base.AbstractDialogManager

open class DialogManager(
    private val context: Context
) : AbstractDialogManager() {

    var systematicOperation: ((ViewBinding) -> Unit)? = null

    override val _systematicOperation: (ViewBinding) -> Unit
        get() = systematicOperation!!

    fun <T : ViewBinding> show(impl: CustomDialogInterface<T>): CustomDialog<T> =
        show(context, impl)

    fun <T : ViewBinding> show(impl: DialogInflater<T>): CustomDialog<T> = show(context, impl)

}