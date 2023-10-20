package com.canete.activity3

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class act3 : AppCompatActivity() {
    private lateinit var emailList: ListView
    private val emailData = arrayOf(
        "Satoro Gojo, Email, We asked a random sample of people what they thought. Water samples taken from streams were analyzed for contamination by chemicals. They looked at the blood samples under the microscope.",
        "Monkey D. Luffy",
        "Satoro Gojo",
        "Monkey D. Luffy",
        "Monkey D. Luffy",
        "Monkey D. Luffy",
        "Monkey D. Luffy",
        "Monkey D. Luffy",
        "Ciedner Mabale",
        "James The Great",
        "Junas Wakolokoy",
        "Paksiw",
        "Son Guko",
        "Naruto Amaw",
        "Sasuke Uchiha",
        "Richard Ricardo",
        "Satoro Gojo",
        "Satoro Gojo",
        "Zoro Junie Boy",
        "Satoro Gojo"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act3)

        emailList = findViewById(R.id.emailDetailTextView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, emailData)
        emailList.adapter = adapter

        emailList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val emailDetails = emailData[position]
            openEmailDetailActivity(emailDetails)
        }
    }

    private fun openEmailDetailActivity(emailDetails: String) {
        val intent = Intent(this, act3::class.java)
        intent.putExtra("emailDetails", emailDetails)
        startActivity(intent)
    }
}