package com.vnat.roomviewmodellivedata.database.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.vnat.roomviewmodellivedata.database.dao.INoteDao;
import com.vnat.roomviewmodellivedata.model.Note;

@Database(entities = Note.class, exportSchema = false, version = 1)
public abstract class NoteRoom extends RoomDatabase {
    public static String DB_NAME = "note_db";

    public abstract INoteDao iNoteDao();

    private static NoteRoom instance;

    public static synchronized NoteRoom getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, NoteRoom.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    //.addCallback(callback)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

//    private static NoteRoom.Callback callback = new Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new DbAsyncTask(instance).execute();
//        }
//    };

//    private static class DbAsyncTask extends AsyncTask<Void,Void,Void>{
//        private INoteDao iNoteDao;
//
//        public DbAsyncTask(NoteRoom noteRoom) {
//            this.iNoteDao = noteRoom.iNoteDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            iNoteDao.insertNote(new Note("Title 1","Description 1"));
//            iNoteDao.insertNote(new Note("Title 2","Description 2"));
//            iNoteDao.insertNote(new Note("Title 3","Description 3"));
//            return null;
//        }
//    }
}
