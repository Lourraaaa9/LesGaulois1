package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements= {null,null};
	private int nbEquipement = 0;
	
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
	
	private void ajoutEquipement(Equipement equipementNouv) {
		if (this.nbEquipement==1) {
			this.equipements[1]=equipementNouv;
		}else {
			this.equipements[0]=equipementNouv;
		}
		nbEquipement++;
		System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equipementNouv);
	}
	
	public void sEquiper(Equipement equipementNouv) {
		switch (this.nbEquipement) {
		case 2 :
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé!");
			break;
		case 1:
			if (this.equipements[0]==equipementNouv) {
				System.out.println("Le soldat " + this.nom + " possède déjà un " + equipementNouv);
			}
			else {
				ajoutEquipement(equipementNouv);
			}
			break;
		default : 
			ajoutEquipement(equipementNouv);
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		for (Equipement equipement : Equipement.values()) {
			System.out.println(equipement);
		}
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);

		
	}

}
