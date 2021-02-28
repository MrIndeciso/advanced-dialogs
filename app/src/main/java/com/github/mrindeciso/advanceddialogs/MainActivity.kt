package com.github.mrindeciso.advanceddialogs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.mrindeciso.advanced_dialogs.customDialog.CustomDialog
import com.github.mrindeciso.advanceddialogs.databinding.ActivityMainBinding
import com.github.mrindeciso.advanceddialogs.databinding.DialogCustomBinding
import com.github.mrindeciso.common_dialogs.InfoDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity: AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).also {
            mainBinding = it
            setContentView(it.root)
        }
    }

    override fun onStart() {
        super.onStart()

        mainBinding.buttonCustom.setOnClickListener {
            CustomDialog(this, { inflater ->
                DialogCustomBinding.inflate(inflater).also {
                    it.textView.text = "Test"
                    it.button.text = "Test"
                }
            }).show()
        }

        mainBinding.buttonCustomFragment.setOnClickListener {
            startActivity(Intent(this, CustomDialogDemo::class.java))
        }

        mainBinding.buttonAlertDialog.setOnClickListener {
            InfoDialog(this,
                    title = R.string.alertdialog_tvtitle,
                    message = R.string.alertdialog_tvmessage,
                    positiveButton = R.string.alertdialog_bttpos,
                    negativeButton = R.string.alertdialog_bttneg,
                    onPositiveButtonClick = {
                        Log.i("MainActivity", "Positive button clicked")
                    },
                    onNegativeButtonClick = {
                        Log.i("MainActivity", "Negative button clicked")
                    }
            )

            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.alertdialog_tvtitle)
                .setMessage(R.string.alertdialog_tvmessage)
                .setNegativeButton(R.string.alertdialog_bttneg) { _, _ ->
                    Log.i("MainActivity", "Negative button clicked")
                }
                .setPositiveButton(R.string.alertdialog_bttpos) { _, _ ->
                    Log.i("MainActivity", "Positive button clicked")
                }
                .show()
        }
    }

}