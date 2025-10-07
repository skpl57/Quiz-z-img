package com.example.pytania_sk;

public class Pytanie {
    private int idObrazek;
    private String trescPytania;
    private boolean odpowiedz;
    private String podpowiedz;
    private boolean czyOdpOk;

    public Pytanie(int idObrazek, String trescPytania, boolean odpowiedz, String podpowiedz) {
        this.idObrazek = idObrazek;
        this.trescPytania = trescPytania;
        this.odpowiedz = odpowiedz;
        this.podpowiedz = podpowiedz;
        czyOdpOk = false;
    }

    public void setCzyOdpOk(boolean czyOdpOk) {
        this.czyOdpOk = czyOdpOk;
    }

    public int getIdObrazek() {
        return idObrazek;
    }

    public String getTrescPytania() {
        return trescPytania;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public String getPodpowiedz() {
        return podpowiedz;
    }

    public boolean isCzyOdpOk() {
        return czyOdpOk;
    }
}
