package com.vmd.examen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.vmd.examen.databinding.FragmentLoginBinding
import com.vmd.examen.viewModel.UserViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LoginFragment : Fragment() {
    var binding: FragmentLoginBinding? = null
    val viewModel: UserViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLoginBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val localBinding = binding ?: return
        localBinding.apply {
            btnLogin.setOnClickListener {
                viewModel.login(username.text.toString(), password.text.toString())
            }
        }

        lifecycleScope.launch {
            viewModel.loginStateFlow.collect {
                it?.let {
                    when (it.status) {
                        "success" -> parentFragmentManager.beginTransaction()
                            .replace(R.id.container, MainFragment()).commit()
                        else -> Toast.makeText(context, "Error occurred!", Toast.LENGTH_SHORT)
                            .show()
                    }

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}