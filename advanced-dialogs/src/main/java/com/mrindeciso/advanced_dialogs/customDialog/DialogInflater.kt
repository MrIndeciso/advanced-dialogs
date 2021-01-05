package com.mrindeciso.advanced_dialogs.customDialog

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

fun interface DialogInflater<T : ViewBinding> {

    fun render(inflater: LayoutInflater): T

}