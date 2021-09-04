package com.geek.rickandmortyapp.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.geek.rickandmortyapp.App;
import com.geek.rickandmortyapp.base.Recourse;
import com.geek.rickandmortyapp.data.local.CharacterDao;
import com.geek.rickandmortyapp.data.remote.RickyAndMortyApi;
import com.geek.rickandmortyapp.models.Character;
import com.geek.rickandmortyapp.models.RickAndMortyResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepository {
    private final RickyAndMortyApi api;
    private final CharacterDao characterDao;

    @Inject
    public CharacterRepository(RickyAndMortyApi api, CharacterDao characterDao) {
        this.api = api;
        this.characterDao = characterDao;
    }

    public MutableLiveData<Recourse<RickAndMortyResponse<Character>>> fetchCharacters() {
        MutableLiveData<Recourse<RickAndMortyResponse<Character>>> data = new MutableLiveData<>();
        data.setValue(new Recourse<>(Recourse.Status.LOADING, null, null));
        api.fetchCharacters().enqueue(new Callback<RickAndMortyResponse<Character>>() {
            @Override
            public void onResponse(Call<RickAndMortyResponse<Character>> call, Response<RickAndMortyResponse<Character>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    data.setValue(new Recourse<>(Recourse.Status.SUCCESS, response.body(), null));
                    characterDao.insetAll(response.body().getResult());
                } else data.setValue(new Recourse<>(Recourse.Status.ERROR, null, "Data null"));
            }

            @Override
            public void onFailure(Call<RickAndMortyResponse<Character>> call, Throwable t) {
                data.setValue(new Recourse<>(Recourse.Status.ERROR, null, t.getLocalizedMessage()));
            }
        });
        return data;
    }
}
