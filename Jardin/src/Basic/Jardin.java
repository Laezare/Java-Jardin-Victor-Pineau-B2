package Basic;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import Flore.Ail;
import Flore.Betterave;
import Flore.Carotte;
import Flore.Etat;
import Flore.IOgm;
import Flore.IRacePure;
import Flore.Tomate;
import Flore.Vegetal;

public class Jardin {

	private int longueur;
	private int largeur;
	private Emplacement[][] emplacement;
	private HashMap<String, Integer> panier;

	public Jardin(int initLongueur, int initLargeur) {
		this.longueur = initLongueur;
		this.largeur = initLargeur;
		this.panier = new HashMap<String, Integer>();
		this.emplacement = new Emplacement[initLongueur][initLargeur];

	}

	public String toString() {
		System.out.println("Voici notre jardin :");
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {
				if (emplacement[i][j] == null) {
					System.out.print("o");
				} else {
					Vegetal vegetal = emplacement[i][j].getVegetal();
					System.out.print(Emplacement.toString(vegetal, vegetal.etat));
				}
			}
			System.out.println("");
		}
		System.out.println("Et notre panier contient :");
		for (Map.Entry<String, Integer> e : panier.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue() + " graine(s)");
		}

		return "";
	}

	public void ajouterPanier(String nomDuVegetal, int quantite) {
		panier.put(nomDuVegetal, quantite);
	}

	public void semer() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter x: ");
			int x = scanner.nextInt();
			System.out.println("Enter y: ");
			int y = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter vegetable: ");
			String name = scanner.nextLine();
			if (name.equals("Ail")) {
				emplacement[x][y] = new Emplacement(new Ail());
				System.out.println("Graine plantée");
				panier.replace("Ail", panier.get("Ail") - 1);
			} else if (name.contentEquals("Tomate")) {
				this.emplacement[x][y] = new Emplacement(new Tomate());
				System.out.println("Graine plantée");
				panier.replace("Tomate", panier.get("Tomate") - 1);
			} else if (name.contentEquals("Betterave")) {
				this.emplacement[x][y] = new Emplacement(new Betterave());
				System.out.println("Graine plantée");
				panier.replace("Betterave", panier.get("Betterave") - 1);
			} else if (name.contentEquals("Carotte")) {
				this.emplacement[x][y] = new Emplacement(new Carotte());
				System.out.println("Graine plantée");
				panier.replace("Carotte", panier.get("Carotte") - 1);
			} else {
				System.out.println(name + " graine invalide");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The index you have enter are invalid");
		}
		// scanner.close();
	}

	public void saisonSuivante() {
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {
				if (emplacement[i][j] != null) {
					this.emplacement[i][j].getVegetal().grandir();
				}
			}
		}
	}

	public void recolter() {
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {
				if (emplacement[i][j] == null) {
				} else {
					if (emplacement[i][j].getVegetal().etat == Etat.MORT) {
						this.emplacement[i][j] = null;
					}
					/*if (emplacement[i][j].getVegetal() instanceof IRacePure) {
						IRacePure v = (IRacePure) emplacement[i][j].getVegetal();
						v.seReproduire(this.panier);
						this.emplacement[i][j] = null;
					}
					if (emplacement[i][j].getVegetal() instanceof IOgm) {
						Random random = new Random();
						IOgm v = (IOgm) emplacement[i][j].getVegetal();
						int x = random.nextInt(longueur);
						int y = random.nextInt(largeur);
						v.seDupliquer(x, y);
						this.emplacement[i][j] = null;
						this.emplacement[x][y] = new Emplacement(new Betterave());
					}*/
				}
			}
		}
	}

	public Emplacement[][] getEmplacement() {
		return emplacement;
	}

	public SimpleEntry<Integer, Integer> seDupliquer(int x, int y) {
		SimpleEntry<Integer, Integer> entry = new SimpleEntry<Integer, Integer>(x, y);
		return entry;

	}

	public void setEmplacement(Emplacement[][] emplacement) {
		this.emplacement = emplacement;
	}
}
