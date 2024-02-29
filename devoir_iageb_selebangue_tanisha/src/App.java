import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entities.Article;
import entities.Catégorie;
import service.ArticleService;
import service.CatégorieService;

public class App {
    public static void main(String[] args) {
        CatégorieService catégorieService;
        ArticleService articleService;
        try {
            catégorieService = new CatégorieService();
            articleService = new ArticleService();
        } catch (SQLException e) {
            e.printStackTrace();

            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Menu:");
            System.out.println("1. Créer une Catégorie");
            System.out.println("2. Lister les Catégories");
            System.out.println("3. Ajouter un Article et l'associer à une catégorie");
            System.out.println("4. Lister les articles ainsi que la catégorie associée");
            System.out.println("5. Quitter");
            System.out.print("Votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    System.out.println("Créer une Catégorie");
                    System.out.print("Entrez l'ID de la catégorie: ");
                    int idCatégorie = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Entrez le nom de la catégorie: ");
                    String nomCatégorie = scanner.nextLine();

                    Catégorie nouvelleCatégorie = new Catégorie(idCatégorie, nomCatégorie);

                    try {
                        catégorieService.créerCatégorie(nouvelleCatégorie);
                        System.out.println("Catégorie créée avec succès !");
                    } catch (SQLException e) {
                        System.out.println("Erreur lors de la création de la catégorie : " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Lister les Catégories");

                    try {
                        List<Catégorie> catégories = catégorieService.listerCatégories();
                        if (catégories.isEmpty()) {
                            System.out.println("Aucune catégorie trouvée.");
                        } else {
                            for (Catégorie catégorie : catégories) {
                                System.out.println("ID: " + catégorie.getId() + ", Nom: " + catégorie.getNomCat());
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("Erreur lors de la récupération des catégories : " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println(" Ajouter Article et l’associer à une catégorie");
                    System.out.print("Entrez l'ID de l'article: ");
                    int idArticle = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Entrez le titre de l'article: ");
                    String titreArticle = scanner.nextLine();
                    System.out.print("Entrez le contenu de l'article: ");
                    String contenuArticle = scanner.nextLine();
                    System.out.print("Entrez la date de création de l'article (au format yyyy-mm-dd HH:mm:ss): ");
                    String dateCreationArticleStr = scanner.nextLine();
                    System.out.print("Entrez l'état de l'article: ");
                    String etatArticle = scanner.nextLine();
                    System.out.print("Entrez l'ID de la catégorie à laquelle l'article doit être associé: ");
                    int idCatégorieArticle = scanner.nextInt();
                    scanner.nextLine(); 

                    try {
                        Article nouvelArticle = new Article(idArticle, titreArticle, contenuArticle, 
                                                            java.sql.Timestamp.valueOf(dateCreationArticleStr), etatArticle);
                        Catégorie catégorieAssociée = new Catégorie(idCatégorieArticle, null); 
                        articleService.ajouterArticle(nouvelArticle, catégorieAssociée);
                        System.out.println("Article ajouté avec succès et associé à la catégorie !");
                    } catch (SQLException e) {
                        System.out.println("Erreur lors de l'ajout de l'article : " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("__Lister les articles ainsi que la catégorie associée__");
                
                    try {
                        List<Article> articlesAvecCatégories = articleService.listerArticlesAvecCatégories();

                        if (articlesAvecCatégories.isEmpty()) {
                            System.out.println("Aucun article trouvé.");
                        } else {
                            for (Article article : articlesAvecCatégories) {
                                System.out.println("___________LISTE D'ARTICLE____________");
                                System.out.println("ID: " + article.getId());
                                System.out.println("Titre: " + article.getTitre());
                                System.out.println("Contenu: " + article.getContenu());
                                System.out.println("Date de création: " + article.getDateCreation());
                                System.out.println("État: " + article.getEtat());
                                System.out.println("Catégorie associée: " + article.getCatégorie().getNomCat());
                                System.out.println("______________________________________");
                            }
                        }
                    } catch (SQLException e) {
                        System.out.println("Erreur lors de la récupération des articles avec catégorie associée : " + e.getMessage());
                    }
                    break;
                
                case 5:
                    System.out.println("Quitter");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir à nouveau.");
            }
        } while (choix != 5);

        scanner.close();
    }
}
