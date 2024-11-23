  package Experiment;

public class GenerateEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str ="I like to learn the testing from qafox.com. hello";
		String[] s=str.split(".com.");
		//System.out.println(s[0]);
		String[] t =s[0].split("from ");
		System.out.println(t[1]);
		
	

}
}
