package com.vnat.roomviewmodellivedata.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.vnat.roomviewmodellivedata.database.dao.INoteDao;
import com.vnat.roomviewmodellivedata.database.room.NoteRoom;
import com.vnat.roomviewmodellivedata.model.Note;

import java.util.List;

public class NoteRepository{
    private INoteDao iNoteDao;

    public NoteRepository(Application application) {
        NoteRoom noteRoom = NoteRoom.getInstance(application);
        iNoteDao = noteRoom.iNoteDao();
    }

    public LiveData<List<Note>> getAllNote(){
        return iNoteDao.getAllNote();
    }

    public void insertNote(Note note){
        iNoteDao.insertNote(note);
    }

    public void deleteNote(Note note){
        iNoteDao.deleteNote(note);
    }

    public void updateNote(Note note){
        iNoteDao.updateNote(note);
    }

//    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{
//        private INoteDao iNoteDao;
//
//        public InsertNoteAsyncTask(INoteDao iNoteDao) {
//            this.iNoteDao = iNoteDao;
//        }
//
//        @Override
//        protected Void doInBackground(Note... notes) {
//            iNoteDao.insertNote(notes[0]);
//            return null;
//        }
//    }
}
