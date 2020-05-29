package metier.user;

public enum Niveau {

	NIVEAU_1("sixieme",1), NIVEAU_2("cinquieme",2), NIVEAU_3("quatrieme",3), NIVEAU_4("troisieme",4)
	, NIVEAU_5("seconde",5), NIVEAU_6("premiere",6), NIVEAU_7("terminale",7);
	private String libNiveau;
	private int numeroNiveau;

	/**
	 * constructeur de Niveau 
	 * 
	 * @param libNiveau 
	 * @param numero
	 
	 */
	private Niveau(String libNiveau, int numero) {
		this.libNiveau = libNiveau;
		this.setNumeroNiveau(numero);
	}


	public String getLibNiveau() {
		return libNiveau;
	}

// une methode à mettre en place
	public static Niveau getNiveau(String niveau) {
		// TODO Auto-generated method stub
		return Niveau.NIVEAU_3;
	}


	public int getNumeroNiveau() {
		return numeroNiveau;
	}


	public void setNumeroNiveau(int numeroNiveau) {
		this.numeroNiveau = numeroNiveau;
	}
	
	
}

