package com.github.mrindeciso.advanced_dialogs.customDialog

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class CustomDialogInterface<out T : ViewBinding>(
    val autoDismiss: Boolean = true,
    val makeBackgroundTransparent: Boolean = false,
    val preserveLateralMargin: Boolean = true,
) {

    abstract fun render(inflater: LayoutInflater): T

    fun onDismiss() {}

    var dismiss: () -> Unit = {}

}