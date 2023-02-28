package com.example.application2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.application2.MyAdapter
import com.example.application2.R
import com.example.application2.RetrofitService
import com.example.application2.databinding.FragmentSignalerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SignalerFragment : Fragment() {
    lateinit var binding: FragmentSignalerBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignalerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFormulaires()




    }

    private fun getFormulaires() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.getformulaires()
            withContext(Dispatchers.Main) {
                // binding.progressBar.visibility= View.INVISIBLE
                if (response.isSuccessful) {
                    val formulaires = response.body()
                    binding.arretsList.layoutManager = GridLayoutManager(requireActivity(),resources.getInteger(
                        R.integer.col))
                    binding.arretsList.adapter = MyAdapter(requireActivity(),formulaires!!)

                }
                else {
                    Toast.makeText(requireActivity(),"une erreur", Toast.LENGTH_SHORT).show()}
            }

        }
    }

}