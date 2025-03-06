package com.github.owly7.fantarobot.database.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String nome;

    @Column(length = 64)
    private String cognome;

    @Column(length = 128)
    private String email;

    @Column(length = 20)
    private String tel;

    @ManyToMany(mappedBy = "utenti")
    @JsonBackReference
    private List<Corso> corsi;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;

    private LocalDate dataIscrizione;

    public Utente() {
    }

    public Long getId() {
        return id;
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    @Override
    public String toString() {
        return "Docente [\n"
                + "  id=" + id + ",\n"
                + "  nome=" + nome + ",\n"
                + "  cognome=" + cognome + ",\n"
                + "  tel=" + tel + ",\n"
                + "  email=" + email + "\n"
                + "]";
    }

    public enum Ruolo {
        STUDENTE, DOCENTE
    }
}
