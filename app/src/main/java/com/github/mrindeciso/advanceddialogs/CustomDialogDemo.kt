package com.github.mrindeciso.advanceddialogs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mrindeciso.advanced_dialogs.extensions.showDialog
import com.github.mrindeciso.advanceddialogs.databinding.ActivityCustomdialogdemoBinding
import com.github.mrindeciso.advanceddialogs.databinding.DialogCustomdialog1Binding

class CustomDialogDemo : AppCompatActivity() {

    private lateinit var binding: ActivityCustomdialogdemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustomdialogdemoBinding.inflate(layoutInflater)

        binding.showCustomDialog1.setOnClickListener {
            showCustomDialog1()
        }
    }

    private fun showCustomDialog1() {
        showDialog(
                render = { inflater ->
                    DialogCustomdialog1Binding.inflate(inflater).also {

                    }
                },
                onDismiss = {

                }
        )
    }

}