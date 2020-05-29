package dao.connexion;

public class RequeteSql {

	protected final static String IS_CONN_OK	= "select isConnexionOK(?,?)";
	protected final static String SUPPR_USER	=  "DELETE FROM utilisateur WHERE id_user =" +"?" ;
	protected final static String IS_IdUser_OK	= "select id_user,nom_user, mail_user,mdp_user,id_niv from utilisateur where id_user=" +"?";
	protected final static String IS_NOM_OK		= "select id_user,nom_user, pre_user, mail_user,mdp_user,id_niv,dat_naiss_user "
													+ "from utilisateur where nom_user=" +"?";
	protected final static String MODIF_USER	= "update utilisateur set mail_user =" +"?,mdp_user =" +"?,id_niv=" +"? where id_user=" +"?";

	protected final static String IS_NIV_OK		= "select id_user,nom_user, pre_user, mail_user,mdp_user,id_niv,dat_naiss_user "
													+ "from utilisateur where id_niv=" +"?";
}
