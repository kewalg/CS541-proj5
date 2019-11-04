package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Button backbtn = findViewById(R.id.btn_goback);
        EditText edttext = findViewById(R.id.edt_note);
        TextView tvtitle = findViewById(R.id.tv_note);
        Intent intent = getIntent();
        final int noteid = intent.getIntExtra("noteid", -1);


        if (noteid != -1) {
            edttext.setText(MainActivity.notes.get(noteid));
            tvtitle.setText(MainActivity.notes.get(noteid));
        }

        edttext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.notes.set(noteid, String.valueOf(s));
                //MainActivity.arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
