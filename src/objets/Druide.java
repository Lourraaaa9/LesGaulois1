package objets;
import personnages.Gaulois;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		this.parler("J'ai concoct� " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
		
	}
	
	public void booster(Gaulois gaulois) {
		boolean reste = chaudron.resterPotion();
		String nomGaulois=gaulois.getNom();
		if (chaudron.resterPotion()) {
			if (nomGaulois=="Ob�lix") {
				parler("Non, " + nomGaulois + "Non!... Et tu le sais tr�s bien !");
			}
			else {
				int force=chaudron.prendreLouche();
				gaulois.boirePotion(force);
				parler("Tiens, " + nomGaulois + " un peu de potion magique.");
			}
		}
		else {
			parler("D�sol� " + nomGaulois + " il n'y a plus une seule goutte de potion.");
		}
		
	}

	public String getNom() {
		return nom;
	}

	
	
}
