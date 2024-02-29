package service;

import java.sql.SQLException;
import java.util.List;

import entities.Article;
import entities.Catégorie;
import repositories.ArticleRepository;

public class ArticleService {
    private ArticleRepository articleRepository;

    // Constructeur
    public ArticleService() throws SQLException {
        articleRepository = new ArticleRepository();
    }

    public void ajouterArticle(Article article, Catégorie catégorie) throws SQLException {
        articleRepository.ajouterArticle(article, catégorie);
    }
    
    public List<Article> listerArticlesAvecCatégories() throws SQLException {
        return articleRepository.listerArticlesAvecCatégories();
    }
}
