package com.example.cartefedelta.carte.model;

import com.example.cartefedelta.carte.Stato;
import com.example.cartefedelta.clienti.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Carta {
    @Id
    @SequenceGenerator(name="carta_id", sequenceName = "carta_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "carta_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;
    private String num_carta;
    private Date data_creazione;
    private Date data_validazione;
    private Date data_scadenza;
    private Stato stato;
    private Long punti;

    @ManyToOne(optional = true)
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    public Carta(String num_carta, Date data_creazione, Date data_validazione, Date data_scadenza, Stato stato, Long punti, Cliente cliente) {
        this.num_carta = num_carta;
        this.data_creazione = data_creazione;
        this.data_validazione = data_validazione;
        this.data_scadenza = data_scadenza;
        this.stato = stato;
        this.punti = punti;
        this.cliente = cliente;
    }

    public Carta() {
    }

    public String getNum_carta() {
        return num_carta;
    }

    public void setNum_carta(String num_carta) {
        this.num_carta = num_carta;
    }

    public Date getData_creazione() {
        return data_creazione;
    }

    public void setData_creazione(Date data_creazione) {
        this.data_creazione = data_creazione;
    }

    public Date getData_validazione() {
        return data_validazione;
    }

    public void setData_validazione(Date data_validazione) {
        this.data_validazione = data_validazione;
    }

    public Date getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(Date data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Long getPunti() {
        return punti;
    }

    public void setPunti(Long punti) {
        this.punti = punti;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id=" + id +
                ", num_carta='" + num_carta + '\'' +
                ", data_creazione=" + data_creazione +
                ", data_validazione=" + data_validazione +
                ", data_scadenza=" + data_scadenza +
                ", stato=" + stato +
                ", punti=" + punti +
                ", cliente=" + cliente +
                '}';
    }
}
