package Flore;

import java.util.HashMap;

public class Ail extends Vegetal implements IRacePure {

	public Ail() {

		dessin[3] = "a";
		dessin[4] = "A";
	}

	public void seReproduire(HashMap<String,Integer> panier) {
		panier.replace("Ail", panier.get("Ail") + 3);
	}
}
