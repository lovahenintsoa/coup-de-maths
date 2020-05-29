package service.web.inscription;

import java.io.IOException;




import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.user.Etudiant;
import metier.user.Professeur;

import service.business.inscription.ServiceInscription;
import service.exception.UserException;


/**
 * Servlet : Un controleur qui traite l'url /inscription/*
 * Creation et insertion dans la base d'un utilisateur Professeur ou Etudiant
 */
@WebServlet( urlPatterns = {"/inscription/*"} )
public class ControlInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String nom;
	String prenom;
	String email;
	String tpdateNaissance;
	LocalDate dateNaissance;
	String tpemail;
	String res;
	String motdePass;
	String formNiveau;
	Professeur proverif =new Professeur();
       
	private ServiceInscription serviceInscription;

	// initialisation de la classe serviceInscription
	@Override
	public void init() throws ServletException {
		serviceInscription = new ServiceInscription();
	}

	// dispatche l'url /professeur et /etudiant
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String chemin  		= request.getPathInfo();		
		
		if      (chemin.equals("/professeur")) 			doProf(request, response);
		else if (chemin.equals("/etudiant")) 			doEtud(request, response);				
		
		else 											doAutres(request, response);
		
	}
	// redirige vers la page 404.jsp
	private void doAutres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pageerreur").forward(request,response);	
		
	}
	// redirige vers la page inscriptionEtudiant.jsp
	private void doEtud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/etudiant").forward(request,response);
		
	}
	// redirige vers la page inscriptionProf.jsp
	private void doProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/professeur").forward(request,response);
		
	}
	
	// methode qui active toutes les actions et methode "post" des pages inscriptionProf.jsp et inscriptionProf.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chemin  		= request.getPathInfo();
		System.out.println("verif " + request.getContextPath());
	System.out.println(chemin);
		if (chemin.equals("/creerProf")) 			 			doCreerProf(request, response);
		else if(chemin.equals("/creerEtud"))         			doCreerEtud(request,response);
		else if(chemin.equals("/creerRetour"))         			docreerRetour(request,response);
		else if(chemin.equals("/creerRetour1"))         		docreerRetour1(request,response);
		else 										 			doAutres(request, response);
	
	}
	

	private void docreerRetour1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		docreerRetour(request,response);
		
	}

	private void docreerRetour(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/accueil").forward(request,response);
		
	}

	// methode pour creer un Etudiant
	private void doCreerEtud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do creer post");
		nom =request.getParameter("nom").strip();
		prenom= request.getParameter("prenom").strip();
		tpdateNaissance=request.getParameter("dateNaissance");
		tpemail=request.getParameter("email").strip();
		motdePass=request.getParameter("pass").strip();
		formNiveau=request.getParameter("niveau").strip();
		
		// concersion en Localdate
		dateNaissance=LocalDate.parse(tpdateNaissance);
		
		// verification du mail par la fonction verifEmail
		res = proverif.verifEmail(tpemail);
		if(res!="erreur mail") email=res;
		else System.out.println(" le mail renvoyé est null afffichage BDD indispo ou mail erroné");		
		
		
		try {
			Etudiant etudiant = new Etudiant(nom, prenom, email, motdePass, formNiveau, dateNaissance);
			serviceInscription.CreerEtud(etudiant);
		} catch (UserException e) {
			request.setAttribute("message", e.getMessage());
		}catch (NullPointerException e) {
			// erreurs champs vide
			request.setAttribute("message","il faut tous remplir");
		}catch (DateTimeParseException e) {
			// probleme de format de date
			request.setAttribute("message","la date entrer n'a pas le format adequat ");
		}
		
		doEtud(request, response);
		//request.getRequestDispatcher("/index.jsp").forward(request,response);
		
	}
	
	// methode pour creer un professeur
	private void doCreerProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("do creer post");
		nom =request.getParameter("nom").strip();
		prenom= request.getParameter("prenom").strip();
		tpemail=request.getParameter("email").strip();
		motdePass=request.getParameter("pass").strip();
		formNiveau=request.getParameter("niveau").strip();
		
		res = proverif.verifEmail(tpemail);
		if(res!="erreur mail") email=res;
		else System.out.println("il y a une erreur sur le mail");
		
		try {
		Professeur prof = new Professeur(nom, prenom, email, motdePass, formNiveau);
		serviceInscription.CreerProf(prof);
		
		} catch (UserException e) {
			request.setAttribute("message", e.getMessage());
			System.out.println(e.getMessage());
		}catch (NullPointerException e) {
			// erreurs champs vide
			request.setAttribute("message","il faut tous remplir");
		}catch (DateTimeParseException e) {
			// probleme de format de date
			request.setAttribute("message","la date entrer n'a pas le format adequat ");
		}
		
		doProf(request, response);
		
	}

}
