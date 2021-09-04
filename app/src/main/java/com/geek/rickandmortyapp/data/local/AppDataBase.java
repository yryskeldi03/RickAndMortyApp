package com.geek.rickandmortyapp.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geek.rickandmortyapp.models.Character;

@Database(entities = {Character.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract CharacterDao characterDao();
}
