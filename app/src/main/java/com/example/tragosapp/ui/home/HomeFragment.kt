package com.example.tragosapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tragosapp.R
import com.example.tragosapp.Trago
import com.example.tragosapp.TragosAdapter
import com.example.tragosapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })

        val binding = FragmentHomeBinding.bind(root)
        binding.rvTragos.layoutManager = LinearLayoutManager(context)
        binding.rvTragos.adapter = TragosAdapter(crearDatos())

        return root
    }

    fun crearDatos(): MutableList<Trago>{
        var trago = Trago("Cuba", 60f, "https://cdn.recetacubana.com/wp-content/uploads/2017/12/Cuba-Libre.jpg")

        var tragos = mutableListOf<Trago>()
        tragos.add(trago)

        trago = Trago("Paloma",50f, "https://www.cantinerokentubano.com/wp-content/uploads/2018/08/paloma.jpg")
        tragos.add(trago)
        return tragos
    }
}