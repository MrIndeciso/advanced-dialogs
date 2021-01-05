package com.mrindeciso.advanced_dialogs.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.mrindeciso.advanced_dialogs.customDialog.CustomDialog
import com.mrindeciso.advanced_dialogs.customDialog.CustomDialogInterface
import com.mrindeciso.advanced_dialogs.customDialog.DialogInflater

fun <T : ViewBinding> AppCompatActivity.showDialog(
    impl: CustomDialogInterface<T>
): CustomDialog<T> {
    return object : CustomDialog<T>(
        this,
        impl::render,
        impl::onDismiss,
        impl.autoDismiss,
    ) {}
}

fun <T : ViewBinding> AppCompatActivity.showDialog(
    impl: DialogInflater<T>
): CustomDialog<T> {
    return object : CustomDialog<T>(
        this,
        impl::render,
    ) {}
}

fun <T : ViewBinding> Fragment.showDialog(
    impl: CustomDialogInterface<T>
): CustomDialog<T> {
    return object : CustomDialog<T>(
        requireContext(),
        impl::render,
        impl::onDismiss,
        impl.autoDismiss,
    ) {}
}

fun <T : ViewBinding> Fragment.showDialog(
    impl: DialogInflater<T>
): CustomDialog<T> {
    return object : CustomDialog<T>(
        requireContext(),
        impl::render,
    ) {}
}