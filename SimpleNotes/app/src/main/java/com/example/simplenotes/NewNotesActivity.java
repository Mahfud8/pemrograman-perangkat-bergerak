package com.example.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class NewNotesActivity extends AppCompatActivity {

    SharedPreferences pref;
    Gson gson;
    ArrayList<Notes> noteslist;
    EditText edtJudul, edtCatatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);

        pref = this.getSharedPreferences(getString(R.string.share_key), MODE_PRIVATE);
        gson = new GsonBuilder().create();

        edtJudul = findViewById(R.id.edtJudul);
        edtCatatan = findViewById(R.id.edtContent);
    }

    public void saveNotes(View v){
        String  strListNotes = pref.getString(getString(R.string.notes_key),"[]");
        noteslist = gson.fromJson(strListNotes, new TypeToken<ArrayList<Notes>>(){}.getType());
        if(noteslist == null) noteslist = new ArrayList<>();

        noteslist.add(new Notes(edtJudul.getText().toString(), edtCatatan.getText().toString()));

        strListNotes = gson.toJson(noteslist);
        pref.edit().putString(getString(R.string.notes_key), strListNotes).apply();

        finish();
    }

    public void cancel(View v){
        finish();
    }
}