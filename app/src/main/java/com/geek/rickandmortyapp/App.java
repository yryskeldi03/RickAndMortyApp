package com.geek.rickandmortyapp;

import android.app.Application;

import com.geek.rickandmortyapp.data.local.CharacterDao;
import com.geek.rickandmortyapp.data.local.RoomClient;
import com.geek.rickandmortyapp.data.remote.RetrofitClient;
import com.geek.rickandmortyapp.data.remote.RickyAndMortyApi;
import com.geek.rickandmortyapp.data.repositories.CharacterRepository;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class App extends Application {
   // public static RickyAndMortyApi api;
    //public static CharacterDao characterDao;
    @Override
    public void onCreate() {
        super.onCreate();
        //api = new RetrofitClient().provideApi();
        //RoomClient client = new RoomClient();
        //characterDao = client.provideCharacterDao(client.provideDataBase(this));
    }

}
