package com.geek.rickandmortyapp.ui.character_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geek.rickandmortyapp.App;
import com.geek.rickandmortyapp.R;
import com.geek.rickandmortyapp.base.BaseFragment;
import com.geek.rickandmortyapp.data.local.CharacterDao;
import com.geek.rickandmortyapp.data.repositories.CharacterRepository;
import com.geek.rickandmortyapp.databinding.FragmentCharacterListBinding;
import com.geek.rickandmortyapp.models.Character;
import com.geek.rickandmortyapp.models.RickAndMortyResponse;
import com.geek.rickandmortyapp.ui.character_list.adapter.CharacterListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CharacterListFragment extends BaseFragment<FragmentCharacterListBinding> {
    private CharacterListAdapter adapter;
    private CharacterViewModel viewModel;
    @Inject
    CharacterRepository characterRepository;

    @Inject
    CharacterDao characterDao;

    public CharacterListFragment() {
    }


    @Override
    protected FragmentCharacterListBinding bind() {
        return FragmentCharacterListBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initRecycler();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void initialize() {
        viewModel = new ViewModelProvider(requireActivity()).get(CharacterViewModel.class);
    }

    @Override
    protected void observers() {
        List<Character> list = characterDao.getAllCharacters();
       // adapter.setCharacters(list);
        viewModel.fetchCharacter().observe(getViewLifecycleOwner(), response -> {
            switch (response.status) {
                case SUCCESS:
                    binding.progressBar.setVisibility(View.GONE);
                    binding.rvCharacters.setVisibility(View.VISIBLE);
                    adapter.setCharacters(response.data.getResult());
                    break;
                case ERROR:
                    binding.progressBar.setVisibility(View.GONE);
                    Toast.makeText(requireContext(), response.message, Toast.LENGTH_LONG).show();
                    break;
                case LOADING:
                    binding.progressBar.setVisibility(View.VISIBLE);
                    binding.rvCharacters.setVisibility(View.GONE);
                    break;
            }
        });
    }

    private void initRecycler() {
        adapter = new CharacterListAdapter();
        binding.rvCharacters.setAdapter(adapter);
    }
}