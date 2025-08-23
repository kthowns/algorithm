package sorting;

import java.util.*;
/*
class Pirate {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] islands = new int[n][2];

		for(int i=0; i<n; i++){ //O(n)
			islands[i][0] = sc.nextInt();
			islands[i][1] = sc.nextInt();
		}

		List<int[]> sorted = sort(islands); //O(nlogn)
		HashMap<int[], Integer> indexes = new HashMap<>();

		for(int i=0; i<n; i++){ //O(n)
			indexes.put(sorted.get(i), i);
		}
		
		for(int i=0; i<n; i++){ //O(n)
			System.out.println(n-indexes.get(islands[i])-1);
		}
	}

	public static List<int[]> sort(int[][] array){
		List<int[]> list = new ArrayList<>(Arrays.asList(array));
		Collections.sort(list, (a, b) -> {
			if (a[0] == b[0] && a[1] < b[1])
			    return -1;
			else if (a[0] < b[0])
			    return -1;
			else
			    return 1;
		});

		return list;
	}
}
*/

/*

1. 아래 조건으로 sorting
 if (ax == bx && ay < by) || ax < bx :
2. i번 인덱스 구하기
3. length - i 가 답
 -> indexOf 쓰면 nlogn + n^2 되므로 타임아웃
 -> O(n)으로 index 구하려면..? 각 섬의 좌표와 인덱스를 Map에 맵핑 (섬 좌표는 중복되지 않으므로)
  --> 정렬 O(nlogn), index 검색 O(2N), but 타임아웃 발생..
*/

public class Pirate{
	public static void main(String[] args) {
		
	}
}