package dp;

import java.util.*;

public class Baekjoon1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int arr[] = new int[1000001];
		arr[1] = 0;
		
		for(int i=2; i<=x; i++) {
			int min = arr[i-1];
			if(i%2==0 && min > arr[i/2]) {
				min = arr[i/2];
			}
			if(i%3==0 && min > arr[i/3]) {
				min = arr[i/3];
			}
			arr[i] = min + 1;
		}
		
		System.out.println(arr[x]);
	}
}
/*
 1 (0) -> 1 (0)
 2 (1) -> 2-1 (1)
 3 (1) -> 3/3 (1)
 4 (2) -> 4-1 (1) => 3 (1)
 5 (3) -> 5-1 (1) => 4 (2)
 6 (2) -> 6/2 (1) => 3 (1)
 7 (3) -> 7-1 (1) => 6 (2)
 
 arr[1] = 0
 arr[2] = 1
 arr[3] = 1
 arr[i] = min(min(arr[i-1], arr[i/2]), arr[i/3]) + 1
 
 */
