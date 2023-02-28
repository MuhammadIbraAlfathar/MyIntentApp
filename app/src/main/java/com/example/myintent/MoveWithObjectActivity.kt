package com.example.myintent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject : TextView = findViewById(R.id.tv_object_reveived)

        val person = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        if (person != null){
            val text = "Name : ${person.name}, \n Email : ${person.email}, " +
                    "\n Age : ${person.age}, \n Location : ${person.city}"
            tvObject.text = text
        }

    }
}