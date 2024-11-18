package utilies;

public class CommonUtilies {

	public static String generateBrandNewEmail(){
		
		String randomEmail = "pranav.gupta" + System.currentTimeMillis() + "@gmail.com";

		return randomEmail;
}
}
