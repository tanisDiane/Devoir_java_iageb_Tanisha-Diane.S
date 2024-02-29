package service;

import java.sql.SQLException;
import java.util.List;

import entities.Article;
import entities.Catégorie;
import repositories.CatégorieRepository;

public class CatégorieService {
    private CatégorieRepository catégorieRepository;

    // Constructeur
    public CatégorieService() throws SQLException {
        catégorieRepository = new CatégorieRepository();
    }

    // Méthode pour créer une nouvelle catégorie
    public void créerCatégorie(Catégorie catégorie) throws SQLException {
        catégorieRepository.créerCatégorie(catégorie);
    }

    // Méthode pour lister toutes les catégories
    public List<Catégorie> listerCatégories() throws SQLException {
        return catégorieRepository.listerCatégories();
    }

    // Méthode pour ajouter un article et l'associer à une catégorie
    public void ajouterArticle(Article article, Catégorie catégorie) throws SQLException {
        catégorieRepository.ajouterArticle(article, catégorie);
    }

    // Méthode pour lister les articles ainsi que la catégorie associée
    public List<Article> listerArticlesAvecCatégories() throws SQLException {
        return catégorieRepository.listerArticlesAvecCatégories();
    }
}
