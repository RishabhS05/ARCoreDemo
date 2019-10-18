package com.example.arcoredemo

import android.Manifest.permission.CAMERA
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object CameraPermissionHelper {

    private val CAMERA_PERMISSION_CODE = 0

    val permissionArray = arrayOf(CAMERA)
    /** Check to see we have the necessary permissions for this app. */
    public fun  hasCameraPermission(activity:Activity): Boolean{
        return ContextCompat.checkSelfPermission(activity, CAMERA)== PackageManager.PERMISSION_GRANTED
    }

    /** Check to see we have the necessary permissions for this app, and ask for them if we don't. */
    public fun  requestCameraPermission(activity:Activity) {
        ActivityCompat.requestPermissions(
            activity, permissionArray , CAMERA_PERMISSION_CODE)
    }

    /** Check to see if we need to show the rationale for this permission. */
    public fun shouldShowRequestPermissionRationale(activity:Activity): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, CAMERA)
    }

    /** Launch Application Setting to grant permission. */
    public fun   launchPermissionSettings(activity:Activity) {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS;
        intent.data = Uri.fromParts("package", activity.packageName, null);
        activity.startActivity(intent)
    }
}



