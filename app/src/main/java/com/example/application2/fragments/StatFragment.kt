package com.example.application2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.application2.R
import com.example.application2.databinding.FragmentStatBinding
import com.example.application2.databinding.FragmentStatnextBinding


class StatFragment : Fragment() {
    lateinit var binding: FragmentStatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.enfant.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_statFragment_to_statistique3Fragment)


        }
        binding.general.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_statFragment_to_statnextFragment)


        }
    }
}