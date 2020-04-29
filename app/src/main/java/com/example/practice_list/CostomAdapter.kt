package com.example.practice_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView




interface CustomAdapterListner{
    fun clicked(animal: Animal)
}
class CostomAdapter(context: Context,var mAnimalList:List<Animal>,val listner:CustomAdapterListner):ArrayAdapter<Animal>(context,0,mAnimalList){
    private val layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val Animal=mAnimalList[position]//取得

        var view=convertView
        if (convertView ==null){
            view=layoutInflater.inflate(R.layout.item_list,parent,false)//初回表示は何も入ってないからレイアウトしてあげる
        }
        /**
         * ここからが実際のレイアウト
         */
        val name= view?.findViewById<TextView>(R.id.name)
        name?.text=Animal.name


        val age= view?.findViewById<TextView>(R.id.age)
        age?.text="${Animal.age}歳"


        val button=view?.findViewById<Button>(R.id.button)
        button?.setOnClickListener {
            listner.clicked(Animal)//ボタンを押した際、このメソッドが呼ばれるように設定
        }

        return view!!

    }
    fun updateAnimalList(animalList:List<Animal>) {
        mAnimalList=animalList
        notifyDataSetChanged()
    }
}