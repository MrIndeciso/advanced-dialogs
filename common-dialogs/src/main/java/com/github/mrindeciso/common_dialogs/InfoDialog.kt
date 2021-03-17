package com.github.mrindeciso.common_dialogs

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.github.mrindeciso.advanced_dialogs.base.BaseDialog
import com.github.mrindeciso.advanced_dialogs.base.DialogInterface
import com.github.mrindeciso.common_dialogs.databinding.AdAlertDialogBinding

class InfoDialog(
        context: Context,
        @StringRes title: Int? = null,
        @DrawableRes titleIconRes: Int? = null,
        titleIcon: Drawable? = null,
        @StringRes message: Int? = null,
        @StringRes positiveButton: Int? = null,
        @StringRes negativeButton: Int? = null,
        onPositiveButtonClick: ((DialogInterface) -> Unit)? = null,
        onNegativeButtonClick: ((DialogInterface) -> Unit)? = null,
        additionalLayoutOperations: ((AdAlertDialogBinding) -> Unit)? = null,
        onDismiss: (() -> Unit)? = null,
        allowAutoDismiss: Boolean = true
): BaseDialog(context, onDismiss, allowAutoDismiss) {

    init {
        val layout = AdAlertDialogBinding.inflate(layoutInflater)

        title?.also { layout.adTvTitle.setText(it) }
        titleIconRes?.also { layout.adTvTitle.setCompoundDrawables(ContextCompat.getDrawable(context, it), null, null, null) }
        titleIcon?.also { layout.adTvTitle.setCompoundDrawables(it, null, null, null) }

        message?.also { layout.adTvBody.setText(it) }

        positiveButton?.also { layout.adBttPos.setText(it) }
        negativeButton?.also { layout.adBttNeg.setText(it) }

        onPositiveButtonClick?.also { listener ->
            layout.adBttPos.setOnClickListener {
                listener(dialogInterface)
                if (allowAutoDismiss) dialogInterface.dismiss()
            }
        }
        onNegativeButtonClick?.also { listener ->
            layout.adBttNeg.setOnClickListener {
                listener(dialogInterface)
                if (allowAutoDismiss) dialogInterface.dismiss()
            }
        }

        additionalLayoutOperations?.invoke(layout)

        render(layout)

        dialogInterface.show()
    }

}