package entities;

import java.util.Date;

public class Article {
    private int id;
    private String titre;
    private String contenu;
    private Date dateCreation;
    private String etat;
    private Catégorie catégorie;

    // Constructeur
    public Article(int id, String titre, String contenu, Date dateCreation, String etat) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.etat = etat;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    public Catégorie getCatégorie() {
        return catégorie;
    }

    public void setCatégorie(Catégorie catégorie) {
        this.catégorie = catégorie;
    }

    // Méthode pour afficher les informations de l'article
    @Override
    public String toString() {
        return "Article [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", dateCreation=" + dateCreation + ", etat=" + etat + "]";
    }
}

