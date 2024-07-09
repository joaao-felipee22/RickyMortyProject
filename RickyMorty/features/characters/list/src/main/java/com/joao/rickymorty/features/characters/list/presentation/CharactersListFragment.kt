package com.joao.rickymorty.features.characters.list.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.transition.Visibility
import com.joao.rickymorty.features.characters.list.R
import com.joao.rickymorty.features.characters.list.databinding.FragmentCharactersBinding
import com.joao.rickymorty.features.characters.list.domain.models.Result
import com.joao.rickymorty.features.characters.list.presentation.models.UiState
import com.joao.rickymorty.features.characters.list.presentation.viewmodel.CharacterListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersListFragment : Fragment(R.layout.fragment_characters) {

    private val adapter = CharactersAdapter()
    private lateinit var binding : FragmentCharactersBinding
    private val viewModel : CharacterListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharactersBinding.bind(view)
        setupViews()
        viewModel.getAllCharacters()
    }

    private fun setupViews(){
        binding.recyclerHome.adapter = adapter
        binding.recyclerHome.layoutManager = GridLayoutManager(context, 2)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collect{
                    renderState(it)
                }
            }
        }
    }

    private fun renderState(uiState: UiState){
        when (uiState) {
            UiState.Loading -> showLoading()
            UiState.Error -> showError()
            UiState.Empty -> showEmpty()
            is UiState.Success -> showSuccess(uiState.results)
        }
    }

    private fun showSuccess(results: List<Result>) {
        adapter.submitList(results)
        binding.progressBar.visibility = View.GONE
        binding.txtMessage.visibility = View.GONE
        binding.recyclerHome.visibility = View.VISIBLE
    }

    private fun showEmpty() {
        binding.txtMessage.visibility = View.VISIBLE
        binding.txtMessage.text = getString(R.string.lista_vazia)
        binding.recyclerHome.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }

    private fun showError() {
        binding.txtMessage.visibility = View.VISIBLE
        binding.txtMessage.text = getString(R.string.error_list)
        binding.recyclerHome.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.txtMessage.visibility = View.GONE
        binding.recyclerHome.visibility = View.GONE
    }
}
