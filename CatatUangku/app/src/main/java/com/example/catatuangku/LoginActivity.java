package com.example.catatuangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        edtUsername = findViewById(R.id.edtUsername);
        pref = this.getSharedPreferences(getString(R.string.share_key), MODE_PRIVATE);

        checkLogin();
    }

    private void checkLogin() {
        String username = pref.getString(getString(R.string.username_key),"");
        if(username.length() > 3){
            toMain();
        }
    }

    public void toMain(){
        Intent it = new Intent(this, MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(it);
    }

    public void login(View view){
        String username = edtUsername.getText().toString();
        if(username.length() > 3) {
            pref.edit().putString(getString(R.string.username_key), username).apply();
            toMain();
        }else
            Toast.makeText(this, "Username harus lebih dari tiga huruf", Toast.LENGTH_LONG).show();

    }
}