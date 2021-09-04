package com.geek.rickandmortyapp.data.remote;

import com.geek.rickandmortyapp.models.Character;
import com.geek.rickandmortyapp.models.RickAndMortyResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RickyAndMortyApi {
    @GET("api/character")
    Call<RickAndMortyResponse<Character>> fetchCharacters();
}
