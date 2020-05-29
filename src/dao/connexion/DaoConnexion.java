package dao.connexion;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import metier.user.Etudiant;
import metier.user.ListeUsers;
import metier.user.Niveau;
import metier.user.User;

import service.exception.UserException;
import util.message.MessageAppli;
/**
 * Page Admin
 * @author Lova
 * affichage liste utilisateurs, recherche par nom/par niveau
 * modication ou supprimer un utilisateur
 *
 */

public class DaoConnexion {

	// connexion à la Base de donnée coupdemath
	
	private final String BDD 		= "coupdemath";
	private final String USER 		= "tsoa";
	private final String PASSWD		="Amical2020";
	private final String DBURL 		= "jdbc:mysql://localhost:3306/" + BDD + "?useUnicode=true" + 
	  "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	private static final String strNomDriver = "com.mysql.cj.jdbc.Driver";
	public int id;
	public String niveau;
	
	// methode pour lister les utilisateurs
	
	public ListeUsers getUsers() {
		ListeUsers listeUsers= new ListeUsers();
		
		
		try {
			//  verification de la presence du driver, si le sql jar existe
			
			Class.forName(strNomDriver); 
			
			// ouvre la connexion
			
			Connection 	conn = DriverManager.getConnection (DBURL, USER, PASSWD);
			Statement stmt1 = conn.createStatement();
			
			//recherche  dans la base de donnée les utilisateurs et mettre dans rs en utilisant une RequeteSql select
			
			ResultSet rs = stmt1.executeQuery ("select id_user,nom_user, pre_user, mail_user,mdp_user,id_niv ,dat_naiss_user from utilisateur");
			
			while( rs.next()) {
				Integer id = rs.getInt ("id_user");
				String nom = rs.getString("nom_user");
				String prenom = rs.getString("pre_user");
				String mail = rs.getString("mail_user");
				String mdp = rs.getString("mdp_user");
				
				// traitement de niveau changer id_niv en lib_niveau dans Niveau
				
				Integer idniv = rs.getInt ("id_niv");
				for (Niveau niv : Niveau.values()) {
					if(idniv ==niv.getNumeroNiveau())  niveau=niv.getLibNiveau();
					
				}
				
				
				// conversion de date.sql en Localdate
				
				LocalDate dat_naiss_user = null;
				if (rs.getDate("dat_naiss_user") != null) dat_naiss_user = rs.getDate("dat_naiss_user").toLocalDate();
				
				// instancier Etudiant et mettre dans listeUsers
				
			   Etudiant users1 =new Etudiant(id,nom,prenom,mail,mdp,niveau,dat_naiss_user);
			   
			   // ajouter dans les utilisateurs dans le tableau listeUsers
			   listeUsers.add(users1);
			   
			
				}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listeUsers;
	}

	
		// juste pour tester le Junit sans DAO
	
	public void modif1 (Etudiant etudiant) throws UserException{
		throw new UserException("OK");
	}
	
	// methode pour modifier un ou des propriétés d'un utilisateur
	
	public void modification (Etudiant etudiant) throws UserException{
		int idNiveau=0;
		//etudiant =null;
		// acces BDD
		
		
		
	
		
		
		try {
					
			for (Niveau niv : Niveau.values()) {
				if(etudiant.getNiveau().equals(niv.getLibNiveau())) { idNiveau=niv.getNumeroNiveau();}
				
			}
			
			//  verification de la presence du driver
					Class.forName(strNomDriver);
					
					//  on ouvre la connexion
					Connection conn        = DriverManager.getConnection(DBURL, USER, PASSWD);
				
								
					
					// update dans la base en utilisant une RequeteSql update
					PreparedStatement stmt = conn.prepareStatement(RequeteSql.MODIF_USER );
					
				
					stmt.setString(1, etudiant.getEmail());
					stmt.setString(2,etudiant.getMotPass());
					stmt.setInt(3,idNiveau);
					stmt.setInt(4,etudiant.getIdUser());
					
					
					// execution de la requete
					int nbRow=stmt.executeUpdate();
					
					
					// gestion d'erreur cas nominal
					// une modification est effectuée et affichage du message Modif_ok
					if ( nbRow==1 ) throw new UserException(String.format(MessageAppli.MODIF_OK));
					 
					// Id n'existe pas ca genere pas d'erreur dans la base
					if ( nbRow==0 ) throw new UserException(String.format(MessageAppli.MODIF_KO)); 
					
				} catch(ClassNotFoundException e)  {
					throw new UserException(MessageAppli.ERREUR_BDD);
					
				// s'il ya d'autre erreur au niveau sql
				} catch (SQLException e) {
					 throw new UserException(MessageAppli.ERREUR_BDD);
					 
				// si le parametre est null, etudiant =null
				} catch (NullPointerException e) {
					 throw new UserException(MessageAppli.MODIF_NULL);
				}
					 
			   // l'identifiant introduit n'est pas un int
				catch (NumberFormatException e) {
					 throw new UserException(MessageAppli.MODIF_NULL);
				}
	}
	
	
	
	// methode pour verifier l'email et le mot de passe d'un utilisateur lors de sa connexion
	
	public boolean isConnexionOK(String email, String pass) {
		System.out.println("dao ici" + email +" pass= "+ pass);
		boolean ok = false;
		
		try {
			Class.forName(strNomDriver); 
			Connection 	conn = DriverManager.getConnection (DBURL, USER, PASSWD);
			
			// verication à la base de mots de pass et email avec la requete is_conn_ok
			
			PreparedStatement stmt = conn.prepareStatement(RequeteSql.IS_CONN_OK);
			
			stmt.setString(1, email);	
			stmt.setString(2,pass);
			
			// mettre dans rs le resultat de la requete 1 pour trouver 0 sinon
			ResultSet rs = stmt.executeQuery();
		  
			while(rs.next()) {
				ok=rs.getBoolean(1);
						}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return ok;
	}

	
	// methode pour supprimer un utilisateur connaissant son identifiant
	
	public void doSuppression(int idUser) throws UserException {
	System.out.println("vous etes ici service DAO " + idUser);
		
		try {
			Class.forName(strNomDriver);
			Connection conn = DriverManager.getConnection(DBURL, USER, PASSWD);
			
			//application de la requete suppr_user
			
			PreparedStatement stmt = conn.prepareStatement(RequeteSql.SUPPR_USER);
			stmt.setInt(1, idUser);
			
			// execution de la requete
			
			stmt.executeUpdate();
			

		} catch (ClassNotFoundException e) {
			throw new UserException(MessageAppli.ERREUR_BDD);
		} catch (SQLException e) {
			// TODO..
		;
			
		}
		
		
	}

	
	// methode pour afficher la liste des utilisateurs suivant un nom donné
	
	public ListeUsers getUser(String nom) {
		ListeUsers listeUsers= new ListeUsers();
	
		try {
			Class.forName(strNomDriver); // verifie si le sql jar existe
			Connection 	conn = DriverManager.getConnection (DBURL, USER, PASSWD);
			
			
			// application de la requete is_nom_ok
			
			PreparedStatement stmt = conn.prepareStatement(RequeteSql.IS_NOM_OK);
			stmt.setString(1, nom);	
			
			// recuperation dans rs la liste suivant la requete
			ResultSet rs = stmt.executeQuery();
		  
			while( rs.next()) {
				Integer id = rs.getInt ("id_user");
				String nom1 = rs.getString("nom_user");
				String prenom = rs.getString("pre_user");
				String mail = rs.getString("mail_user");
				String mdp = rs.getString("mdp_user");
				
				// traitement de niveau en recuperant lib_niveau
				
				Integer idniv = rs.getInt ("id_niv");
				for (Niveau niv : Niveau.values()) {
					if(idniv ==niv.getNumeroNiveau())  niveau=niv.getLibNiveau();
					
				}
				
				
				// conversion de date.sql en Localdate
				
				LocalDate dat_naiss_user = null;
				if (rs.getDate("dat_naiss_user") != null) dat_naiss_user = rs.getDate("dat_naiss_user").toLocalDate();
				
				// instancier Etudiant et mettre dans listeUsers
				
				Etudiant users1 =new Etudiant(id,nom1,prenom,mail,mdp,niveau,dat_naiss_user);
				
			   listeUsers.add(users1);
			  
				}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeUsers;

		
		
	}

	
	// methode pour afficher la liste des utilisateurs suivant un niveau donné
	
	public ListeUsers getNivUser(String choixniv) {
		ListeUsers listeUsers= new ListeUsers();
		
		
		for (Niveau niv : Niveau.values()) {
			if(choixniv.equals(niv.getLibNiveau())) { id=niv.getNumeroNiveau();}
			
		}
		//System.out.println(" id =" + id);
	
		try {
			Class.forName(strNomDriver); // verifie si le sql jar existe
			Connection 	conn = DriverManager.getConnection (DBURL, USER, PASSWD);
			
			// preparer la requete is_niv_ok
			
			PreparedStatement stmt = conn.prepareStatement(RequeteSql.IS_NIV_OK);
			stmt.setInt(1,id);	
			
			// mettre le resultat de la requete dans rs, les utilisateurs de meme niveau
			ResultSet rs = stmt.executeQuery();// 
		  
			while( rs.next()) {
				Integer id = rs.getInt ("id_user");
				String nom1 = rs.getString("nom_user");
				String prenom = rs.getString("pre_user");
				String mail = rs.getString("mail_user");
				String mdp = rs.getString("mdp_user");
				
				// traitement de niveau en recuperant lib_niveau
				
				Integer idniv = rs.getInt ("id_niv");
				for (Niveau niv : Niveau.values()) {
					if(idniv ==niv.getNumeroNiveau())  niveau=niv.getLibNiveau();
					
				}
				
				
				// conversion de date.sql en Localdate
				LocalDate dat_naiss_user = null;
				if (rs.getDate("dat_naiss_user") != null) dat_naiss_user = rs.getDate("dat_naiss_user").toLocalDate();
				
				// instancier Etudiant et mettre dans listeUsers
				Etudiant users1 =new Etudiant(id,nom1,prenom,mail,mdp,niveau,dat_naiss_user);
				
			   listeUsers.add(users1);
			  
				}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listeUsers);
		return listeUsers;

	}

	
	// methode pour afficher les propriétés d'un utilisateur dans modifUser.jsp
	
	public User getModifier(int idUser) {
		Etudiant user1 = null;
		try {
			Class.forName(strNomDriver); // verifie si le sql jar existe
			Connection 	conn = DriverManager.getConnection (DBURL, USER, PASSWD);
			
			//preparer la requete is_iduser_ok
			PreparedStatement stmt = conn.prepareStatement(RequeteSql.IS_IdUser_OK);
			stmt.setInt(1,idUser);	
			
			// mettre dans rs le resultat de la requete, recuperer un utilisateur 
			ResultSet rs = stmt.executeQuery();
		  
				while( rs.next()) {
					Integer idU   = rs.getInt ("id_user");
					String nom1   = rs.getString("nom_user");
					String mail   = rs.getString("mail_user");
					String mdp    = rs.getString("mdp_user");
			
				
						// traitement de niveau en recuperant lib_niveau
				
					Integer idniv = rs.getInt ("id_niv");
					for (Niveau niv : Niveau.values()) {
						if(idniv ==niv.getNumeroNiveau())  niveau=niv.getLibNiveau();
					
					}
				

					// instancier l'utilisateur recuperer
					
				 user1 =new Etudiant(idU, nom1, mail,mdp, niveau);
				
			
					
				 }
			
			
		 } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
	
	
		
		return user1;
	}
	public  Object getObjetNull() {
		return null;
		
	}
	
}

	

