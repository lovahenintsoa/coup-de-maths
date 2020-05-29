package junitTest;







import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import dao.connexion.DaoConnexion;

import metier.user.Etudiant;

import service.exception.UserException;

class TestDaoConnexion {

	private static DaoConnexion daoConnexion;
	private static Etudiant etudiant;
	private static Etudiant etudiant1;
	private static Etudiant etudiant2;
	;
	
	@BeforeAll
	static void debutClasse() throws Exception {
	 	daoConnexion = new DaoConnexion();
		etudiant =new Etudiant(3, "Aziz", "Aziz@gmail.com","dappixxxx", "quatrieme");
	}
	
	@BeforeEach
	void debut() throws Exception {
		// idem setUp
		
	etudiant1 =new Etudiant(1, "Lova", "lova@gmail.com","dapppw", "sixieme");	
	etudiant2 =new Etudiant(1, "Lova", "lova@gmail.com","dapppw", "sixieme");
	//etudiant3=null;
	
		System.out.println("Execution de debut()");		
	}

	@AfterEach
	void fin() throws Exception {
	
	}

	@AfterAll
	static void finClasse() throws Exception {
		
	}
	
	
		
	
	@DisplayName("cas nominal pour test sans DAO")
	@Test
	void testModifParDefaut() {
		 UserException userexception= assertThrows (UserException.class,() -> {
				daoConnexion.modif1(etudiant1);
			});
			assertTrue(userexception.getMessage().contains("OK"));
	}
	
	
	@DisplayName("cas nominal pour test avec DAO")
	@Test
	void testModification() {
		 UserException userexception= assertThrows (UserException.class,() -> {
				daoConnexion.modification(etudiant);
			});
			assertTrue(userexception.getMessage().contains("Les informations ont été bien modifiées"));
		
		
	}
	
	
	@DisplayName("cas ou le parametre Etudiant de la methode modification est null ")
	@Test // il faut pas oublier sinon pas de test dans junit
	void testEntreNull()  {
		 Etudiant etudiant3 = null;
		 UserException userexception= assertThrows (UserException.class,() -> {
				daoConnexion.modification(etudiant3 );
			});
			assertTrue(userexception.getMessage().contains("L'entrée Etudiant est null"));
	}
	
	@DisplayName("TestObjectEtudiant")
	@Test
	public final void TestObjectEtudiant() {
		
		
		assertEquals(etudiant1, etudiant2,"les instances sont egales");
	}
	


}
