package Flore;

import java.util.HashMap;

public class Carotte extends Vegetal implements IRacePure {

	public Carotte() {
		super.dessin[3] = "c";
		super.dessin[4] = "C";
	}
	
	public void seReproduire(HashMap<String,Integer> panier) {
		panier.replace("Carotte", panier.get("Carotte") + 3);
	}

}
