package com.github.mrindeciso.advanced_dialogs.extensions

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.github.mrindeciso.advanced_dialogs.customDialog.CustomDialog
import com.github.mrindeciso.advanced_dialogs.customDialog.CustomDialogInterface
import com.github.mrindeciso.advanced_dialogs.customDialog.DialogInflater

fun <T : ViewBinding> AppCompatActivity.showDialog(
        impl: CustomDialogInterface<T>
): CustomDialog<T> {
    return object : CustomDialog<T>(
            this,
            impl::render,
            impl::onDismiss,
            impl.autoDismiss,
    ) {}.also {
        impl.dismiss = { it.dismiss() }
        it.show()
        if (impl.makeBackgroundTransparent) {
            it.changeBackgroundDrawable(impl.preserveLateralMargin)
        }
    }
}

fun <T : ViewBinding> AppCompatActivity.showDialog(
        render: (LayoutInflater) -> T,
        onDismiss: (() -> Unit)? = null,
        autoDismiss: Boolean = true
): CustomDialog<T> {
    return object : CustomDialog<T>(
            this,
            render,
            onDismiss,
            autoDismiss
    ) {}.also {
        it.show()
    }
}

fun <T : ViewBinding> AppCompatActivity.showDialog(
        impl: DialogInflater<T>
): CustomDialog<T> {
    return object : CustomDialog<T>(
            this,
            impl::render,
    ) {}.also { it.show() }
}

fun <T : ViewBinding> Fragment.showDialog(
        impl: CustomDialogInterface<T>
): CustomDialog<T> {
    return object : CustomDialog<T>(
            requireContext(),
            impl::render,
            impl::onDismiss,
            impl.autoDismiss,
    ) {}.also {
        impl.dismiss = { it.dismiss() }
        it.show()
        if (impl.makeBackgroundTransparent) {
            it.changeBackgroundDrawable(impl.preserveLateralMargin)
        }
    }
}

fun <T : ViewBinding> Fragment.showDialog(
        render: (LayoutInflater) -> T,
        onDismiss: (() -> Unit)? = null,
        autoDismiss: Boolean = true
): CustomDialog<T> {
    return object : CustomDialog<T>(
            requireContext(),
            render,
            onDismiss,
            autoDismiss
    ) {}.also { it.show() }
}

fun <T : ViewBinding> Fragment.showDialog(
        impl: DialogInflater<T>
): CustomDialog<T> {
    return object : CustomDialog<T>(
            requireContext(),
            impl::render,
    ) {}.also { it.show() }
}