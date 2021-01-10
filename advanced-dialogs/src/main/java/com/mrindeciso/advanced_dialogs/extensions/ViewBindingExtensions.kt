package com.mrindeciso.advanced_dialogs.extensions

import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.core.view.children
import androidx.viewbinding.ViewBinding

inline fun <reified T : View> ViewBinding.forEachOfType(action: (T) -> Unit) {
    (root as? ViewGroup)
        ?.children
        ?.filterIsInstance(T::class.java)
        ?.forEach(action)
}

inline fun <reified T : View> ViewBinding.forEachOfType(action: (id: Int, view: T) -> Unit) {
    (root as? ViewGroup)
        ?.children
        ?.filterIsInstance(T::class.java)
        ?.toList()
        ?.let { list ->
            list.forEachIndexed { index, view ->
                action(list[index].id, view)
            }
        }
}

fun <T : View> ViewBinding.findViewById(@IdRes viewId: Int): T {
    return root.findViewById(viewId)
}

fun <T : View> ViewBinding.applyToView(@IdRes viewId: Int, action: (T) -> Unit) {
    root.findViewById<T>(viewId)!!.also(action)
}