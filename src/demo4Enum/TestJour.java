package demo4Enum;




public class TestJour {

	public static void main(String[] args) {
		
	//	Jour unJour = Jour.SAMEDI;

		// its positionin its enum declaration, where the initial constant is assignedan ordinal of zero
		// lundi : 0, mardi : 1, mercredi : 2 .. samedi : 5, dimanche : 6
//		System.out.println("numero de " + unJour + " : " + unJour.ordinal());
//		System.out.println(unJour + " : " + unJour.action());
//		System.out.println(unJour + " - heures travaillees : " + unJour.getNbHeuresTravaillees());
//		System.out.println(unJour + " - heures midi        : " + unJour.getNbHeuresPauseMidi());
//		
//		System.out.println("\n*** Et pour lundi ");
//		System.out.println("Le nom du jour  est :"+ Jour.valueOf("LUNDI"));
		
		// java.lang.IllegalArgumentException: No enum constant demo4Enum.Jour.lundi
		// System.out.println("Le nom du jour  est :"+ Jour.valueOf("lundi"));
//		
//		String nivo="troisieme";
//	
//		
//		for (Niveau niv : Niveau.values()) {
//			if(nivo.equals(niv.getLibNiveau())) {int id=niv.getNumeroNiveau();}
//			
//		}

//		System.out.println("\n*** on itere sur l'enum");
//		for (Jour jour : Jour.values()) {
//			System.out.println("nombre d'heures travaillées de " + jour + " : " + jour.getNbHeuresTravaillees());
//			System.out.println("nombre d'heures à midi de      " + jour + " : " + jour.getNbHeuresPauseMidi() + "\n");
//		}
	}

}
;