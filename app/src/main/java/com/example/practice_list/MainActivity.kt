package com.example.practice_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity(),CustomAdapterListner {



    lateinit var mAnimalList:ArrayList<Animal>
    lateinit var mCustomAdapter:CostomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val dog=Animal("犬","4")
        val cat=Animal("犬","4")
        val pig=Animal("犬","4")
        val dog0=Animal("犬","4")
        val dog1=Animal("犬","4")
        val dog2=Animal("犬","4")
        val dog3=Animal("犬","4")
        mAnimalList= arrayListOf(dog,cat,pig,dog0,dog1,dog2,dog3)


        val Listview= findViewById<ListView>(R.id.list_view)


        /*これはもともとあったアダプターを利用
         val array= arrayOf("a1","a2","a3","a4")
        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,array)
        Listview.adapter=adapter

         */


        mCustomAdapter=CostomAdapter(this,mAnimalList,this)
        Listview.adapter=mCustomAdapter
    }
    override fun clicked(animal: Animal) {
        mAnimalList.add(animal)

        // CustomAdapterに実装したリスト更新用の関数を呼ぶ
        mCustomAdapter.updateAnimalList(mAnimalList)
    }
}
