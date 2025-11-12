package villagegaulois;

import personnages.Gaulois;
import objets.Equipement;
public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement;
	
	
	public Gaulois getGaulois() {
		return gaulois;
	}
	public void setGaulois(Gaulois gaulois) {
		this.gaulois = gaulois;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	
	public String donnerNom() {
		return gaulois.getNom();
	}
}
