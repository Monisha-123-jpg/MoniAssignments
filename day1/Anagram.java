package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="stop";
		String s2="tops";
		
		
		if(s1.length()==s2.length()) {
			
			char[] str1=  s1.toCharArray();
			 char[] str2 =s2.toCharArray();
			 Arrays.sort(str1);
			 Arrays.sort(str2);
			 System.out.println(Arrays.toString(str1));
			 System.out.println(Arrays.toString(str2));
			 if(Arrays.equals(str1, str2)) {
				 System.out.println("given 2 strings are anagram");
				 
			 }
			 else
			 {
				 System.out.println("2 strings are not anagram");
			 }
		}
		else {
			System.out.println("length mismatching,so given 2 strings are not anagram");
		}
		

	}

}
