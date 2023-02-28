package com.example.application2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.application2.databinding.ActivityMainBinding
import com.example.application2.databinding.ListItemBinding


class MyAdapter(val context: Context, var data:List<Formulaire>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            number.text = "Signalement : " + data[position].id.toString()
            source.text =
                "Nom utilisateur : " + data[position].nomsignaleur + data[position].prenomsignaleur
            etat.text = "Signalement : " + data[position].etat

        }

        holder.itemView.setOnClickListener { view: View ->
            val data = bundleOf("data" to data[position])
            view.findNavController().navigate(R.id.action_signalerFragment_to_blankFragment3,data)
        }
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var number : TextView = view.findViewById(R.id.titleArretNumber)
        var source: TextView = view.findViewById(R.id.titleArretSource)
        var etat : TextView = view.findViewById(R.id.etat)

    }

}