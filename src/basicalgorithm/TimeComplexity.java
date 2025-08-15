package basicalgorithm;

import java.util.*;
import java.math.*;

public class TimeComplexity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //int : 대략 10^8까지, long : 대략 10^18까지
		long fiveCount = 0;
		
		for(long p=5; p<=n; p*=5) {
			fiveCount += n / p;
		}
		
		System.out.println(fiveCount);
	}
}
/*
	- 순열 패턴으로 푸는게 아님
	- 맨 뒤의 0은 소인수 분해 시 10이 몇번 나오느냐가 관건이다
	- 10은 2*5이다
	- N!의 소인수 중 5가 몇개인지 세면 된다?
	- 직접 매번 세면 O(n)
	- 5의 거듭제곱 / 5는 5의 개수와 동일하다는 것을 이용하면 O(logN)
*/
/*
	0! = 1
	1! = 1
	2! = 2
	3! = 6
	4! = 24
	5! = 120
	6! = 720
	7! = 5040
	8! = 40320
	9! = 362880
	10! = 3628800
	11! = 39916800
	12! = 479001600
	13! = 6227020800
	14! = 87178291200
	15! = 1307674368000
	16! = 20922789888000
	17! = 355687428096000
	18! = 6402373705728000
	19! = 121645100408832000
	20! = 2432902008176640000
	5개 단위로 0이 늘어남... => N/5
	근데 5개 단위 끝나면 카운트 늘어남.. => N/5 + 
	이렇게 푸는거 아님
*/