package service.business.connexion;

import dao.connexion.DaoConnexion;

import metier.user.Etudiant;
import metier.user.ListeUsers;
import metier.user.User;

import service.exception.UserException;

/**
 * 
 * @author Lova
 * couche serviceConnexion 
 * des methodes de liaison entre la couche Dao et le controleConnexion
 *
 */
public class ServiceConnexion {

	
private DaoConnexion daoConnexion;
//initialisation de la classe Daoconnexion
	public ServiceConnexion() {
		daoConnexion = new DaoConnexion();
	}
	
	
	
	
	// methode retourne la liste  des utilisateurs
	public ListeUsers getUsers() {
		ListeUsers listeUsers= null;
		listeUsers =daoConnexion.getUsers();
		return listeUsers;
	}




	// methode pour verifier l'email et le mot de passe d'un utilisateur lors de sa connexion
	public boolean isConnexionOK(String email, String pass) {
		System.out.println("ici service  mail ="+email);
		
		return daoConnexion.isConnexionOK(email,pass);
	}




	// methode pour supprimer un utilisateur connaissant son identifiant
	public void doSuppression(int idUser) throws UserException {
	daoConnexion.doSuppression( idUser);
		
	}




	// methode pour afficher la liste des utilisateurs suivant un nom donné
	public  ListeUsers getUser(String nom) {
		
		ListeUsers listeUsers= null;
		listeUsers =daoConnexion.getUser(nom);
		return listeUsers;
		
		
		
	}




	// methode pour afficher la liste des utilisateurs suivant un niveau donné
	public ListeUsers getNivUser(String choixniv) {
		ListeUsers listeUsers= null;
		listeUsers =daoConnexion.getNivUser(choixniv);
		return listeUsers;
	}




	// methode pour afficher les propriétés d'un utilisateur dans modifUser.jsp
	public User getModifier(int idUser){
		// TODO Auto-generated method stub
		
		User user =daoConnexion.getModifier(idUser);
		System.out.println("aty ndray maso loza e" +user);
		return user;
	}




	// methode pour modifier un ou des propriétés d'un utilisateur
	public void modification(Etudiant etudiant) throws UserException{

		daoConnexion.modification(etudiant);
		System.out.println("eto ndary tsik service a" );
	}
	
}


