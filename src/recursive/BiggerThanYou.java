package recursive;

import java.util.*;

class BiggerThanYou {
	static long answer = Long.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		long k; // 10^9 

		for(int i=0; i<n; i++){
			nums[i] = sc.nextInt(); // 오름차순 입력, 동일한 값 x
		}

		k = sc.nextLong();
		
		solve(0l, nums, n, k);

		System.out.println(answer);
	}

	public static void solve(long current, int[] nums, int n, long k){
		if(current>k){
			answer = Math.min(answer, current);
				return;
		}
		
		for(int i=0; i<n; i++){
			long next = 10*current + nums[i];
			if(next==0) continue;
			solve(next, nums, n, k);
		}
	}
}
/*
	자릿수를 늘려가며 중복 순열 생성하는 아이디어
	-> 직전 상태 기억
	-> 재귀 분할 정복
*/