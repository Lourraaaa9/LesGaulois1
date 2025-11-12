package villagegaulois;

import objets.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees=new Trophee[200];
	private int nbTrophee=0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement don) {
		nbTrophee++;
		Trophee nouvTrophee = new Trophee();
		nouvTrophee.setEquipement(don);
		nouvTrophee.setGaulois(gaulois);
		trophees[nbTrophee]=nouvTrophee;
	}
	
	public String extraireInstructionsOCaml() {
		String chaine = "let musee = [ \n";
		for (int i=0; i<nbTrophee-1; i++) {
			chaine += trophees[i].donnerNom() + ", " + trophees[i].getEquipement().name() + ";\n";
		}
		chaine += trophees[nbTrophee-1].donnerNom() + ", " + trophees[nbTrophee-1].getEquipement().name() + "\n ]";
		return chaine;
	}

}
