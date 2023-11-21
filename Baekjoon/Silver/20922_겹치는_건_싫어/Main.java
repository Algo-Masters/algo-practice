
import java.io.*;
import java.util.*;

public class Main {
	
	public static int[] arr;
	public static int[] cnt = new int[100001];
	public static void main(String[] args) throws Exception  {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int start = 0, end = 0, result = 0;
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(end<arr.length) {
			while(end<arr.length && cnt[arr[end]] + 1 <= k) {
				cnt[arr[end]]++;
				end++;
			}
			int len = end - start;
			result = Math.max(result, len);
			cnt[arr[start]]--;
			start++;
		}
		System.out.println(result);
		
	}
}
