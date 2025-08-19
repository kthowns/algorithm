package basicalgorithm;

import java.util.*;

public class GameJam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[][] map = new String[n][n];
		
		int gr = sc.nextInt()-1;
		int gc = sc.nextInt()-1;
		
		int pr = sc.nextInt()-1;
		int pc = sc.nextInt()-1;

		sc.nextLine(); // 공백 문자 소모
		
		for(int i=0; i<n; i++){
			map[i] = sc.nextLine().split(" ");
		}

		int gScore = start(gr, gc, map, n);
		int pScore = start(pr, pc, map, n);

		if(gScore > pScore){
			System.out.println("goorm " + gScore);
		} else {
			System.out.println("player " + pScore);
		}
	}

	public static int start(int currentR, int currentC, String[][] map, int n){
		boolean[][] visited = new boolean[n][n];
		visited[currentR][currentC] = true;
		int score = 1;

		while(true){
			String direction = map[currentR][currentC];
			int count = Integer.parseInt(direction.substring(0, direction.length()-1));
			String command = direction.substring(direction.length()-1, direction.length());
			boolean isDone = false;
			
			for(int i=0; i<count; i++){
				if(command.equals("L")) {
					currentC--;
					if(currentC < 0){
						currentC = n-1;
					}
				} else if(command.equals("R")) {
					currentC++;
					if(currentC > n-1){
						currentC = 0;
					}
				} else if(command.equals("U")) {
					currentR--;
					if(currentR < 0){
						currentR = n-1;
					}
				} else {
					currentR++;
					if(currentR > n-1){
						currentR = 0;
					}
				}
				if(visited[currentR][currentC]){
					isDone = true;
					break;
				}
				visited[currentR][currentC] = true;
				score++;
			}
			if(isDone){
				break;
			}
		}
		
		return score;
	}
}

/*
	- 맵 밖에 나가면 반대편 끝으로 이동
	- 이미 방문한 칸을 지날 시 게임 종료
	- 점수 : 방문한 칸의 개수
	- 파싱 부분이 2자리 넘어가면 잘못된다 => 잘못 되었다
*/