package week3.day1;

import java.util.Arrays;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "changeme";
		
		char[] str1 =test.toCharArray();
		System.out.println(Arrays.toString(str1));
		for(int i=0;i<str1.length;i++) {
			if((i % 2 == 0)) {
				System.out.println(str1[i]);
			}
			else  if (!(i % 2 == 0))
			{
				System.out.println(Character.toUpperCase(str1[i]));
				
				
				
			}
			
			}
		
		

	}

	
}



