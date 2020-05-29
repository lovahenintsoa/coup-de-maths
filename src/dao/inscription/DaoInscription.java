package dao.inscription;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import metier.user.Etudiant;
import metier.user.Niveau;
import metier.user.Professeur;
import service.exception.UserException;
import util.message.MessageAppli;
/**
 * Page inscriptionProf et inscriptionEtudiant
 * @author Lova
 * Creation et insertion dans la base d'un utilisateur Professeur ou Etudiant
 * 
 *
 */

	public class DaoInscription {
		// connexion à la Base de donnée coupdemath
		private final String BDD 		= "coupdemath";
		private final String USER 		= "tsoa";
		private final String PASSWD		="Amical2020";
//	private final String DBURL 		= "jdbc:mysql://localhost:3306/" + BDD + "?useUnicode=true" + 
//	  "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		final String DBURL 			="jdbc:mysql://localhost:3306/" + BDD + "?"
			+ "user=" + USER 
			+ "&password=" + PASSWD 
	  		+ "&serverTimezone=UTC";
	
	private static final String strNomDriver = "com.mysql.cj.jdbc.Driver";
	public int id;
	LocalDate  localdate; 
	
	// methode pour creer un professeur
	public void creer(Professeur prof) throws UserException  {
		
		
		//  verification de la presence du driver
		System.out.println("ici get dao");		
		
		// recuperer l'id_niv à partir de lib_niv dans le formulaire
		
		for (Niveau niv : Niveau.values()) {
			if(prof.getNiveau().equals(niv.getLibNiveau())) { id=niv.getNumeroNiveau();}
			
		}
		try {
			Class.forName(strNomDriver);
			
			//  on ouvre la connexion
			
			Connection conn       = DriverManager.getConnection(DBURL);
			
					
			// appel de la procedure procInsertUtilisateur avec la requete insert
			String sql = "{call procInsertUtilisateur(?,?,?,?,?,?,?)}";
			CallableStatement stmt = conn.prepareCall(sql);
									
		
			stmt.setString(1, prof.getNom());
			stmt.setString(2, prof.getPrenom());
			stmt.setString(3, prof.getEmail());
			stmt.setString(4, prof.getMotPass());
			stmt.setString(5,null);
			stmt.setInt(6, id);
			stmt.setInt(7, 2); // id_tache professeur=2
			
			// execution de la requete
			int nb =stmt.executeUpdate();
			
			// une insertion dans la base  est effectuée et affichage du message creer_prof_ok
			if (nb==1) throw new UserException(String.format(MessageAppli.CREER_PROF_OK, prof.getNom()));
			//System.out.println(nb + " insert effectue.");
			 
		}catch (SQLException e) {
		
			// mail déjà utiliser par un autre utilisateur
			if      (e.getMessage().contains(ContrainteMySql.UN_MAIL_UTILISE)) 		throw new UserException(MessageAppli.ERREUR_MAIL);
			
			// d'autre erreure possible sql 
			else throw new UserException(MessageAppli.ERREUR_BDD);
		}
		catch (ClassNotFoundException e) {
			
			throw new UserException(MessageAppli.ERREUR_BDD);
		}
	}
	
	
	
	// methode pour creer un Etudiant
	public void creerE(Etudiant etudiant) throws UserException  {
		
		System.out.println("ici get dao");	
		
		for (Niveau niv : Niveau.values()) {
			if(etudiant.getNiveau().equals(niv.getLibNiveau())) { id=niv.getNumeroNiveau();}
			
		}
		try {
		//  verification de la presence du driver
			Class.forName(strNomDriver);
			
			//  on ouvre la connexion
			
			Connection conn       = DriverManager.getConnection(DBURL);
			
			
			
//			PreparedStatement stmt = conn.prepareStatement(RequeteSql.INSERT_PROF);
//			Statement stmt1 = conn.createStatement();
//			ResultSet rs = stmt1.executeQuery (RequeteSql.COMPTE);
			
			// appel de la procedure procInsertUtilisateur avec la requete insert
			
			String sql = "{call procInsertUtilisateur(?,?,?,?,?,?,?)}";
			CallableStatement stmt = conn.prepareCall(sql);
			localdate=etudiant.getDateNaissance();
			
			
					
				
			stmt.setString(1, etudiant.getNom());
			stmt.setString(2, etudiant.getPrenom());
			stmt.setString(3, etudiant.getEmail());
			stmt.setString(4, etudiant.getMotPass());
			stmt.setDate(5,(localdate == null)? null : java.sql.Date.valueOf(localdate),java.util.Calendar.getInstance());
			stmt.setInt(6, id);
			stmt.setInt(7, 1);// 1 car la valeur de id_tache etudiant = 1
			
			// execution de la requete
			int nb =stmt.executeUpdate();
			
			// une insertion dans la base  est effectuée et affichage du message creer_etud_ok
			if (nb==1) throw new UserException(String.format(MessageAppli.CREER_ETUD_OK,etudiant.getNom()));
			//System.out.println(nb + " insert effectue.");
			 
		}catch (SQLException e) {
		
			if      (e.getMessage().contains(ContrainteMySql.UN_MAIL_UTILISE)) 		throw new UserException(MessageAppli.ERREUR_MAIL);
			// d'autre erreure possible sql 
			else throw new UserException(MessageAppli.ERREUR_BDD);
			
		}catch (ClassNotFoundException e) {
			
			throw new UserException(MessageAppli.ERREUR_BDD);
		}
	}
}
