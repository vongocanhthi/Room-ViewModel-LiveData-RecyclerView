package com.vnat.roomviewmodellivedata.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.vnat.roomviewmodellivedata.R;

import butterknife.BindView;

public class UpdateActivity extends AppCompatActivity {

    @BindView(R.id.edtTitle)
    EditText edtTitle;
    @BindView(R.id.edtDescription)
    EditText edtDescription;
    @BindView(R.id.btnUpdate)
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }
}