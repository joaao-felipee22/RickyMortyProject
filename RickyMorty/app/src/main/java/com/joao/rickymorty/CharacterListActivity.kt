package com.joao.rickymorty

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.joao.rickymorty.databinding.ActivityCharacterListBinding
import com.joao.rickymorty.features.characters.list.presentation.CharactersAdapter
import com.joao.rickymorty.features.characters.list.presentation.viewmodel.CharacterListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterListActivity : AppCompatActivity() {

    private val adapter = CharactersAdapter()
    private lateinit var binding : ActivityCharacterListBinding
    private val viewModel : CharacterListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCharacterListBinding.inflate(layoutInflater)

        binding.recyclerHome.adapter = adapter
        binding.recyclerHome.layoutManager = GridLayoutManager(this, 2)

        viewModel.getAllCharacters()

        lifecycleScope.launch {
            viewModel.listFlowResult.collect{
                adapter.submitList(it?.results)
            }
        }
    }
}