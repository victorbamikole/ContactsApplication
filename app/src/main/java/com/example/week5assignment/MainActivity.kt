package com.example.week5assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Array of profile images
        val images = listOf(
            Contacts(R.drawable.ronaldo, "Cristiano Ronaldo"),
            Contacts(R.drawable.bruno, "Bruno Fernandes"),
            Contacts(R.drawable.messi, "Lionel Messi"),
            Contacts(R.drawable.debruyne, "De bruyne Mike"),
            Contacts(R.drawable.dybala, "Paul Dybala"),
            Contacts(R.drawable.kane, "Harry Kane"),
            Contacts(R.drawable.mbappe, "Paul Mbappe"),
            Contacts(R.drawable.rashford, "Marcos Rashford"),
            Contacts(R.drawable.robert2, "Robert Lewandoski"),
            Contacts(R.drawable.sancho, "Jadon Sancho"),
            Contacts(R.drawable.ole, "Ole Solksjar"),
            Contacts(R.drawable.bissaka, "Aron Wan Bissaka"),
            Contacts(R.drawable.pogba, "Paul Pogba"),
            Contacts(R.drawable.sala, "Mohamed Salah"),
            Contacts(R.drawable.debruyne, "De bruyne Mike")
        )
        val phoneNumber: Array<DetailsActivity> = arrayOf(
            DetailsActivity("(650) 555-137"),
            DetailsActivity("(650) 653-879"),
            DetailsActivity("(787) 234-309"),
            DetailsActivity("(657) 553-434"),
            DetailsActivity("(545) 678-542"),
            DetailsActivity("(999) 432-428"),
            DetailsActivity("(445) 664-864"),
            DetailsActivity("(436) 787-356"),
            DetailsActivity("(087) 456-773"),
            DetailsActivity("(543) 634-556"),
            DetailsActivity("(875) 478-245"),
            DetailsActivity("(435) 098-764"),
            DetailsActivity("(095) 234-356"),
            DetailsActivity("(432) 533-467"),
            DetailsActivity("(456) 561-764")
        )

        val mailAddress: Array<MailAddress> = arrayOf(
            MailAddress("ronaldo@gmail.com"),
            MailAddress("Bruno@gmail.com"),
            MailAddress("Lionel@gmail.com"),
            MailAddress("bruyne@gmail.com"),
            MailAddress("Paul@gmail.com"),
            MailAddress("Harry@gmail.com"),
            MailAddress("Mbappe@gmail.com"),
            MailAddress("Marcos@gmail.com"),
            MailAddress("Jadon@gmail.com"),
            MailAddress("Solksjar@gmail.com"),
            MailAddress("Bissaka@gmail.com"),
            MailAddress("Pogba@gmail.com"),
            MailAddress("Mohamed@gmail.com"),
            MailAddress("Salah@gmail.com"),
            MailAddress("Mike@gmail.com")
        )
        val adapter2 = ContactsAdapter(images)
        recyclerView.adapter = adapter2
        adapter2.setOnItemClickListener(object : ContactsAdapter.onItemClickListener {
            override fun onContactItem(position: Int) {
                val intent = Intent(this@MainActivity, MoviesDetails::class.java)
                intent.putExtra("Image", images[position].profileImage)
                intent.putExtra("PhoneNumber", phoneNumber[position].number)
                intent.putExtra("Mail", mailAddress[position].mail)
                intent.putExtra("PlayerName", images[position].name)
                startActivity(intent)
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}