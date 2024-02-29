package entities;

public class Catégorie {
    private int id;
    private String nomCat;

    // Constructeur
    public Catégorie(int id, String nomCat) {
        this.id = id;
        this.nomCat = nomCat;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat = nomCat;
    }

    // Méthode pour afficher les informations de la catégorie
    @Override
    public String toString() {
        return "Catégorie [id=" + id + ", nomCat=" + nomCat + "]";
    }
}
