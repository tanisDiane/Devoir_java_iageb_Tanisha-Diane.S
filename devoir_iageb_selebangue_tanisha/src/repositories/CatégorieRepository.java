package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Article;
import entities.Catégorie;

public class CatégorieRepository {
    private Connection connection;


    public CatégorieRepository() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/devoir_java";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);
    }


    public void créerCatégorie(Catégorie catégorie) throws SQLException {
        String sql = "INSERT INTO catégorie (id_ca, nomCat) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, catégorie.getId());
        statement.setString(2, catégorie.getNomCat());
        statement.executeUpdate();
    }

    public List<Catégorie> listerCatégories() throws SQLException {
        List<Catégorie> catégories = new ArrayList<>();
        String sql = "SELECT * FROM catégorie";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id_ca");
            String nomCat = resultSet.getString("nomCat");
            Catégorie catégorie = new Catégorie(id, nomCat);
            catégories.add(catégorie);
        }
        return catégories;
    }

    public void ajouterArticle(Article article, Catégorie catégorie) throws SQLException {
        String sql = "INSERT INTO article (id, titre, contenu, dateCreation, etat, id_ca) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, article.getId());
        statement.setString(2, article.getTitre());
        statement.setString(3, article.getContenu());
        statement.setTimestamp(4, new java.sql.Timestamp(article.getDateCreation().getTime()));
        statement.setString(5, article.getEtat());
        statement.setInt(6, catégorie.getId());
        statement.executeUpdate();
    }

    public List<Article> listerArticlesAvecCatégories() throws SQLException {
        List<Article> articles = new ArrayList<>();
        String sql = "SELECT article.*, catégorie.nomCat FROM article INNER JOIN catégorie ON article.id_ca = catégorie.id_ca";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String titre = resultSet.getString("titre");
            String contenu = resultSet.getString("contenu");
            Date dateCreation = resultSet.getTimestamp("dateCreation");
            String etat = resultSet.getString("etat");
            int idCatégorie = resultSet.getInt("id_ca");
            String nomCatégorie = resultSet.getString("nomCat");
            Catégorie catégorie = new Catégorie(idCatégorie, nomCatégorie);
            Article article = new Article(id, titre, contenu, dateCreation, etat);
            article.setCatégorie(catégorie);
            articles.add(article);
        }
        return articles;
    }

}
