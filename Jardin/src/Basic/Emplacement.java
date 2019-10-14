package Basic;
import Flore.Etat;
import Flore.Vegetal;

public class Emplacement {

	private Vegetal vegetal;

	public Emplacement(Vegetal initVegetal) {
		this.vegetal = initVegetal;
	}

	public Vegetal getVegetal() {
		return vegetal;
	}

	public static String toString(Vegetal vegetal, Etat etat) {
		String result = "+";
		
		switch (etat) {
		case GRAINE:
			result = vegetal.dessin[0];
			break;
		case GERME:
			result = vegetal.dessin[1];
			break;
		case TIGE:
			result = vegetal.dessin[2];
			break;
		case FEUILLE:
			result = vegetal.dessin[3];
			break;
		case FLEUR:
			result = vegetal.dessin[4];
			break;
		case MORT:
			result = vegetal.dessin[5];
			break;
		default:
			result = "o";
		}
		return result;
	}

}
