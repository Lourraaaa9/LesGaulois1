package objets;
import personnages.Gaulois;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	
	public Druide(String nom, int force, Chaudron chaudron) {
		this.nom = nom;
		this.force = force;
		this.chaudron = chaudron;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		this.parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
		
	}
	
	public void booster(Gaulois gaulois) {
		String nomGaulois=gaulois.getNom();
		if (chaudron.resterPotion()) {
			if ("Obélix".equals(nomGaulois)) {
				parler("Non, " + nomGaulois + " Non!... Et tu le sais très bien !");
			}
			else {
				force=chaudron.prendreLouche();
				gaulois.boirePotion(force);
				parler("Tiens, " + nomGaulois + " un peu de potion magique.");
			}
		}
		else {
			parler("Désolé " + nomGaulois + " il n'y a plus une seule goutte de potion.");
		}
		
	}

	public String getNom() {
		return nom;
	}

	
	
}
