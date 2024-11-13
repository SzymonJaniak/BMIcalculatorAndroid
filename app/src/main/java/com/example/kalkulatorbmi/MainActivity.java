package com.example.kalkulatorbmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Oblicz(View view) {
        EditText wzrost = findViewById(R.id.Wzrost);
        Double wpisanywzrost = Double.parseDouble(wzrost.getText().toString());

        EditText waga = findViewById(R.id.Waga);
        Double wpsianawaga = Double.parseDouble(waga.getText().toString());

           Intent intent = new Intent(this, Wyswietlacz.class);
         intent.putExtra(Wyswietlacz.EXTRA_MESSAGE, wpisanywzrost);
         intent.putExtra(Wyswietlacz.EXTRA_DOUBLE, wpsianawaga);

        startActivity(intent);



    }
}