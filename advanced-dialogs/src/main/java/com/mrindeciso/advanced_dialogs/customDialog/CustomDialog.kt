package com.mrindeciso.advanced_dialogs.customDialog

import android.content.Context
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.mrindeciso.advanced_dialogs.base.BaseDialog

class CustomDialog<T: ViewBinding>(
        context: Context,
        render: (LayoutInflater) -> T,
        onDismiss: (() -> Unit)? = null,
        autoDismiss: Boolean = true,
): BaseDialog(context, onDismiss, autoDismiss) {

    init {
        val layout = render(layoutInflater)
        render(layout)
        show()
    }

}