package com.vnat.roomviewmodellivedata.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vnat.roomviewmodellivedata.R;
import com.vnat.roomviewmodellivedata.adapter.NoteAdapter;
import com.vnat.roomviewmodellivedata.model.Note;
import com.vnat.roomviewmodellivedata.viewmodel.NoteViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    NoteViewModel noteViewModel;
    NoteAdapter noteAdapter;
    ItemTouchHelper itemTouchHelper;

    @BindView(R.id.edtTitle)
    EditText edtTitle;
    @BindView(R.id.edtDescription)
    EditText edtDescription;
    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.rcvNote)
    RecyclerView rcvNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        ButterKnife.bind(this);

        init();
        getListNote();
        event();

    }

    private void init() {
        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteViewModel.deleteNote(noteAdapter.getNodeAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void event() {
        itemTouchHelper.attachToRecyclerView(rcvNote);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String description = edtDescription.getText().toString();

                Note note = new Note(title, description);

                noteViewModel.insertNote(note);
                Toast.makeText(MainActivity.this, "Add Success", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getListNote() {

        rcvNote.setLayoutManager(new LinearLayoutManager(this));
        rcvNote.setHasFixedSize(true);

        noteViewModel.getAllNote().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteAdapter = new NoteAdapter(notes);
                rcvNote.setAdapter(noteAdapter);
                noteAdapter.notifyDataSetChanged();
            }
        });
    }

}