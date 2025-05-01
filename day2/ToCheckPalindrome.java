package week2.day2;

public class ToCheckPalindrome {

	public static void main(String[] args) {
		int input=1231;
	    int orgNo = input;
	   
		int output=0;
		for (int i = input; i > 0; i = i / 10)
		{
		 	 output =output*10 +i%10;
		}
	  System.out.println(output);
	  System.out.println(orgNo);
		if(orgNo == output) {
			System.out.println("No is palindrome");
			
		}
		else {
			System.out.println("No is not a  palindrome");
		}
}
}
