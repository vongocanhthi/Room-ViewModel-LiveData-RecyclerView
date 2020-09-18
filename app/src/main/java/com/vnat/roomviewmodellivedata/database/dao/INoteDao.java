package com.vnat.roomviewmodellivedata.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vnat.roomviewmodellivedata.model.Note;

import java.util.List;

@Dao
public interface INoteDao {
    @Query("SELECT * FROM note_table")
    LiveData<List<Note>> getAllNote();

    @Insert
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Update
    void updateNote(Note note);
}
