package sorting;

import java.util.*;

class Island implements Comparable<Island> {
	int x, y, index;

	public Island(int x, int y, int index){
		this.x = x;
		this.y = y;
		this.index = index;
	}
	
	@Override
	public int compareTo(Island o){
			if (this.x == o.x)
			    return this.y - o.y;
			else
			    return this.x - o.x;
	}
}

public class Pirate{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Island> islands = new ArrayList<>();
		
		for(int i=0; i<n; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			islands.add(new Island(x, y, i));
		}

		Collections.sort(islands);
		
		int[] res = new int[n];
		
		for(int i=0; i<n; i++){
			res[islands.get(i).index] = n - i -1;
		}

		for(int i=0; i<n; i++){
			System.out.println(res[i]);
		}
	}
}

/*

1. 아래 조건으로 sorting
 if (ax == bx && ay < by) || ax < bx :
2. i번 인덱스 구하기
3. length - i 가 답
 -> indexOf 쓰면 nlogn + n^2 되므로 타임아웃
 -> O(n)으로 index 구하려면..? 각 섬의 좌표와 인덱스를 Map에 맵핑 (섬 좌표는 중복되지 않으므로)
  --> 정렬 O(nlogn), index 검색 O(2N), but 타임아웃 발생..
*/

/* 해시맵 기반 (좌표값을 Key로 하여 인덱스 저장)
import java.util.*;

public class Pirate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] islands = new int[n][2];
        for (int i = 0; i < n; i++) {
            islands[i][0] = sc.nextInt();
            islands[i][1] = sc.nextInt();
        }

        // 정렬
        List<int[]> sorted = new ArrayList<>(Arrays.asList(islands));
        Collections.sort(sorted, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        // 좌표값을 문자열로 key 사용
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] island = sorted.get(i);
            String key = island[0] + "," + island[1];
            indexMap.put(key, i);
        }

        // 결과 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String key = islands[i][0] + "," + islands[i][1];
            sb.append(n - indexMap.get(key) - 1).append('\n');
        }

        System.out.print(sb);
    }
}

*/