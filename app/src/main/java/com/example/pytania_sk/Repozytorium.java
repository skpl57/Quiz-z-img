package com.example.pytania_sk;

import java.util.ArrayList;

public class Repozytorium {
    private static ArrayList<Pytanie> pytania = new ArrayList<>();
    private Repozytorium(){
        pytania.add(new Pytanie(R.drawable.szop, "Czy to jest szop pracz?", true, "Pochodzi z rodziny szopowatych."));
        pytania.add(new Pytanie(R.drawable.szczur, "Czy to Remi?", true, "Jest postacią filmu \"Ratatuj\"."));
        pytania.add(new Pytanie(R.drawable.kamien, "Czy ten kamień się wstydzi?", true, "Ewidentnie ma czerwone policzki."));
        pytania.add(new Pytanie(R.drawable.kowadlo, "Czy to kowadło jest zardzewiałe?", false, "Nie ma na nim rdzy."));
    }
    public static ArrayList<Pytanie> zwrocWszystkiePytania(){
        return pytania;
    }


}
