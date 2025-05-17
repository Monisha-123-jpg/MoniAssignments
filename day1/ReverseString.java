package week3.day1;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="Monisha";
		char[]  s1=s.toCharArray();
		
		System.out.println(s1);
		System.out.println(Arrays.toString(s1));
		int charLenghth=s1.length;
		for(int i=charLenghth-1;i>=0;i--) {
			System.out.print(s1[i]);
		}
      
	}

}
