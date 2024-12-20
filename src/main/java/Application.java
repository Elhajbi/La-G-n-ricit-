import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter le programme.");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choix) {
                case 1:
                    System.out.println("\nListe des produits :");
                    for (Produit p : metier.getAll()) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("\nEntrez l'ID du produit : ");
                    long idRecherche = scanner.nextLong();
                    Produit produitTrouve = metier.findById(idRecherche);
                    if (produitTrouve != null) {
                        System.out.println(produitTrouve);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;

                case 3:
                    System.out.print("\nEntrez l'ID du produit : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consommer le saut de ligne

                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();

                    System.out.print("Entrez la marque du produit : ");
                    String marque = scanner.nextLine();

                    System.out.print("Entrez le prix du produit : ");
                    double prix = scanner.nextDouble();

                    scanner.nextLine(); // Consommer le saut de ligne
                    System.out.print("Entrez la description du produit : ");
                    String description = scanner.nextLine();

                    System.out.print("Entrez le nombre en stock : ");
                    int stock = scanner.nextInt();

                    metier.add(new Produit(id, nom, marque, prix, description, stock));
                    System.out.println("Produit ajouté avec succès.");
                    break;

                case 4:
                    System.out.print("\nEntrez l'ID du produit à supprimer : ");
                    long idSuppression = scanner.nextLong();
                    metier.delete(idSuppression);
                    System.out.println("Produit supprimé si l'ID existait.");
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }
}