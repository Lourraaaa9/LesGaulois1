package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	
	public static void main(String[] args) {
		int nb=0;
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Gaulois obelix = new Gaulois("Ob�lix", 16);
		Romain minus = new Romain("Minus", 6);
		
		asterix.parler("Bonjur Ob�lix.");
		obelix.parler("Bonjour Ast�rix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui tr�s bonne id�e.");
		
		System.out.println("Dans la for�t " + asterix.getNom() + " et " + obelix.getNom() + " tombent nez � nez sur le romain " + minus.toString());
		
		while (nb<3) {
			asterix.frapper(minus);
			nb=nb+1;
		}
	}

}
