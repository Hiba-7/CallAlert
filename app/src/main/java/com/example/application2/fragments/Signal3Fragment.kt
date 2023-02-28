package com.example.application2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.application2.Formulaire
import com.example.application2.R
import com.example.application2.databinding.FragmentSignal3Binding


class Signal3Fragment : Fragment() {

    lateinit var binding: FragmentSignal3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignal3Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaire = arguments?.getSerializable("data") as Formulaire
        if (formulaire != null) {

            binding.adresse2.text="Nom : " + formulaire.nomereplegal
            binding.prenomm.text="Prenom : " + formulaire.prenomreplegal
            binding.agee.text="Age : " + formulaire.agereplegal.toString()
            binding.emplacement.text="Adresse : " + formulaire.adrreplegal
            binding.titreb.text=formulaire.situationfam
            binding.nom8.text="Nom : " + formulaire.nomerecevant
            binding.prenomm8.text="Prenom : " + formulaire.prenomrecevant
        }
        binding.addinfo.setOnClickListener { view: View ->
            val data = bundleOf("data" to formulaire)
            view.findNavController().navigate(R.id.action_signal3Fragment_to_addinfoFragment,data)
        }
    }
}