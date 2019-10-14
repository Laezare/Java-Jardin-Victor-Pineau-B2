package Flore;

import java.util.AbstractMap.SimpleEntry;

public class Betterave extends Vegetal implements IOgm {

	public Betterave() {
		super.dessin[3] = "b";
		super.dessin[4] = "B";
	}
	
	public SimpleEntry<Integer,Integer> seDupliquer(int x , int y) {
		SimpleEntry<Integer,Integer> entry = new SimpleEntry<Integer,Integer>(x, y);
		return entry;
		
	}
}
