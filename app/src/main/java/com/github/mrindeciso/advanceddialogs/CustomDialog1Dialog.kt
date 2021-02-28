package com.github.mrindeciso.advanceddialogs

import android.view.LayoutInflater
import com.github.mrindeciso.advanced_dialogs.customDialog.CustomDialogInterface
import com.github.mrindeciso.advanceddialogs.databinding.DialogCustomdialog1Binding

class CustomDialog1Dialog : CustomDialogInterface<DialogCustomdialog1Binding>() {

    override fun render(inflater: LayoutInflater): DialogCustomdialog1Binding {
        return DialogCustomdialog1Binding.inflate(inflater).also { binding ->
            binding.bttOpt1.setOnClickListener {
                dismiss()
            }
        }
    }

}