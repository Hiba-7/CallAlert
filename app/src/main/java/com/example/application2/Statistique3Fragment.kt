package com.example.application2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.application2.MyAdapter
import com.example.application2.R
import com.example.application2.RetrofitService
import com.example.application2.databinding.FragmentStatistique3Binding


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Statistique3Fragment : Fragment() {
    lateinit var binding: FragmentStatistique3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatistique3Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*  binding.textView6.setOnClickListener {
              view.findNavController().navigate(R.id.action_loginFragment_to_blankFragment)
          } */

        Getfemmespetit()
        Gethommespetit()
        Getfemmesmoyen()
        Gethommesmoyen()
        Getfemmesgrand()
        Gethommesgrand()
    }
    private fun Getfemmespetit() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.getfemmespetit()
            withContext(Dispatchers.Main) {
                // binding.progressBar.visibility= View.INVISIBLE
                if (response.isSuccessful) {
                    val nombre1 = response.body()
                    binding.femmepetit.text=nombre1.toString()
                }
                else {
                    Toast.makeText(requireActivity(),"une erreur", Toast.LENGTH_SHORT).show()}
            }

        }
    }

    private fun Gethommespetit() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.gethommespetit()
            withContext(Dispatchers.Main) {
                // binding.progressBar.visibility= View.INVISIBLE
                if (response.isSuccessful) {
                    val nombre2 = response.body()
                    binding.hommepetit.text=nombre2.toString()
                }
                else {
                    Toast.makeText(requireActivity(),"une erreur", Toast.LENGTH_SHORT).show()}
            }

        }
    }


    private fun Getfemmesmoyen() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.getfemmesmoyen()
            withContext(Dispatchers.Main) {
                // binding.progressBar.visibility= View.INVISIBLE
                if (response.isSuccessful) {
                    val nombre3 = response.body()
                    binding.femmemoyen.text=nombre3.toString()
                }
                else {
                    Toast.makeText(requireActivity(),"une erreur", Toast.LENGTH_SHORT).show()}
            }

        }
    }
    private fun  Gethommesmoyen() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.gethommesmoyen()
            withContext(Dispatchers.Main) {
                // binding.progressBar.visibility= View.INVISIBLE
                if (response.isSuccessful) {
                    val nombre4 = response.body()
                    binding.hommemoyen.text=nombre4.toString()
                }
                else {
                    Toast.makeText(requireActivity(),"une erreur", Toast.LENGTH_SHORT).show()}
            }

        }
    }


    private fun  Getfemmesgrand() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.getfemmesgrand()
            withContext(Dispatchers.Main) {
                // binding.progressBar.visibility= View.INVISIBLE
                if (response.isSuccessful) {
                    val nombre5 = response.body()
                    binding.femmegrand.text=nombre5.toString()
                }
                else {
                    Toast.makeText(requireActivity(),"une erreur", Toast.LENGTH_SHORT).show()}
            }

        }
    }
    private fun  Gethommesgrand() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.gethommesgrand()
            withContext(Dispatchers.Main) {
                // binding.progressBar.visibility= View.INVISIBLE
                if (response.isSuccessful) {
                    val nombre6 = response.body()
                    binding.hommegrand.text=nombre6.toString()
                }
                else {
                    Toast.makeText(requireActivity(),"une erreur", Toast.LENGTH_SHORT).show()}
            }

        }
    }
}