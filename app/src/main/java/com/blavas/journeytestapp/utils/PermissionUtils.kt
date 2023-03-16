package com.trendnxt.utils

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.blavas.journeytestapp.R

object PermissionUtils {
    /**
     * Function to request permission from the user
     */
    fun requestAccessFineLocationPermission(activity: AppCompatActivity, requestId: Int) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            requestId
        )
    }
    fun requestAccessForBackgroundPermission(activity: AppCompatActivity, requestId: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                requestId
            )
        }
    }

    /**
     * Function to check if the location permissions are granted or not
     */
    fun isAccessFineLocationGranted(context: Context): Boolean {
        return ContextCompat
            .checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
    }

    fun isBackgroundLocationGranted(context: Context): Boolean {
        return ContextCompat
            .checkSelfPermission(
                context,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Function to check if location of the device is enabled or not
     */
    fun isLocationEnabled(context: Context): Boolean {
        val locationManager: LocationManager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    /**
     * Function to show the "enable GPS" Dialog box
     */

}