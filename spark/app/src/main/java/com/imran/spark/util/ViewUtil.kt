package com.imran.spark.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * Created by imran on 2020-09-28.
 */
fun View.snackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }
    }.show()
}

