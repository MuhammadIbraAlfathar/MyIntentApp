package com.example.myintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//excplicit intent
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

//Move dgn data
        val btnMoveActivityData : Button = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityData.setOnClickListener(this)

//Move data dgn parcelable
        val btnMoveWithObject : Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

//Implicit Intent
        val btnDialPhone : Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult : Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

    }

    override fun onClick(v: View?) {

        when (v?.id){
            //        Latihan explicit intent
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            //        ----------------------

//          Move dengan data
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithData::class.java)
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME, "Nico Syahputra")
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE, 19)
                startActivity(moveWithDataIntent)
            }
//            ------------------

//            Move data dengan parcelable
            R.id.btn_move_activity_object -> {
                val person = Person (
                    "Dicoding Academy",
                    5,
                    "academy@dicoding.com",
                    "Bandung"
                        )
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

//            Implicit Intent

            R.id.btn_dial_number -> {
                val phoneNumber = "08941347129"
                val dialPhoneIntent = Intent(/* action = */ Intent.ACTION_DIAL, /* uri = */ Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

//            Nilai Balik dari Intent

//            R.id.btn_move_for_result -> {
//                val resultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
//                startActivity(resultIntent)
//            }

        }

    }
}