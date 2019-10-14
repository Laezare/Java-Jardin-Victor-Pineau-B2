package Flore;

public abstract class Vegetal {

	public String[] dessin;
	public Etat etat;
	
	public Vegetal() { 
		this.dessin = new String[6];
		dessin[0] = "_";
		dessin[1] = ".";
		dessin[2] = "|";
		dessin[5] = "#";
		this.etat = Etat.GRAINE;
		
	}
	
	public void grandir()
	{
		if (etat != Etat.MORT) {
			this.etat = Etat.values()[this.etat.ordinal() + 1];
		}
	}
}
