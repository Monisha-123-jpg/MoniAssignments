package week2.day2;

public class IsPrime {

	public static void main(String[] args) {
		int num=15;
		int count=0;
		if(num>1) {
		for(int i =2;i<=num-1;i++) {
		  if(num%i==0) {
		      count++;
			  break;
		  }
		
		}
		if(count==0)
		{
			System.out.println("it is  prime");
		}
		else
		  {
			  System.out.println("it is not a prime");
		  }
		

	}
	}
}


