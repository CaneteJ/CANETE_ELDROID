package com.canete.activity3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call.Details
import android.widget.TextView

class Activity3 : AppCompatActivity() {

    lateinit var emailDetailsTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        emailDetailsTextView = findViewById<TextView>(R.id.emailDetailTextView)

        val emailDetails = intent.getStringExtra("emailDetails")

        if (emailDetails != null) {
            val parts = emailDetails.split(",").map { it.trim() }
            val sender = parts[0]
            val subject = parts[1]
            val content = parts[2]

            val fullContent = "Sender: $sender\nSubject: $subject\nContent: $content"

            emailDetailsTextView.text = fullContent
        }
    }
}