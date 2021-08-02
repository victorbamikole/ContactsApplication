package com.example.week5assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MoviesDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_details)

        val pImage: CircleImageView? = findViewById(R.id.circleImageView)
        val pNumber: TextView = findViewById(R.id.textView2)
        val mAddress: TextView = findViewById(R.id.mail)
        val pName: TextView = findViewById(R.id.playerName)
        val back: ImageView = findViewById(R.id.backButton)

        val bundle: Bundle? = intent.extras

        val image = bundle!!.getInt("Image")
        val phoneNumber = bundle.getString("PhoneNumber")
        val mail = bundle.getString("Mail")
        val player = bundle.getString("PlayerName")

        pImage?.setImageResource(image)
        pName.text = player
        pNumber.text = phoneNumber
        mAddress.text = mail

        back.setOnClickListener {
            onBackPressed()
        }
    }
}