package objets;
import personnages.Gaulois;
import 

public class Druide {
	private String nom;
	private int force;
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		this.quantitePotion=quantite
		
	}
	
	public void booster(Gaulois gaulois) {
		
	}

	public String getNom() {
		return nom;
	}

	
	
}
