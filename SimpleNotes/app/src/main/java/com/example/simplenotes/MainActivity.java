package com.example.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtJudul, txtContent;
    SharedPreferences pref;
    Gson gson;
    ArrayList<Notes> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJudul = findViewById(R.id.txtjudul);
        txtContent = findViewById(R.id.txtShowNotes);

        pref = this. getSharedPreferences(getString(R.string.share_key),MODE_PRIVATE);
        txtJudul.setText("Catatan "+pref.getString(getString(R.string.username_key),"-"));

        gson = new GsonBuilder().create();
    }

    @Override
    protected void onResume() {
        super.onResume();

        String strListNotes = pref.getString(getString(R.string.notes_key), "[]");
        notesList = gson.fromJson(strListNotes, new TypeToken<ArrayList<Notes>>(){}.getType());

        String contentText = "";

        for(Notes notes : notesList){
            contentText += notes.toString()+'\n';
        }
        txtContent.setText(contentText);
    }

    public void logOut(View v){
        pref.edit().clear().apply();
        Intent it = new Intent(this, LoginActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(it);
    }

    public void addNotes(View v){
        Intent it = new Intent(this, NewNotesActivity.class);
        startActivity(it);
    }

}