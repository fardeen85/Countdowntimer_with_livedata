package com.example.countdowntimerlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  mUserviewmodel : Viewmodel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mUserviewmodel = ViewModelProvider(this).get(Viewmodel::class.java)




        mUserviewmodel.seconds().observe(this, Observer {

            timetextview.setText(it.toString())
        })

        mUserviewmodel.finish().observe(this, Observer {

            if (it == true){

                Toast.makeText(this,"Timer finished",Toast.LENGTH_SHORT).show()
            }
        })

        btnstart.setOnClickListener {

            var time = txttime.text.toString().toLong()*1000

            mUserviewmodel.timervalue.value = time

            mUserviewmodel.startimer()

        }

        btnpause.setOnClickListener {

            mUserviewmodel.stoptimer()
        }


    }
}
