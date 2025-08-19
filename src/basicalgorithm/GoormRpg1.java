package basicalgorithm;

import java.util.*;

public class GoormRpg1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int limit = 100001;
		boolean[] multiples = new boolean[limit+1];
		List<Integer> primes = new ArrayList<>();
		
		for(int i=2; i<=limit; i++){
			if(!multiples[i]){
				primes.add(i);
				for(int j=i; j<=limit; j+=i){
					multiples[j] = true;
				}
			}
		}

		for(int i=0; i<n; i++){
			int tmp = sc.nextInt();
			if(primes.contains(tmp)){
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
/*
	내 갑옷 고유값 : a
	상대 무기 고유값 : w

	if !(a > w && a % w == 0)
	if a <= w || a % w != 0 (드모르간 법칙에 의해)

	w = 2일 때
	 - a는 2 또는 2의 배수가 아니면 됨 => 2를 제외한 2의 배수가 아닌 정수
	w = 3일 때
	 - a는 2, 3 또는 3의 배수가 아니면 됨 => 2, 3을 제외한 3의 배수가 아닌 정수
	w = 4일 때
	 - a는 2, 3, 4 또는 4의 배수가 아니면 됨 => 2, 3, 4(얘는 2의 배수임)를 제외한 4의 배수가 아닌 정수
	w = 5일 때
	 - a는 2, 3, 4, 5 또는 5의 배수가 아니면 됨 => 2, 3, 4, 5를 제외한 5의 배수가 아닌 정수
	w = 6일 때
	 - a는 2, 3, 4, 5, 6 또는 6의 배수가 아니면 됨 => 2, 3, 4, 5, 6(얘는 2, 3의 배수임)을 제외한 6의 배수가 아닌 정수
  w = n일 때
	 - a는 2~n 또는 n의 배수가 아니면 됨 => 2, 3, 4, ..., n을 제외한 n의 배수가 아닌 정수
  위의 모든 조건을 만족하는 2 이상의 정수 : 소수. 이걸 직관적으로 떠올려야 한다니
*/