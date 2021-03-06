package com.vnat.roomviewmodellivedata.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vnat.roomviewmodellivedata.R;
import com.vnat.roomviewmodellivedata.model.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHoder> {
    List<Note> noteList;

    public NoteAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NoteViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_note, parent, false);
        return new NoteViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHoder holder, final int position) {
        final Note note = noteList.get(position);
        holder.txtTitle.setText(note.getTitle());
        holder.txtDescription.setText(note.getDescription());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public Note getNodeAt(int position){
        return noteList.get(position);
    }

    static class NoteViewHoder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtTitle)
        TextView txtTitle;
        @BindView(R.id.txtDescription)
        TextView txtDescription;

        public NoteViewHoder(@NonNull final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }

}
