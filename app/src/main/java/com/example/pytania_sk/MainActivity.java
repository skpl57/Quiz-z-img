package com.example.pytania_sk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> pytania = new ArrayList<>();
    private Button takB;
    private Button nieB;
    private Button nastepneB;
    private Button podpowiedzB;
    private TextView pytanieT;
    private ImageView zdjP;
    private int numerPytania = 0;
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

        pytania.add(new Pytanie(R.drawable.szop, "Czy to jest szop pracz?", true, "Pochodzi z rodziny szopowatych."));
        pytania.add(new Pytanie(R.drawable.szczur, "Czy to Remi?", true, "Jest postacią filmu \"Ratatuj\"."));
        pytania.add(new Pytanie(R.drawable.kamien, "Czy ten kamień się wstydzi?", true, "Ewidentnie ma czerwone policzki."));
        pytania.add(new Pytanie(R.drawable.kowadlo, "Czy to kowadło jest zardzewiałe?", false, "Nie ma na nim rdzy."));

        takB = findViewById(R.id.takButton);
        nieB = findViewById(R.id.nieButton);
        nastepneB = findViewById(R.id.nastepneButton);
        podpowiedzB = findViewById(R.id.podpowiedzButton);
        pytanieT = findViewById(R.id.trescPytania);
        zdjP = findViewById(R.id.zdjecie);
        wyswietlPytanie(0);

        nastepneB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(numerPytania < pytania.size()){
                            numerPytania++;
                            wyswietlPytanie(numerPytania);
                        }
                    }
                }
        );
    }
    private void wyswietlPytanie(int ktorePytanie){
        pytanieT.setText(pytania.get(ktorePytanie).getTrescPytania());
        zdjP.setImageResource(pytania.get(ktorePytanie).getIdObrazek());
    }
}