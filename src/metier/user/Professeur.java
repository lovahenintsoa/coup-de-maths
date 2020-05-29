package metier.user;

/**
 * 
 * @author Lova
 * Création de la classe Professeur qui herite de la classe user
 *
 */

public class Professeur extends User{


	
	
	// Constructor pour professeur
	
	public Professeur(int idUser, String nom, String email, String motPass, String niveau) {
		super(idUser, nom, email, motPass, niveau);
	}
	
	
	public Professeur(int idUser,String nom, String prenom, String email, String motPass, String niveau) {
		super(idUser,nom, prenom, email, motPass, niveau);

	}
	public Professeur(String nom, String prenom, String email, String motPass, String niveau) {
		super(nom, prenom, email, motPass, niveau);

	}
	public  Professeur() {
		super();
	}
	
	//private ArrayList<Reponse> reponse;
	
	
	// constructeur profs
	

	@Override
	public String toString() {
		return "Professeur [getNiveau()=" + getNiveau()  + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getMotPass()=" + getMotPass()
				
				+ "]";
	}

	
	/*
	 * Error il faut attendre la Classe Reponse
	 */

//	public ArrayList<Reponse> getReponse() {
//		return reponse;
//	}
//
//	public void setReponse(ArrayList<Reponse> reponse) {
//		this.reponse = reponse;
//	}

	
	}

	

