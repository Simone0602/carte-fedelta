package com.example.cartefedelta.prodotti.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Prodotto {

    @Id
    @SequenceGenerator(name="prodotto_id_seq", sequenceName = "prodotto_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "prodotto_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;
    private String codice;
    private String descrizione;
    private double prezzo;
    private double punti;

    public Prodotto(String codice, String descrizione, double prezzo, double punti) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.punti = punti;
    }

    public Prodotto() {
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPunti() {
        return punti;
    }

    public void setPunti(double punti) {
        this.punti = punti;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", codice='" + codice + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", punti=" + punti +
                '}';
    }
}
