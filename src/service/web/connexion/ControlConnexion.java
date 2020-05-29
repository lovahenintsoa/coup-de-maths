package service.web.connexion;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.user.Etudiant;
import metier.user.ListeUsers;
import metier.user.Professeur;

import service.business.connexion.ServiceConnexion;

import service.exception.UserException;
import util.message.MessageAppli;

/**
 * Servlet : UN controleur qui controle l'url /connexion/*
 * affichage liste utilisateurs, recherche par nom/par niveau
 * modication ou supprimer un utilisateur
 */
@WebServlet( urlPatterns = {"/connexion/*"} )
	public class ControlConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String tpidUser;
	int idUser;
	String email;
	String tpemail;
	String niveau;
	
	String pass;
	String res;
	String nom;
	Professeur proverif =new Professeur();
	
	private ServiceConnexion serviceConnexion;

	
	// initialisation de la classe ServiceConnexion
	@Override
	public void init() throws ServletException {
		serviceConnexion = new ServiceConnexion();
	}
       
// traite l'url/connexion/pass
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String chemin  		= request.getPathInfo();		
		
		if      (chemin.equals("/pass")) 			doConnexion(request, response);
					
		
		else 										doAutres(request, response);
	}

	// redirige vers la page 404.jsp
	private void doAutres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pageerreur").forward(request,response);	
		
	}

	// redirige vers la page connexion.jsp
	private void doConnexion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/connexion").forward(request,response);
		
	}

	// methode qui active toutes les actions et methode "post" des pages listeUtilisateur.jsp et modifUser.jsp
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chemin  		= request.getPathInfo();	
		
		System.out.println(chemin);
			if (chemin.equals("/recupMotdePass")) 			 doListes(request, response);
			else if(chemin.equals("/suppressionUser"))  	doSuppression(request,response);
			else if(chemin.equals("/modifierUser"))  		doModifier(request,response);
			else if(chemin.equals("/modifEnreg"))  		doModifEnreg(request,response);
			else if(chemin.equals("/retour"))  				doRetour(request,response);
			else if(chemin.equals("/retourListe"))  		doRetourListe(request,response);
			else if(chemin.equals("/afficheNivUser")) 	 	doAfficheNivUser(request,response);
			else if(chemin.equals("/afficheNomUser"))  		doAfficheNomUser(request,response);
			else 										 	doAutres(request, response);
	
		}

	// methode pour modifier un ou des propriétés d'un utilisateur
	private void doModifEnreg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("eto ndary tsika");
		tpidUser= request.getParameter("id").strip();
		nom =request.getParameter("nom").strip();
		tpemail=request.getParameter("email").strip();
		pass=request.getParameter("passe").strip();
		niveau=request.getParameter("niveau").strip();
		
		System.out.println("eto ndary tsika" + nom+tpidUser);
		idUser=Integer.parseInt(tpidUser);
		// verification du mail par la fonction verifEmail
				res = proverif.verifEmail(tpemail);
				if(res!="erreur mail") email=res;
		try {
			Etudiant etudiant = new Etudiant(idUser, nom, email, pass, niveau);
			
			serviceConnexion.modification(etudiant);
		} catch (UserException e) {
			request.setAttribute("message", e.getMessage());
		} 
		doRetourListe(request, response);
	//	request.getRequestDispatcher("/WEB-INF/vue/modifUser.jsp").forward(request,response);
	}


	// methode pour afficher les propriétés d'un utilisateur dans modifUser.jsp
	private void doModifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUser;
	
	
//		// TODO if choix user vide msg clicker id java.lang.NumberFormatException: null
			
		try
		{
			String choixUser = request.getParameter("choix_User");
	
			idUser = Integer.parseInt(choixUser);
			
			Etudiant user1 =(Etudiant) serviceConnexion.getModifier(idUser);
			request.setAttribute("user1",user1 );
	
			// si l'utilisateur a oublier de clicker sur l'identifiant
		}catch (NumberFormatException e) {
		
			request.setAttribute("message", "cliquer sur choix Id");
			doRetourListe(request, response);
			
		}catch (NullPointerException e) {
			// erreurs champs vide
			request.setAttribute("message","il faut tous remplir");
		}	
		
		
			
				
			request.getRequestDispatcher("/modification").forward(request,response);
