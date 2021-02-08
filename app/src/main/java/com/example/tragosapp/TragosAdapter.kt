package com.example.tragosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tragosapp.databinding.ItemTragoBinding

class TragosAdapter(//constructor
    //lista de tragos con la que se dibujara la lista
    var tragos: MutableList<Trago>
    ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //Aqui ligamos el xml del item que se mostrara en lista
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_trago, parent, false)
        return TragoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //metodo para ligar cada trago individual con su vista
        when(holder){
            is TragoViewHolder -> {
                val item = tragos[position]
                //aqui se hace eso
                holder.bind(item)
                //Aca se le da accion si se le hace click, no es de awebo
                holder.itemView.setOnClickListener {  }
            }
        }
    }

    override fun getItemCount(): Int {
        //Retorna la cantidad de items
        return tragos.size
    }

    //Clase interna que solo se usara aqui
    class TragoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val binding = ItemTragoBinding.bind(itemView)


        fun bind(trago: Trago){
            //funcion para ligar los elementos visuales con los datos del objeto
            //El text view nombre se liga con el dato nombre del trago y asi
            binding.tvNombre.text = trago.nombre
            binding.tvPrecio.text = trago.precio.toString()
            //Uso de la libreria Glide para poner una imagen con una url
            Glide.with(itemView.context)
                .load(trago.urlImagen)
                .centerCrop()
                .into(binding.ivFoto)
        }

    }

}