package exhaustive_search;

import java.util.*;

public class Baekjoon2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 3 ~ 100
		int m = sc.nextInt(); // 10 ~ 300,000
		int[] cards = new int[n];
		int max = 0;
		
		for(int i=0; i<n; i++) {
			cards[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				for(int k=j+1; k<n; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if(sum <= m && sum > max) {
						max = sum;
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
}
/*
	최대 O(n^3)
	- N이 최대 100이므로 중첩 for문으로 충분
	
	1, 3, 6, 7, 5
	
	1, 3, 6
	1, 3, 7
	1, 3, 5
	1, 6, 7
	1, 6, 5
	1, 7, 5
	3, 6, 7
	3, 6, 5
	3, 7, 5
	6, 7, 5
*/