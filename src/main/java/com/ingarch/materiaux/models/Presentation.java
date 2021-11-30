package com.ingarch.materiaux.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Presentation")
public class Presentation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "titre")
    private String titre;


    @Column(name = "texte")
    @Lob
    private String texte;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}