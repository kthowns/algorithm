package basicmath;

import java.util.Scanner;
import java.math.*;

public class Main1002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int ax = sc.nextInt();
			int ay = sc.nextInt();
			int ar = sc.nextInt();
			
			int bx = sc.nextInt();
			int by = sc.nextInt();
			int br = sc.nextInt();

			double d = Math.sqrt(Math.pow(ax-bx, 2) + Math.pow(ay-by, 2));

		}
	}
}
/*
	- A와 B의 좌표가 있을 때, A<->C, B<->C의 거리가 주어진다
	- 존재할 수 있는 C의 좌표 경우의 수를 구하라
	- 두 지점간의 거리만 갖고 좌표를 구하라..
	- A와 B에 원을 그리고 두 원의 접점 개수가 C 좌표 경우의 수이다
	- C 좌표 무한대의 경우는 A와 B가 같은 지점이고 C와 같은 거리인 경우이다
	- C 좌표 0인 경우는 접점이 없는 원인 경우이다
	- 모든 경우
	 -> A 중심이 B 안에 있는 경우 d < ar
	  --> 내접하는 경우 : |ar - br| = d, d != 0
	  --> 두 접에서 접하는 경우 : 
	  --> 접하지 않는 경우 : |ar - br| > d, d != 0
	  --> 동심원인 경우 : d != 0
	   ---> 반지름이 같은 경우 
	   ---> 반지름이 다른 경우
	 -> A 중심이 B 밖에 있는 경우
	  --> 외접하는 경우
	  --> 두 점에서 접하는 경우
	  --> 접하지 않는 경우
	  
	r = 3, 원점 (3, -1)인 원의 방정식
	=> (x-3)^2 + (y+1)^2 = 9
*/