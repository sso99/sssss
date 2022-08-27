package com.example.myapplication.kotlencode

import android.os.Build
import java.time.LocalDate
import java.time.Period

open class Person(val name:String, val ID:Int, val bod: LocalDate) {


    open fun getAge():Pair<Int,Int>{
        if(bod !=null){
            var age:Period= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Period.between(bod,LocalDate.now())
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            return Pair(age.getYears(),age.getMonths())
        }else{
            return Pair(0,0)
        }
        
    }

    
    
    
}