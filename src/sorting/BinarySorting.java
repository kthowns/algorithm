package sorting;

import java.util.*;

public class BinarySorting {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ~ 500,000
		int k = sc.nextInt();
		Integer[][] nums = new Integer[n][2]; // ~ 2^20, 대략 1,000,000
		// [n][0] : 숫자, [n][0] : 2진수 1 개수
		
		for(int i=0; i<n; i++){ // O(2n)
			int tmp = sc.nextInt();
			nums[i][0] = tmp;
			nums[i][1] = countOne(tmp);
		}

		Arrays.sort(nums, (a, b) -> { // O(nlogn)
			if (a[1] == b[1]){
				return Integer.compare(b[0], a[0]);
			} else {
				return Integer.compare(b[1], a[1]);
			}
		});

		System.out.println(nums[k-1][0]);
	}

	public static int countOne(int num){
		String binary = Integer.toBinaryString(num); // O(1)
		int cnt = 0;
		
		for(int i=0; i<binary.length(); i++){ // O(L), 최대 20 즉 1
			if(binary.charAt(i) == '1'){
				cnt++;
			}
		}

		return cnt;
	}
}

/*
	- 10진수 -> 2진수 변환
	- 1의 개수를 기준으로 내림차순 정렬
	 -> 1의 개수가 같을 경우 10진수 기준 정렬
*/