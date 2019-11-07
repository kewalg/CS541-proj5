package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    Button btn_new, btn_del;
    static ArrayAdapter arrayAdapter;
    static ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv_notes);
        btn_new = findViewById(R.id.btn_newnote);
        btn_del = findViewById(R.id.btn_delete);


        notes.add("Example");
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("noteid", i);
                startActivity(intent);
            }
        });

        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(i);
            }
        });
    }
}
