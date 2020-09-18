package com.vnat.roomviewmodellivedata.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vnat.roomviewmodellivedata.database.repository.NoteRepository;
import com.vnat.roomviewmodellivedata.model.Note;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
    }

    public LiveData<List<Note>> getAllNote() {
        return noteRepository.getAllNote();
    }

    public void insertNote(Note note){
        noteRepository.insertNote(note);
    }

    public void deleteNote(Note note){
        noteRepository.deleteNote(note);
    }

    public void updateNote(Note note){
        noteRepository.updateNote(note);
    }

}
