package com.geek.rickandmortyapp.di;

import android.content.Context;

import com.geek.rickandmortyapp.data.local.CharacterDao;
import com.geek.rickandmortyapp.data.local.RoomClient;
import com.geek.rickandmortyapp.data.remote.RetrofitClient;
import com.geek.rickandmortyapp.data.remote.RickyAndMortyApi;
import com.geek.rickandmortyapp.data.repositories.CharacterRepository;


import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ActivityContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class AppModule {

    @Provides
    public static CharacterRepository provideCharacterRepository(RickyAndMortyApi api, CharacterDao characterDao) {
        return new CharacterRepository(api, characterDao);
    }

    @Provides
    public static RickyAndMortyApi provideRickAndMortyApi() {
        return new RetrofitClient().provideApi();
    }

    @Provides
    public static RoomClient provideRoomClient() {
        return new RoomClient();
    }

    @Provides
    public static CharacterDao provideCharacterDao(RoomClient client, @ActivityContext Context context) {
        return client.provideCharacterDao(client.provideDataBase(context));
    }

}
