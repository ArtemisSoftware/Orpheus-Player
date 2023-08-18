package com.artemissoftware.orpheusplayer.util

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun Context.isPermissionGranted(name: String): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        name,
    ) == PackageManager.PERMISSION_GRANTED
}
/*
fun Activity.shouldShowRationale(name: String): Boolean {
    return shouldShowRequestPermissionRationale(name)
}

fun Context.hasPickMediaPermission(): Boolean {

    return when {
        // If Android Version is Greater than Android Pie!
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> true

        else -> isPermissionGranted(name = READ_EXTERNAL_STORAGE)
    }
}

fun Context.gotoApplicationSettings() {
    startActivity(Intent().apply {
        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        data = Uri.parse("package:${packageName}")
    })
}

fun Context.findActivity(): Activity? {
    return when (this) {
        is Activity -> this
        is ContextWrapper -> {
            baseContext.findActivity()
        }

        else -> null
    }
}
*/
