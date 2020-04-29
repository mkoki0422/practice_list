package com.example.practice_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



interface AddAnimalListner{
    fun button_tapped(animal: Animal)
}

class CustomAdapter  (private val animalList: ArrayList<Animal>,private val listner: AddAnimalListner):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val name:TextView
        val age:TextView
        val button:Button

        init {
            name=view.findViewById(R.id.name)
            age=view.findViewById(R.id.age)
            button=view.findViewById(R.id.button)
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  animalList.size
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val animal=animalList[position]

        holder.name.text=animal.name
        holder.age.text=animal.Age.toString()

        holder.button.setOnClickListener {
            listner.button_tapped(animal)
        }

    }

}