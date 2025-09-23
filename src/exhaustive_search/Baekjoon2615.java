package exhaustive_search;

import java.util.*;

public class Baekjoon2615 {
	final static int N = 19;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[N][N];
		boolean[][] visitedRight = new boolean[N][N];
		boolean[][] visitedDiagRight = new boolean[N][N];
		boolean[][] visitedDiagLeft = new boolean[N][N];
		boolean[][] visitedDown = new boolean[N][N];
		boolean isDone = false;
		int winX = 0;
		int winY = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j] == 0) {
					continue;
				}
				
				boolean isDiagLeft = false;
				
				if(!visitedRight[i][j]) {
					isDone = checkRight(board, visitedRight, j, i);
				}
				if(!visitedDown[i][j] && !isDone) {
					isDone = checkDown(board, visitedDown, j, i);
				}
				if(!visitedDiagRight[i][j] && !isDone) {
					isDone = checkDiagRight(board, visitedDiagRight, j, i);
				}
				if(!visitedDiagLeft[i][j] && !isDone) {
					isDone = checkDiagLeft(board, visitedDiagLeft, j, i);
					isDiagLeft = isDone;
				}


				if(isDone) {
					winY = i;
					winX = j;
					if(isDiagLeft) {
						winY += 4;
						winX -= 4;
					}
					break;
				}
			}
			
			if(isDone) {
				break;
			}
		}
		
		
		if(isDone) {
			System.out.println(board[winY][winX]);
			System.out.print((winY+1) + " " + (winX+1));
		} else {
			System.out.println("0");
		}
	}
	
	static boolean checkRight(int board[][], boolean visited[][], int x, int y) {
		int currentPlayer = board[y][x];
		
		if(currentPlayer == 0) {
			return false;
		}
		
		int cnt = 0;
		while(x < N && board[y][x] == currentPlayer) {
			cnt++;
			visited[y][x] = true;
			x++;
		}
		
		if(cnt == 5) {
			return true;
		}
		
		return false;
	}
	
	static boolean checkDiagRight(int board[][], boolean[][] visited, int x, int y) {
		int currentPlayer = board[y][x];
		
		if(currentPlayer == 0) {
			return false;
		}
		
		int cnt = 0;
		while(x < N && y < N && board[y][x] == currentPlayer) {
			cnt++;
			visited[y][x] = true;
			x++;
			y++;
		}
		
		if(cnt == 5) {
			return true;
		}
		
		return false;
	}
	
	static boolean checkDiagLeft(int board[][], boolean[][] visited, int x, int y) {
		int currentPlayer = board[y][x];
		
		if(currentPlayer == 0) {
			return false;
		}
		
		int cnt = 0;
		while(x >= 0 && y < N && board[y][x] == currentPlayer) {
			cnt++;
			visited[y][x] = true;
			x--;
			y++;
		}
		
		if(cnt == 5) {
			return true;
		}
		
		return false;
	}
	
	static boolean checkDown(int board[][], boolean visited[][], int x, int y) {
		 int currentPlayer = board[y][x];
		
		if(currentPlayer == 0) {
			return false;
		}
		
		int cnt = 0;
		while(y < N && board[y][x] == currentPlayer) {
			cnt++;
			visited[y][x] = true;
			y++;
		}
		
		if(cnt == 5) {
			return true;
		}
		
		return false;
	}
}
