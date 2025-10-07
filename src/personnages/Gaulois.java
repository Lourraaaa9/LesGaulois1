package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	private Village village;
	
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
	
	public String toString() {
		return nom;
	}
	

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup((force*effetPotion) /3);
		if (effetPotion>1) {
			effetPotion=effetPotion-1;
		}
	}
	
	public void sePresenter() {
		System.out.println("Je suis : " + this.nom + ", " + this.force + ", " + this.village);
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion=forcePotion;
	}
	
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		
		System.out.println(asterix);
		
	}

}
