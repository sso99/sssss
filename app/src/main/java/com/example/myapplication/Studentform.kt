package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Studentform : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentform)
        findViewById<Button>(R.id.btn_ok).setOnClickListener {
          var stname=  findViewById<EditText>(R.id.edt_stname).text.toString()
            intent.putExtra("StudentNmae",stname)
            var stCollage=  findViewById<EditText>(R.id.edt_stname).text.toString()
            intent.putExtra("StCollage",stname)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}