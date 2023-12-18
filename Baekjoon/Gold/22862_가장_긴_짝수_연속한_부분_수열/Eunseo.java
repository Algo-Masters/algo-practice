package ex3003;

import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	public static void main(String[] args) throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int oddNum = 0;
		int maxLength = -1;
		
		while(end < arr.length) {
			if(oddNum < k) {
				if(arr[end] % 2 == 1) {
					oddNum += 1;
				}
				end++;
				maxLength = Math.max(maxLength, end-start-oddNum);
			}
			else if(arr[end] % 2 == 0) {
				end++;
				maxLength = Math.max(maxLength, end-start-oddNum);
			}
			else if(oddNum == k && arr[end] % 2 == 1) {
				if(arr[start] % 2 == 1) {
					oddNum -= 1;
				}
				start++;
			}
		}
		System.out.println(maxLength);
	}
}
