package com.github.owly7.fantarobot.database.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Docente {

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

    @ManyToMany(mappedBy = "docenti")
    @JsonBackReference
    private List<Corso> corsi;

    public Docente() {
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

}
