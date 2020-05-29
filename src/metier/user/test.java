package metier.user;
// programme test 
public class test {

	public static void main(String[] args) {

		String mail1;
		String res;
		mail1="gh.hhkl@mm.mmml";
		User use =new User() {};
		
		res= use.verifEmail(mail1);
		System.out.println(res);
	}

}
