package com.joaovictorsm.padcalculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class WelcomeActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
        ((TextView) findViewById(R.id.texto_welcome)).setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
    }

    public void passaParaMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
