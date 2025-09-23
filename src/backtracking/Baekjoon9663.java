package backtracking;

import java.util.*;

public class Baekjoon9663 {
	static boolean[][] board = new boolean[15][15];
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int half = (int)Math.ceil((double)n/2);
		int result = 0;
		
		for(int i=0; i<half; i++) {
			for(int j=0; j<half; j++) {
				result += solve(i, j, n);
			}
		}
		
		System.out.println(result);
	}
	
	public static int solve(int x, int y, int leftQueen) {
		if(countCheck(x, y, leftQueen)) {
			return 0;
		}
			
		for(int i=0; i<n; i++) { // 상하 좌우
			board[y][i] = false;
			board[i][x] = false;
		}
		
		for(int i=0; i<n; i++) {
			board[y+i][x+i] = false;
			board[n-y-i][n-x-i] = false;
		}
		
		board[y][x] = true;
		
		return 0;
	}
	
	public static boolean countCheck(int x, int y, int leftQueen) {
		int count = 0;
		
		for(int i=y; i<n; i++) {
			for(int j=x; j<n; j++) {
				if(board[i][j]) {
					count++;
				}
			}
		}
		
		if(leftQueen < n) {
			return false;
		}
		
		return true;
	}
}

/*
	N-Queen
	
	n*n 일 때 n개를 서로 공격할 수 없도록 놓는 경우의 수
	
	1. n^2 개의 자리 중 n^2/2, n^2/2의 자리에 첫 퀸을 놓는다
	2. 첫 퀸 자리로부터 나머지 모든 맵에 대해 소거한다
	3-1. 소거되지 않은 자리가 n-queenCount 보다 많을 경우
	 -> 다음 퀸을 올리고 2.로 돌아간다
	3-2. 소거되지 않은 자리가 n-queenCount 보다 적을 경우
	 -> 해당 첫 퀸 자리는 경우가 없는 것이므로 1.로 돌아간다
*/