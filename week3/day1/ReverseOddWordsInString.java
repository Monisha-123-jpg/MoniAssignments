package week3.day1;

public class ReverseOddWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "I am a software tester";
	
		String [] splitTest= test.split(" ");
		for(int i=0;i<splitTest.length;i++) {
			if(i%2==0) {
				System.out.print(splitTest[i]+" ");
				
			}
			
			else {
				char[] charArray = splitTest[i].toCharArray();
                for (int j = charArray.length - 1; j >= 0; j--) {
                    System.out.print(charArray[j]);
                }
                System.out.print(" ");
			
				
				
			}
		}

	}

}
