package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckedTextView;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends ListActivity {

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


        notes.add("");
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, notes);
        lv.setAdapter(arrayAdapter);

        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


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

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Long Press any Note to delete!", Toast.LENGTH_LONG).show();
            }
        });

       /* lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int itemdelete = position;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Confirm Delete?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                notes.remove(itemdelete);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();

                return true;
            }
        });*/

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemdelete = i;
                AppCompatCheckedTextView checkBox = (AppCompatCheckedTextView) view;
                //Log.i("CHECK", checkBox.isChecked() + "" + checkBox.getText().toString());

                SparseBooleanArray sp = getListView().getCheckedItemPositions();
                String str = "";
                for (int j = 0; j < sp.size(); j++) {
                    str += notes[sp.keyAt(i)];                                                  /////////WORK HERE////////////
                }
                Toast.makeText(MainActivity.this, "" + str, Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this, "checked items are:" + itemdelete, Toast.LENGTH_SHORT).show();
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

}
