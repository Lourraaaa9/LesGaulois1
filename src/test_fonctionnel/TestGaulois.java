package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	
	public static void main(String[] args) {
		int nb=0;
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);
		Romain minus = new Romain("Minus", 6);
		
		asterix.parler("Bonjur Obélix.");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");
		
		System.out.println("Dans la forêt " + asterix.getNom() + " et " + obelix.getNom() + " tombent nez à nez sur le romain " + minus.toString());
		
		while (nb<3) {
			asterix.frapper(minus);
			nb=nb+1;
		}
	}

}
