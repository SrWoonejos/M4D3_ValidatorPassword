package com.dmiranda.validatorpassword

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.dmiranda.validatorpassword.databinding.FragmentFirstBinding
import com.google.android.material.textfield.TextInputEditText


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var password: TextInputEditText
    private lateinit var button: Button

      override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
          binding = FragmentFirstBinding.inflate(inflater,container,false)
          val view = binding.root

          password = binding.passwordEditText
          button = binding.validateButton
          button.isEnabled = false

          registerListeners()

        return view
    }

    private fun registerListeners() {
        binding.validateButton.setOnClickListener  {
            Navigation.findNavController(registerView()).navigate(R.id.action_firstFragmanet_to_secondFragment)
        }

        
        binding.passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    val passwordText = s.toString()
                if (passwordText.length >= 5 && passwordText != passwordText.toLowerCase()) {
                    binding.validateButton.isEnabled = true
                } else {
                    binding.validateButton.isEnabled = false
                }
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
}
}
