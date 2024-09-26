package com.plcoding.weatherapp.data.Location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.plcoding.weatherapp.domain.Location.LocationTracker
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class DefaultLocationTracker(
    private val locationClient : FusedLocationProviderClient,
    private val application: Application
): LocationTracker {


    override suspend fun getLocation(): Location? {

        val hasAccessFindLocation = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val hasAccessCoarseLocation = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if (!hasAccessCoarseLocation || !hasAccessFindLocation || !isGpsEnable){
            return null
        }

        return suspendCancellableCoroutine { cor ->
            locationClient.lastLocation.apply {
                if (isComplete){
                    if (isSuccessful){
                        cor.resume(result)
                    }else{
                        cor.resume(null)
                    }
                    return@suspendCancellableCoroutine
                }

                addOnSuccessListener {
                    cor.resume(it)
                }
                addOnFailureListener {
                    cor.resume(null)
                }
                addOnCanceledListener {
                    cor.cancel()
                }

            }
        }
    }
}