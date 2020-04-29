package com.example.practice_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,AddAnimalListner{


    lateinit var mAnimalList:ArrayList<Animal>
    lateinit var mAdapter:CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dog=Animal("犬",4)
        val cat=Animal("猫",4)
        val pig=Animal("ぶた",4)
        val dog0=Animal("太郎",4)
        val dog1=Animal("山田",4)
        val dog2=Animal("石口",4)
        val dog3=Animal("加藤",4)
        mAnimalList= arrayListOf(dog,cat,pig,dog0,dog1,dog2,dog3)

        recycler_view.layoutManager=LinearLayoutManager(this)//一列で並べるため
        mAdapter=CustomAdapter(mAnimalList,this)
        recycler_view.adapter=mAdapter
    }

    override fun button_tapped(animal: Animal) {
        mAnimalList.add(animal)
        mAdapter.notifyDataSetChanged()
    }
}
