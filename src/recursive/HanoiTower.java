package recursive;
import java.util.*;

class HanoiTower {
	static int cnt = 0;
	static final int MAX = 20;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		ArrayList<Integer> last = new ArrayList<>();
		for(int i=MAX; i>0; i--){
			first.add(i);
		}

		hanoi(MAX, k, first, second, last);

		int firstSum = 0;
		int secondSum = 0;
		int lastSum = 0;
		
		for(Integer num : first){
			firstSum += num;
		}

		for(Integer num : second){
			secondSum += num;
		}
		
		for(Integer num : last){
			lastSum += num;
		}

		System.out.println(firstSum + " " + secondSum + " " + lastSum);
	}

	public static void hanoi(int n, int k, ArrayList<Integer> current, ArrayList<Integer> temp, ArrayList<Integer> target){
		if(cnt >= k || n==0){
			return;
		}
		hanoi(n-1, k, current, target, temp);
		if(cnt >= k){
			return;
		}
		target.add(current.remove(current.size()-1));
		cnt++;
		if(cnt >= k){
			return;
		}
		hanoi(n-1, k, temp, current, target);
	}
}

/*
(1) 1 = 1
current -> target

(1, 2) 2 = 3
current(1) -> temp
current(2) -> target
temp(1) -> target

(1, 2, 3) 3 = 7
- current -> temp
current(1) -> temp
current(2) -> target
temp(1) -> target
-

- current -> target
current(3) -> target
-

- temp -> target
current(1) -> temp
current(2) -> target
temp(1) -> target
-

(1, 2, 3, 4) 4 = 15

5 = 31
6 = 63
7 = 127
8 = 255
...
20 = 1,048,575
*/