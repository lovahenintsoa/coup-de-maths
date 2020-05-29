package demo4Enum;
/**
 * class enum permettant de definir les jours de la semaine,
 * le nombre d'heures travaillées et le nombre d'heure pour la pause de midi
 * @author Stag05
 */
public enum Jour {
	LUNDI(8,1), MARDI(8,2), MERCREDI(4,0), JEUDI(8,1), VENDREDI(7,2), SAMEDI(0), DIMANCHE(0);

	private int nbHeuresTravaillees;
	private int nbHeuresPauseMidi;
	
	private Jour(int nbHeuresTravaillees) {
		this.nbHeuresTravaillees = nbHeuresTravaillees;
	}
	private Jour(int nbHeuresTravaillees, int heuresPauseMidi) {
		this.nbHeuresTravaillees 	= nbHeuresTravaillees;
		this.nbHeuresPauseMidi 		= heuresPauseMidi;
	}

	public int getNbHeuresTravaillees() {
		return nbHeuresTravaillees;
	}
	
	public int getNbHeuresPauseMidi() {
		return nbHeuresPauseMidi;
	}

	public String action() {
		switch(this) {
			case SAMEDI 	: return "cinema";
			case DIMANCHE 	: return "dormir";
			default 		: return "travailler";
		}
 	}

}
