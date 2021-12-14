package com.vmd.examen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import com.vmd.examen.adapter.TitlesAdapter
import com.vmd.examen.databinding.FragmentMainBinding
import com.vmd.examen.model.LoginResponse
import com.vmd.examen.viewModel.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {

    var binding: FragmentMainBinding? = null
    val viewModel: UserViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val localBinding = binding ?: return
        val adapter = TitlesAdapter()
        localBinding.rvTitles.adapter = adapter
        initUser(viewModel.getUser(), localBinding)

        viewModel.getImages()
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.pageStateFlow.collect {
                it?.let {
                    adapter.submitList(it.response)
                }
            }
        }
    }

    fun initUser(user: LoginResponse?, binding: FragmentMainBinding) {
        user?.let {
            binding.photo.load(it.photo)
            binding.userId.text = it.id.toString()
            binding.title.text = it.userName
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}