package com.mrindeciso.advanced_dialogs.extensions

import android.view.View

fun ((View) -> Unit).toOnClickListener(): View.OnClickListener {
    return View.OnClickListener(this)
}