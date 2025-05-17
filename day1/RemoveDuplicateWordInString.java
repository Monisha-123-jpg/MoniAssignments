package week3.day1;

import java.util.Arrays;

public class RemoveDuplicateWordInString {

	public static void main(String[] args) {
		String text = "We learn Java basics as part of java sessions in java week1";
		String[] splitStr=text.split(" ");
		System.out.println(Arrays.toString(splitStr));
		
		int count = 0;
		
		for(int i=0;i< splitStr.length;i++) {
			for(int j=i+1;j<splitStr.length;j++) {
				if(splitStr[i].equalsIgnoreCase(splitStr[j]) ){
					splitStr[j]=" ";
					count++;
					
					
				}
				}
		}
				if(count>0) {
					
					for( int i=0;i < splitStr.length;i ++) {
						System.out.print(splitStr[i]+" ");
				}
				
				
						
					}
					
				}
				
			}
		

		// TODO Auto-generated method stub

	


	