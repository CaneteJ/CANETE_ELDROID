package com.canete.activity4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Activity4 : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var checkBox: CheckBox
    private lateinit var EmailEditText: EditText
    private lateinit var nicknameEditText: EditText
    private lateinit var saveButton: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        radioGroup = findViewById(R.id.radioGroup)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        checkBox = findViewById(R.id.checkBox)
        saveButton = findViewById(R.id.saveButton)
        nicknameEditText = findViewById(R.id.nicknameEditText)
        EmailEditText = findViewById(R.id.EmailEditText)
        loadFormState()

        saveButton.setOnClickListener {
            saveFormState()
        }
    }

    private fun loadFormState() {
        val themeOption = sharedPreferences.getInt("themeOption", -1)
        if (themeOption != -1) {
            radioGroup.check(themeOption)
        }

        checkBox.isChecked = sharedPreferences.getBoolean("pushNotification", false)

        val savedEmail = sharedPreferences.getString("email", "")
        EmailEditText.setText(savedEmail)

        val savedNickname = sharedPreferences.getString("nickname", "")
        nicknameEditText.setText(savedNickname)
    }

    private fun saveFormState() {
        val editor = sharedPreferences.edit()
        val selectedRadioId = radioGroup.checkedRadioButtonId
        editor.putInt("themeOption", selectedRadioId)

        editor.putBoolean("pushNotification", checkBox.isChecked)

        editor.putString("email", EmailEditText.text.toString())
        editor.putString("nickname", nicknameEditText.text.toString())

        editor.apply()
        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show()
    }
}