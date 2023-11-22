package ex3003;

import java.io.*;
import java.util.*;

public class Main {
	public static int n,m,r;
	public static int rcount;
	public static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rcount = Math.min(n, m)/2;
		for(int i = 0; i<r; i++) {
			spin();
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public static void spin() {
		for(int i = 0; i<rcount; i++) {
			int x = i;
			int y = i;
			
			int temp = map[x][y];
			int idx = 0;
			while(idx<4) {
				int nextx = x + dx[idx];
				int nexty = y + dy[idx];
				
				if(nextx<n-i && nexty<m-i && nextx >= i && nexty >= i) {
					map[x][y] = map[nextx][nexty];
					x = nextx;
					y = nexty;
				}else {
					idx++;
				}
			}
			map[i+1][i] = temp;
		}

	}
}
