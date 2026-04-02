package exhaustive_search;

import java.util.*;

public class Baekjoon1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for(Integer i=0; i<6660000; i++) {
			if(i.toString().contains("666")) {
				count++;
			}
			if(count == n) {
				System.out.println(i);
				break;
			}
		}
	}
}

/*
	666
	1666
	2666
	3666
	4666
	5666
	6661
	6662
	6663
	6664
	6665
	6666
	6667
	6668
	6669
	7666
	
*/