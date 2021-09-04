package com.geek.rickandmortyapp.ui.character_list;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geek.rickandmortyapp.base.Recourse;
import com.geek.rickandmortyapp.data.repositories.CharacterRepository;
import com.geek.rickandmortyapp.models.Character;
import com.geek.rickandmortyapp.models.RickAndMortyResponse;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CharacterViewModel extends ViewModel {
    private final CharacterRepository repository;
    @Inject
    public CharacterViewModel(CharacterRepository repository) {
        this.repository = repository;
    }

    MutableLiveData<Recourse<RickAndMortyResponse<Character>>> fetchCharacter(){
        return repository.fetchCharacters();
    }
}
