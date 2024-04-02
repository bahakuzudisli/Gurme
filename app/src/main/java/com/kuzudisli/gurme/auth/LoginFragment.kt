package com.kuzudisli.gurme.auth

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.kuzudisli.gurme.R
import com.kuzudisli.gurme.databinding.FragmentLoginBinding
import com.kuzudisli.gurme.utils.NavigationUtils

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPassword: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        email = binding.loginEmailEditText
        password = binding.loginPasswordEditText
        loginButton = binding.loginButton
        forgotPassword = binding.forgotPassword

        forgotPassword.setOnClickListener {
            NavigationUtils.navigateToFragment(this, R.id.action_loginFragment_to_signUpFragment)
        }

        val passwordEditText = binding.loginPassword.editText
        passwordEditText?.let { password ->
            binding.loginPassword.setStartIconOnClickListener {
                val currentTransformationMethod = password.transformationMethod
                password.transformationMethod =
                    if (currentTransformationMethod == PasswordTransformationMethod.getInstance()) {
                        binding.loginPassword.setStartIconDrawable(R.drawable.ic_pswhide)
                        HideReturnsTransformationMethod.getInstance()
                    } else {
                        binding.loginPassword.setStartIconDrawable(R.drawable.ic_pswsee)
                        PasswordTransformationMethod.getInstance()
                    }
                password.setSelection(password.text?.length ?: 0)
            }
        }
    }

}