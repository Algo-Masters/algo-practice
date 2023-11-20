import java.io.*;
import java.util.*;

public class Main {
	
	public static int n, m;
	public static ArrayList<Integer>[] list;
	public static int[] dp;
	public static void main(String[] args) throws Exception  {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		dp = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
			dp[i]++;
		}
		
		for(int i = 1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		for(int i = 1; i<=n; i++) {
			for(int j = 0; j<list[i].size(); j++) {
				int preSubject = i;
				int subject = (int) list[i].get(j);
				
				dp[subject] = Math.max(dp[subject], dp[preSubject]+1);
			}
		}
		
		for(int i = 1; i<=dp.length-1; i++) {
			sb.append(dp[i]).append(" ");
		}
		System.out.println(sb);
	
	}
}
