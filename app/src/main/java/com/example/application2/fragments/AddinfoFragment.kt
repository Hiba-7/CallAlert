package com.example.application2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.application2.MyAdapter
import com.example.application2.R
import com.example.application2.databinding.FragmentAddinfoBinding


class AddinfoFragment : Fragment() {
    lateinit var binding: FragmentAddinfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddinfoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appel.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_addinfoFragment_to_appelFragment)
        }
    }

}