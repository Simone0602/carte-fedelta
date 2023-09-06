package com.example.cartefedelta.clienti.model;

import com.example.cartefedelta.carte.model.Carta;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @SequenceGenerator(name="cliente_id", sequenceName = "cliente_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "cliente_id_seq")
    @Column(name = "id", updatable = false)
    private Long id;
    private String nome;
    private String codice;
    private String cognome;
    private String email;
    private String citta;
    @OneToMany(mappedBy = "cliente")
    private List<Carta> carte = new ArrayList<>();

    public Cliente(String nome, String codice, String cognome, String email, String citta, List<Carta> carte) {
        this.nome = nome;
        this.codice = codice;
        this.cognome = cognome;
        this.email = email;
        this.citta = citta;
        this.carte = carte;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public List<Carta> getCarte() {
        return carte;
    }

    @Override
    public String toString() {
        return "Clienti{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codice='" + codice + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", città='" + citta + '\'' +
                ", carte=" + carte +
                '}';
    }
}
