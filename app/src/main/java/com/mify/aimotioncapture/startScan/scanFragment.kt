package com.mify.aimotioncapture.startScan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.mify.aimotioncapture.R
import com.mify.aimotioncapture.cameraFeature.CamActivity


class scanFragment: Fragment() {
    private val permLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ){ isGranted:Boolean ->
            if( isGranted){
                StartScan()
            }
        else{
            //ДЗ: скрыть СтартСкан и показать сообщение
        }
     }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.scan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val start_button = view.findViewById<Button>(R.id.ScanStartbutton)
        start_button.setOnClickListener {
            val permission = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            when(permission) {
                PackageManager.PERMISSION_GRANTED -> {
                    StartScan()
                }
                else -> {
                    permLauncher.launch(Manifest.permission.CAMERA)
                }
            }
        }
    }
    private fun StartScan() {
        val intention = Intent(requireContext(), CamActivity::class.java)
        startActivity(intention)
    }
}