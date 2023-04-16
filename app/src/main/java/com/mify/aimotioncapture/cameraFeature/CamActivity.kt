package com.mify.aimotioncapture.cameraFeature

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import com.mify.aimotioncapture.R

class CamActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_camera)
    }
}