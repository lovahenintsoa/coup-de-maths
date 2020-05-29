package service.business.inscription;


import dao.inscription.DaoInscription;

import metier.user.Etudiant;
import metier.user.Professeur;

import service.exception.UserException;

public class ServiceInscription {
	private DaoInscription daoInscription; 
	
	// initialisation de la Classe DaoInscription
	public ServiceInscription() {
		System.out.println("ici get service");
		daoInscription = new DaoInscription();
	}
	
	// methode pour creer un professeur
	public void CreerProf(Professeur prof) throws UserException  {
	
		daoInscription.creer(prof);
	
	}
	// methode pour creer un Etudiant
	public void CreerEtud(Etudiant etudiant) throws UserException  {
		
		daoInscription.creerE( etudiant);
	
	}

}
