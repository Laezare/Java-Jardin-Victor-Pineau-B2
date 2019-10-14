package Basic;

import java.util.Scanner;

public class Terre {

	public Terre() {
	}

	public static void main(String[] args) {
		//Initialise le jardin
		Jardin jardin = new Jardin(10, 10);
		//Initialise le panier
		jardin.ajouterPanier("Ail", 10);
		jardin.ajouterPanier("Carotte", 10);
		jardin.ajouterPanier("Tomate", 10);
		jardin.ajouterPanier("Betterave", 10);
		//Affiche le jardin
		jardin.toString();
		System.out.println("Par défault le jardin contient 10x10 emplacements et le panier 10 graines de chaque végétaux");
		//Debut de la boucle
		Scanner sc = new Scanner(System.in);
		int res;
		do {
			System.out.println("\n1. Semer une graine ;\r\n" + "2. Récolter toutes les plantes qui sont matures ;\r\n"
					+ "3. Passer à la saison suivante (toutes les plantes grandissent) ;\r\n"
					+ "4. Quitter l’application. \n");

			res = sc.nextInt();
			if (res == 1) {
				jardin.semer();
			} else if (res == 2) {
				jardin.recolter();
			} else if (res == 3) {
				jardin.saisonSuivante();
			} else if (res == 4) {
				System.out.println("Vous quittez l'application");
			} else {
				System.out.println("Merci de choisir entre 1 et 4");
			}
			jardin.toString();
		} while (res != 4);
		//Ferme le channel
		sc.close();
		System.out.println("the end");
	}

}
