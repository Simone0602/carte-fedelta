package com.example.cartefedelta.movimenti.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Movimento {
    @Id
    @SequenceGenerator(name="movimento_id_seq", sequenceName = "movimento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "movimento_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;
    private LocalDateTime dataora;
    private int quantita;
    private double importo;
    private double totale;
    private int tipo;

    public Movimento(LocalDateTime dataora, int quantita, double importo, double totale, int tipo) {
        this.dataora = dataora;
        this.quantita = quantita;
        this.importo = importo;
        this.totale = totale;
        this.tipo = tipo;
    }

    public Movimento() {
    }

    public LocalDateTime getDataora() {
        return dataora;
    }

    public void setDataora(LocalDateTime dataora) {
        this.dataora = dataora;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Movimento{" +
                "id=" + id +
                ", dataora=" + dataora +
                ", quantita=" + quantita +
                ", importo=" + importo +
                ", totale=" + totale +
                ", tipo=" + tipo +
                '}';
    }
}
