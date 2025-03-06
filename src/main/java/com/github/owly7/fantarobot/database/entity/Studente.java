package com.github.owly7.fantarobot.database.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import com.github.owly7.fantarobot.database.entity.Classe;
// da dover capire quando esiste la classe

@Entity
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private int tel;
    private LocalDate dataIscrizione;
    private String matricola;

    @ManyToMany
    private List<Corso> corsi = new ArrayList<>(); // da creare ancora l'entità

    @ManyToOne
    private Classe classe; // da creare ancora l'entità


    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Long getId() {
        return id;
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


    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @Override
    public String toString() {
        return "Studente [\n"
                + "  id=" + id + ",\n"
                + "  nome=" + nome + ",\n"
                + "  cognome=" + cognome + ",\n"
                + "  tel=" + tel + ",\n"
                + "  email=" + email + "\n"
                + "  DataIscrizione=" + email + "\n"
                + "  matricola=" + email + "\n"
                + "]";
    }

}



