package personnages;

public class Romain {
	private String nom;
	private int force;
	
	private boolean isInvariantVerified() {
		return force>=0;
	}
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	
	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
		
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert forceCoup>0;
		int forceAvant=force;
		this.force=this.force - forceCoup;
		if (this.force<=0) {
			this.parler("J'abandonne !");
		}
		else {
			this.parler("Aie");
		}
		assert forceAvant > force;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}

}
