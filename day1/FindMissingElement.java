package week3.day1;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,6,7,8};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		for(int i=a[0];i<a.length;i++) {
			if(!(a[i-1]== i)) {
				System.out.println(i);
				break;
		
		}

	}

}
}
