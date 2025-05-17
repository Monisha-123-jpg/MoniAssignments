package week3.day1;

import java.util.Arrays;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a[]={3,2,11,4,6,7}; 
         int b[]={1,2,8,4,9,7}; 
       int len_a=a.length;
       int len_b=b.length;
       for(int i=0;i<len_a;i++) {
    	   for(int j=0;j<len_b;j++) {
    		   
    		   if(a[i]==b[j]) {
    			   System.out.println(a[i]);
    		       break;
    		   }
    		   
    	   }
       }
      
	}

}
