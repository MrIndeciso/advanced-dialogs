package com.github.mrindeciso.advanced_dialogs.customDialog

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class CustomDialogInterface<out T : ViewBinding> {

    abstract fun render(inflater: LayoutInflater): T

    fun onDismiss() {}

    var dismiss: () -> Unit = {}

    val autoDismiss: Boolean = true

}