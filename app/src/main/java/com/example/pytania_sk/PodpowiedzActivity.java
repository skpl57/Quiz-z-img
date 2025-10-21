package com.example.pytania_sk;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PodpowiedzActivity extends AppCompatActivity {
    private TextView podpowiedzTekst, tytulTekst;
    private ImageView obrazekPodpowiedzi;
    private ArrayList<Pytanie> pytania = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_podpowiedz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pytania = Repozytorium.zwrocWszystkiePytania();

        int numerPytania = getIntent().getIntExtra("NUMERPYTANIA", 0);
        podpowiedzTekst = findViewById(R.id.podpowiedzText);
        tytulTekst = findViewById(R.id.tytulText);
        obrazekPodpowiedzi = findViewById(R.id.podpowiedzImg);

        tytulTekst.setText("Podpowiedz do pytania nr " + (numerPytania + 1));
        podpowiedzTekst.setText(pytania.get(numerPytania).getPodpowiedz());
        obrazekPodpowiedzi.setImageResource(pytania.get(numerPytania).getIdObrazek());
    }

}