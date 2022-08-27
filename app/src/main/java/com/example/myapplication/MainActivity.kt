package com.example.myapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.myapplication.kotlencode.Person
import com.example.myapplication.kotlencode.Student
import java.time.LocalDate



class MainActivity : AppCompatActivity() {
    var index:Int=0
    lateinit var students: List<Student>
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //git hub done
        val btnext = findViewById<Button>(R.id.btn_next)
        val btnprev = findViewById<Button>(R.id.btn_prev)
        val idview=findViewById<TextView>(R.id.tv_2)
        val bodview=findViewById<TextView>(R.id.tv_3)
        val ageview=findViewById<TextView>(R.id.tv_4)
        val uniview=findViewById<TextView>(R.id.tv_5)
        val majorview=findViewById<TextView>(R.id.tv_6)
        val emailview=findViewById<TextView>(R.id.tv_7)
        val btnaddnew = findViewById<Button>(R.id.btn_addnew)

        val p1 = Student("sara", 9234, LocalDate.of(2020, 3, 11),"209839","QOU","sara5454@gmail.com","CIS")
        val p2 = Student("youmna", 8546, LocalDate.of(2001, 7, 7),"598347","BZU","yumna88@gmail.com","special breeding")
        val p3 = Student("Ali", 2562, LocalDate.of(1999, 12, 18),"726472","AQ","ali99n@gmail.com","lawyer")
        students= listOf(p1, p2, p3)
        var tv1 = findViewById<TextView>(R.id.tv_1)

        btnaddnew.setOnClickListener {
            Log.i("add new","Button Clicked")
            var intent:Intent=Intent(this, Studentform::class.java)
            startActivityForResult(intent, 0)
        }


        btnext.setOnClickListener {
            Log.i("index","$index")
            if (index>students.size-1)
                index=students.size-1
            tv1.text = students[index].name
            idview.text= students[index].ID.toString()
            bodview.text= students[index].bod.toString()
            ageview.text= students[index].getAge().toString()
            uniview.text=students[index].university
            majorview.text= students[index].major
            emailview.text=students[index].email
            index++
        }
        btnprev.setOnClickListener {
            if(index in 0..students.size-1) {
                tv1.text = students[index].name
                idview.text= students[index].ID.toString()
                bodview.text= students[index].bod.toString()
                ageview.text= students[index].getAge().toString()
                uniview.text=students[index].university
                majorview.text= students[index].major
                emailview.text=students[index].email
                index -= 1
            }
            else
            {
                index=students.size-1
                tv1.text = students[index].name
                idview.text= students[index].ID.toString()
                bodview.text= students[index].bod.toString()
                ageview.text= students[index].getAge().toString()
                uniview.text=students[index].university
                majorview.text= students[index].major
                emailview.text=students[index].email


            }
}
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
       var stname= data?.getStringExtra("StudentNmae").toString()
        var stCol= data?.getStringExtra("StCollage").toString()
        var st=     Student(stname, 9234, LocalDate.of(2020, 3, 11),"209839","QOU","sara5454@gmail.com","CIS")
    students+=st
    }
}