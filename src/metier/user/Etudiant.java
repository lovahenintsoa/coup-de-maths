package metier.user;

import java.time.LocalDate;


/**
 * 
 * @author Lova
 * Création de la classe etudiant qui herite de la classe user
 *
 */

public class Etudiant extends User{
	
	
	
	public Etudiant(int idUser, String nom, String email, String motPass, String niveau) {
		super(idUser, nom, email, motPass, niveau);
	}
	
	public Etudiant(int idUser,String nom, String prenom, String email, String motPass, String niveau, LocalDate dateNaissance) {
		super(idUser, nom, prenom, email, motPass, niveau, dateNaissance);

	}
	public Etudiant(String nom, String prenom, String email, String motPass, String niveau, LocalDate dateNaissance) {
		super(nom, prenom, email, motPass, niveau, dateNaissance);

	}

	
	 public Etudiant() {
		super();
	}
	
	@Override
	public String toString() {
		return "Etudiant [getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail()
				+ ", getMotPass()=" + getMotPass() + ", getNiveau()=" + getNiveau() + ", getDateNaissance()="
				+ getDateNaissance() + "]";
	}



	@Override
	public boolean equals (Object obj ) {// Att à la signature
	boolean reponse = false;
	if (obj instanceof Etudiant) {
	if (this.getNom().equals(((Etudiant)obj).getNom()) && this.getIdUser()==(((Etudiant)obj).getIdUser())
			&& this.getEmail().equals(((Etudiant)obj).getEmail()) && this.getMotPass().equals(((Etudiant)obj).getMotPass())
			&& this.getNiveau().equals(((Etudiant)obj).getNiveau()))  reponse = true;
	
	}
	return reponse;
	}
		
		


	
	
	

}
