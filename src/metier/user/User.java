package metier.user;

import java.time.LocalDate;
/**
 * 
 * @author Lova
 * Creation de la classe mere user
 *
 */


public abstract class User {
	
	private int idUser;
	private String nom;
	private String prenom;
	private String email;
	private String motPass;
	private String niveau;
	private LocalDate dateNaissance;
	private Niveau niv;
	
	/**
	 * constructeur1 pour User professeur 
	 * 
	 * @param nom 
	 * @param prenom
	 * @param email
	 * @param motPass
	 * @param niveau
	 */
	
	
	
	public User(String nom, String prenom, String email, String motPass, String niveau) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPass = motPass;
		this.niveau = niveau;
	}
	
	public User(int idUser, String nom, String email, String motPass, String niveau) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.email = email;
		this.motPass = motPass;
		this.niveau = niveau;
	}

	public User(int idUser,String nom, String prenom, String email, String motPass, String niveau) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPass = motPass;
		this.niveau = niveau;
	}
	/**
	 * constructeur2 pour User Etudiant 
	 * 
	 * @param nom 
	 * @param prenom
	 * @param email
	 * @param motPass
	 * @param niveau
	 *  @param dateNaissance
	 */
	public User(int idUser, String nom, String prenom, String email, String motPass, String niveau,
			LocalDate dateNaissance, Niveau niv) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPass = motPass;
		this.niveau = niveau;
		this.dateNaissance = dateNaissance;
		this.niv = niv;
	}
	public User(int idUser,String nom, String prenom, String email, String motPass, String niveau, LocalDate dateNaissance) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motPass = motPass;
		this.niveau = niveau;
		this.dateNaissance = dateNaissance;
	}
		
		public User(String nom, String prenom, String email, String motPass, String niveau, LocalDate dateNaissance) {
			super();
			
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.motPass = motPass;
			this.niveau = niveau;
			this.dateNaissance = dateNaissance;
	}





	public int getIdUser() {
		return idUser;
	}



	

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}




	public String getNom() {
		return nom;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}




	public String getMotPass() {
		return motPass;
	}




	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}






	public String getNiveau() {
		return niveau;
	}





	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}




	public Niveau getNiv() {
		return niv;
	}





	public void setNiv(Niveau niv) {
		this.niv = niv;
	}


// fonction qui verifie le mail dans Creation prof et CreationEtudiant
public String verifEmail(String s) {
	// TODO verifier mail
	String reponse="";
	int ad = 0;
	int point = 0;
	int compt=0;
	int compt1=0;

	try
	{
	for(int i=1;i<s.length()-2;i++)
	{
		if (s.charAt(i)=='@') 
			{ad=i;
			compt=compt+1;
			}
		if (s.charAt(i)=='.') 
			{point=i;
			compt1=compt1+1;
			}
	}
	if ((compt==1)&&(compt1>=1))
	{
		if ((ad!=0) && ((point-ad)>1)) reponse=s;
		else reponse="erreur mail";
		
	}
	else reponse="erreur mail";
	}
	catch (NullPointerException e) {
		System.out.println("champs nuls");
	}
	return reponse;
	
}



	public User() {
	super();
}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motPass="
				+ motPass + "]";
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}



	
	
	
}
