package com.example.kalkulatorbmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Wyswietlacz extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "wzrost";
    public static final String EXTRA_DOUBLE = "waga";

    Obliczenia obliczenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wyswietlacz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        obliczenia = new Obliczenia();

        Intent intent = getIntent();
        Double waga = intent.getDoubleExtra(EXTRA_DOUBLE,0.0);
        Double wzrost = intent.getDoubleExtra(EXTRA_MESSAGE,0.0);

       double bmi = obliczenia.ObliczBMI(wzrost,waga);

       String interpretacja = obliczenia.InterpretujBMI(bmi);

        TextView InterpretacjaPole = findViewById(R.id.interpretacjaPole);

        TextView bmiPole = findViewById(R.id.bmiPole);

        bmiPole.setText( String.valueOf(bmi));

        InterpretacjaPole.setText(interpretacja);



    }

    public void returnTo(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}