package com.example.practice_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val array= arrayOf("a1","a2","a3","a4")
        val Listview= findViewById<ListView>(R.id.list_view)

        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,array)

        Listview.adapter=adapter

        Listview.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,array[position],Toast.LENGTH_LONG).show()
        }
    }
}
