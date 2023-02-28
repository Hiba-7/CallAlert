package com.example.application2.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.application2.databinding.FragmentAppelBinding


class AppelFragment : Fragment() {
    lateinit var binding: FragmentAppelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppelBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val justice = "1078"
        binding.justice.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$justice")
            startActivity(intent)
        }
        val police = "17"
        binding.police.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$police")
            startActivity(intent)
        }
        val pompier = "14"
        binding.pompier.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$pompier")
            startActivity(intent)
        }
        val societe = "0561 68 49 99"
        binding.societe.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$societe")
            startActivity(intent)
        }
        val centre = "0531 48 46 79"
        binding.centre.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$centre")
            startActivity(intent)
        }
        val personne = "0531 48 46 79"
        binding.personne.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$personne")
            startActivity(intent)
        }
        val url = "https://www.mjustice.dz/"
        binding.justicesite.setOnClickListener{
            val i= Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        val url2 = "https://www.dgsn.dz/"
        binding.sitepolice.setOnClickListener{
            val i= Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url2)
            startActivity(i)
        }

        val url3 = " https://www.protectioncivile.dz/"
        binding.sitepompier.setOnClickListener{
            val i= Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url3)
            startActivity(i)
        }
        val url4 = "http://www.google.fr"
        binding.centresite.setOnClickListener{
            val i= Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url4)
            startActivity(i)
        }
        binding.socitesite.setOnClickListener{
            val i= Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url4)
            startActivity(i)
        }
    }

}