package com.dmiranda.validatorpassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.dmiranda.validatorpassword.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerListener()
    }


    private fun registerListener() {
        binding.passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                charSequence?.let {
                    if (it.length >= 5) {
                        binding.buttonShowButton.isEnabled = true
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.buttonShowButton.setOnClickListener { showMessage() }

    }

    private fun showMessage() {
        TODO("Not yet implemented")
        binding.hiddenText.visibility = View.VISIBLE
    }
}
