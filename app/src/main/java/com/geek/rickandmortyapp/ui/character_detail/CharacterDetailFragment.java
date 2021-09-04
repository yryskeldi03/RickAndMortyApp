package com.geek.rickandmortyapp.ui.character_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.geek.rickandmortyapp.R;
import com.geek.rickandmortyapp.base.BaseFragment;
import com.geek.rickandmortyapp.databinding.FragmentCharacterDetailBinding;

public class CharacterDetailFragment extends BaseFragment<FragmentCharacterDetailBinding> {

    public CharacterDetailFragment() {}


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void observers() {

    }

    @Override
    protected FragmentCharacterDetailBinding bind() {
        return FragmentCharacterDetailBinding.inflate(getLayoutInflater());
    }
}