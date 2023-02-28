package com.example.application2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.navigation.findNavController
import com.example.application2.R

import com.example.application2.databinding.FragmentLoginBinding
import com.example.application2.MainActivity
import com.example.application2.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = requireActivity().getSharedPreferences("user_db", Context.MODE_PRIVATE)
        var  con = pref.getBoolean("connected", false)


        if (con) {

            val intent = Intent(requireActivity(), MainActivity::class.java)
            this.startActivity(intent)
            requireActivity().finish()
        }



        binding.button4.setOnClickListener {
            //binding.progressBar.visibility= View.VISIBLE
            var role_name: String = binding.role.text.toString()
            var password: String = binding.password.text.toString()
            login_methode(role_name, password)
        }




    }



    private  fun login_methode(role_name: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitService.endpoint.getrole(role_name,password)
            val pref = requireActivity().getSharedPreferences("user_db", Context.MODE_PRIVATE)
            //  var con = pref.getBoolean("connected", false)
            //quand il termine il retourne au thread main
            withContext(Dispatchers.Main) {
                //       binding.progressBar.visibility= View.INVISIBLE

                if (response.isSuccessful) {
                    val user = response.body()
                    if (user != null) {
                        pref.edit {
                            putInt("idUser", user.id!!)
                            putBoolean("connected", true)

                        }

                        val intent = Intent(requireActivity(), MainActivity::class.java)

                        requireActivity().startActivity(intent)
                        requireActivity().finish()
                    } else {
                        Toast.makeText(
                            requireActivity(),
                            "role_name ou mot de passe errone",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                else { Toast.makeText(requireActivity(),"une erreur 200",Toast.LENGTH_SHORT).show()}
            }

        }
    }




}