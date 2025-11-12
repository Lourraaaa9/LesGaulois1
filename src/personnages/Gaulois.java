package personnages;

import objets.Equipement;
import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	//private int force;
	private int effetPotion=1;
	private Village village;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	
	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}

	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return nom;
	}
	

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force*effetPotion) /3);
//		if (effetPotion>1) {
//			effetPotion=effetPotion-1;
//		}
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " +
		romain.getNom());
		Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++,
			nbTrophees++) {
			this.trophees[nbTrophees] = tropheesBataille[i];
		}
	}
	
	public void sePresenter() {
		if (this.village==null) {
			parler("Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.");
		}else if (this.equals(village.getChef())) {
			parler("Bonjour, je m'appelle " + nom + ". Je suis le chef du village \"" + village.getNom() + "\".");
			
		}else if (this.village != null){
			parler("Bonjour, je m'appelle " + nom + ". J'habite le village \"" + village.getNom() + "\".");
		}
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;
	}
	
	public void faireUneDonnation(Musee musee) {
		if (this.nbTrophees!=0) {
			String texte = "Je donne au musée tous mes tropées :";
			while (nbTrophees>0) {
				musee.donnerTrophees(this, this.trophees[nbTrophees-1]);
				texte =texte + "\n - " + trophees[nbTrophees-1].name();
				nbTrophees--;
			}
			parler(texte);
		}
	}
	
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		
		System.out.println(asterix);
		
	}

}
