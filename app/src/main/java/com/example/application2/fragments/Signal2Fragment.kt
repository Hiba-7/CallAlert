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
import com.example.application2.databinding.FragmentSignal2Binding


class Signal2Fragment : Fragment() {

    lateinit var binding: FragmentSignal2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignal2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val formulaire = arguments?.getSerializable("data") as Formulaire
            if (formulaire != null) {
                binding.adresse2.text= "Sexe : " + formulaire.sexeenfant
                binding.age.text="Age : " + formulaire.ageenfant.toString()
                binding.emplacement.text="L'emplacement de l'enfant : " + formulaire.adrenfant
                binding.titrea.text= formulaire.cause
                binding.dscr.text=formulaire.description
                binding.dangr.text="Le signaleur prefere garder son identite confidentielle: " + formulaire.affichidentity
                binding.dscr1.text=formulaire.dejasignaler
                binding.titre6.text="Le represantant legal est : " + formulaire.replegal
            }

        binding.next.setOnClickListener { view: View ->
            val data = bundleOf("data" to formulaire)
            view.findNavController().navigate(R.id.action_signal2Fragment_to_signal3Fragment,data)
        }
    }
}