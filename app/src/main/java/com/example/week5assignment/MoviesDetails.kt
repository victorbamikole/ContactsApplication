package com.example.week5assignment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import de.hdodenhof.circleimageview.CircleImageView

const val MY_PERMISSIONS_REQUEST_CALL_PHONE = 1

class MoviesDetails : AppCompatActivity() {
        private lateinit var pNumber: TextView
    // TryingToPush
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_details)
        val pImage: CircleImageView? = findViewById(R.id.circleImageView)
        val mAddress: TextView = findViewById(R.id.mail)
        val pName: TextView = findViewById(R.id.playerName)
        val back: ImageView = findViewById(R.id.backButton)
        val pNumber = findViewById<TextView>(R.id.textView2)
        val call: ImageView = findViewById(R.id.imageView)

        val bundle: Bundle? = intent.extras

        val image = bundle!!.getInt("Image")
        val phoneNumber = bundle.getString("PhoneNumber")
        val mail = bundle.getString("Mail")
        val player = bundle.getString("PlayerName")

        pImage?.setImageResource(image)
        pName.text = player
        pNumber.text = phoneNumber
        mAddress.text = mail

        call.setOnClickListener {
            requestPermissionResult()
        }

        back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun hasCalPhonePermission() =
        ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED


    private fun requestPermissionResult() {
        if (!hasCalPhonePermission()) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 0)
        } else {
            callPhone()
        }
    }

    private fun callPhone() {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${pNumber.text}"))
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            callPhone()
        }else{
            Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show()
        }
    }


}
