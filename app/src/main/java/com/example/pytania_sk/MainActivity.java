package com.example.pytania_sk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        takB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzanie(true);
                        numerPytania++;
                        wyswietlPytanie(numerPytania);
                    }
                }
        );
        nieB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzanie(false);
                        numerPytania++;
                        wyswietlPytanie(numerPytania);
                    }
                }
        );
        podpowiedzB.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                      Toast.makeText(MainActivity.this, pytania.get(numerPytania).getPodpowiedz(), Toast.LENGTH_SHORT).show();
//                      pytania.get(numerPytania).setBranoPodpowidz(true);
                        Intent intencja = new Intent(MainActivity.this, PodpowiedzActivity.class);
                        intencja.putExtra("NUMERPYTANIA", numerPytania);
                        startActivity(intencja);

                    }
                }
        );

    }
    private void wyswietlPytanie(int ktorePytanie){
        if(numerPytania == pytania.size()){
            zdjP.setVisibility(View.INVISIBLE);

            takB.setVisibility(View.INVISIBLE);
            nieB.setVisibility(View.INVISIBLE);
            nastepneB.setVisibility(View.INVISIBLE);
            podpowiedzB.setVisibility(View.INVISIBLE);

            podsumowanie();
        }
        else{
            pytanieT.setText(pytania.get(ktorePytanie).getTrescPytania());
            zdjP.setImageResource(pytania.get(ktorePytanie).getIdObrazek());
        }
    }
    private void sprawdzanie(boolean wybor){
        if(pytania.get(numerPytania).getOdpowiedz() == wybor){
            pytania.get(numerPytania).setCzyOdpOk(true);
            Toast.makeText(this, "Poprawna odpowiedź!", Toast.LENGTH_SHORT).show();
        }
        else{
            pytania.get(numerPytania).setCzyOdpOk(false);
            Toast.makeText(this, "Zła odpowiedź!", Toast.LENGTH_SHORT).show();
        }
    }
    private void podsumowanie(){
        int dobrze = 0;
        for(int i = 0; i < pytania.size(); i++){
            if(pytania.get(i).getCzyOdpOk()){
                dobrze++;
            }
            if(pytania.get(i).getCzyOdpOk() && !pytania.get(i).getBranoPodpowidz()){
                dobrze++;
            }
        }

        pytanieT.setText("Zdobyto łącznie " + dobrze + " punktów!");
    }
}