//		ListeUsers listeusers = serviceConnexion.getUsers();
//		request.setAttribute("users",listeusers );

		
	}

	// methode retourne la liste  des utilisateurs
	private void doRetourListe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListeUsers listeusers = serviceConnexion.getUsers();
		request.setAttribute("users",listeusers );
		request.getRequestDispatcher("/liste").forward(request,response);
		
	}


	private void doRetour(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/accueil").forward(request,response);
		
	}

	// methode pour afficher la liste des utilisateurs suivant un niveau donné
	private void doAfficheNivUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choixniv = request.getParameter("niveau");
		System.out.println("le niveau ve "+choixniv);
		ListeUsers listeusers = serviceConnexion.getNivUser( choixniv);
		
		request.setAttribute("users",listeusers );
		request.getRequestDispatcher("/liste").forward(request,response);	
		
		
	}

	// methode pour afficher la liste des utilisateurs suivant un nom donné
	private void doAfficheNomUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nom = request.getParameter("nom");
		ListeUsers listeusers = serviceConnexion.getUser(nom);
		//User user = serviceConnexion.getUser( nom);
		//System.out.println("anarana =" + user);
		

		
		//request.setAttribute("user",user );
		//ListeUsers listeusers = serviceConnexion.getUsers();
		request.setAttribute("users",listeusers );
		request.getRequestDispatcher("/liste").forward(request,response);	
		
		
	}

	// methode pour supprimer un utilisateur connaissant son identifiant
	private void doSuppression(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		try {
		String choixUser = request.getParameter("choix_User");
		int idUser = Integer.parseInt(choixUser);
		serviceConnexion.doSuppression(idUser);
		
		}
		catch (UserException e) {
			request.setAttribute("message", e.getMessage());
			System.out.println("exception" + e.getMessage());
		}
		// si l'utilisateur a oublier de cliquer sur l'Id
		catch (NumberFormatException e) {
			
			request.setAttribute("message", "cliquer sur choix Id");
		//	doRetourListe(request, response);
			
		}	
	//	System.out.println("vous etes ici suppr" + idTheme);
		
		ListeUsers listeusers = serviceConnexion.getUsers();
		request.setAttribute("users",listeusers );
		request.getRequestDispatcher("/liste").forward(request,response);	
		
	}

	// methode pour verifier l'email et le mot de passe d'un utilisateur lors de sa connexion
	// et retourne aussi la listes des utilisateurs
	private  void doListes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ListeUsers listeusers = serviceConnexion.getUsers();
		String message = null;
		System.out.println(listeusers);
		try
		{
		tpemail=request.getParameter("email").strip();
		pass=request.getParameter("pass").strip();
		
	
		
				}
		catch (NullPointerException e) {
			message =MessageAppli.RECUP_PSEUDO_PW_KO;
		}
		
		// appel de la fonction verifmailde User
		res = proverif.verifEmail(tpemail);
		if(res!="erreur mail") email=res;
		else System.out.println("il y a une erreur sur le mail");
		
		
			boolean ok = serviceConnexion.isConnexionOK(email,pass);
			
			System.out.println("depart mail =" + email +"arrive ok ="+ ok);
			
			// Afficher la liste si le email est admin@gmail.com
			// remarque (if == ne marche pas cause????)
			
			if (("admin@gmail.com".equals(email)) && ("admin".equals(pass))) {
				request.setAttribute("users",listeusers );
				request.getRequestDispatcher("/liste").forward(request,response);		
						}
						else {
							
							
							if(ok) {
							request.getRequestDispatcher("/pageazizarash").forward(request,response);
									}
							else {
								 message =MessageAppli.RECUP_PSEUDO_PW_KO;
								 // mot de pass ou mail qui ne sont pas dans la base
							}
							}
		
		
		
		request.setAttribute("message",message );	
				doConnexion(request, response);
}
		
		
	
}


