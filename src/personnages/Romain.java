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
	
	public int getForce() {
		return force;
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup>0;
//		int forceAvant=force;
//		this.force=this.force - forceCoup;
//		if (this.force<=0) {
//			this.parler("J'abandonne !");
//		}
//		else {
//			this.parler("Aie");
//		}
//		assert forceAvant > force;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		this.force -= forceCoup;
		if (this.force==0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
		}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (this.nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < this.nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} 
				if(equipements[i] != null && equipements[i].equals(Equipement.CASQUE)) {
					resistanceEquipement += 5;
				}
			}
			if (resistanceEquipement>forceCoup) {
				resistanceEquipement=forceCoup;
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;

		return forceCoup;
	}
	


	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (this.equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = this.equipements[i];
				nbEquipementEjecte++;
				this.equipements[i] = null;
			}
		}
		this.nbEquipement=0;
		return equipementEjecte;
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
			System.out.println("Le soldat " + this.nom + " est déjà  bien protégé!");
			break;
		case 1:
			if (this.equipements[0]==equipementNouv) {
				System.out.println("Le soldat " + this.nom + " possède déjà  un " + equipementNouv);
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
