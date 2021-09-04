package com.geek.rickandmortyapp.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.geek.rickandmortyapp.models.Character;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insetAll(ArrayList<Character> characters);

    @Query("SELECT * FROM character")
    List<Character> getAllCharacters();
}
