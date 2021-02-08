package com.example.tragosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tragosapp.databinding.ItemTragoBinding

class TragosAdapter(
    var tragos: MutableList<Trago>
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_trago, parent, false)
        return TragoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is TragoViewHolder -> {
                val item = tragos[position]
                holder.bind(item)
                holder.itemView.setOnClickListener {  }
            }
        }
    }

    override fun getItemCount(): Int {
        return tragos.size
    }

    class TragoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val binding = ItemTragoBinding.bind(itemView)


        fun bind(trago: Trago){
            binding.tvNombre.text = trago.nombre
            binding.tvPrecio.text = trago.precio.toString()
            Glide.with(itemView.context)
                .load(trago.urlImagen)
                .centerCrop()
                .into(binding.ivFoto)

        }

    }

}