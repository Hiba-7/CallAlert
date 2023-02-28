package com.example.application2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.example.application2.databinding.FragmentBlankBinding
import com.example.application2.databinding.FragmentSignal2Binding


class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formulaire = arguments?.getSerializable("data") as Formulaire
        if (formulaire != null) {
            binding.textView12.text = "Numéro de série : " + formulaire.id.toString()
            binding.name1.text = "Nom : " + formulaire.nomsignaleur
            binding.prenom.text = "Prenom : " + formulaire.prenomsignaleur
            binding.adresse1.text = "Adresse : " + formulaire.adrsignaleur
            binding.Numero.text = "Numéro de telephone : " + formulaire.telsignaleur
            binding.titrea.text = "La personne qui signale : " + formulaire.signaleur
            binding.titrec.text = "La personne legal est : " + formulaire.prsnphysique
            binding.titreb.text = "La personne physique est : " + formulaire.sexeprsnphysique
            binding.titred.text = "La personne morale est : " + formulaire.prsnmorale
            binding.name2.text = "Nom : " + formulaire.nomenfant
            binding.prenom1.text = "Prenom : " + formulaire.prenomenfant
            binding.adresse2.text = "Adresse : " + formulaire.adrenfant

        }

        binding.next.setOnClickListener { view: View ->
            val data = bundleOf("data" to formulaire)
            view.findNavController().navigate(R.id.action_blankFragment3_to_signal2Fragment,data)

        }
    }

    }


