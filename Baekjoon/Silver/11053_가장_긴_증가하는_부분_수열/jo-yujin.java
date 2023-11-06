package DP;

import java.io.*;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
public class no11053 {
    public static int[] sequence;
    public static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수열의 크기
        sequence = new int[N];
        dp = new Integer[N];    // 수열의 길이를 담는 배열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {    // 수열 입력 받기
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        // 최댓값 찾기
        for(int i = 1; i < N; i++) {
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }

    static int LIS(int N) {
        // 만약 탐색하지 않던 위치의 경우
        if(dp[N] == null) {
            dp[N] = 1;  // 1로 길이를 초기화

            for(int i = N-1; i >= 0; i--) {
                if(sequence[i] < sequence[N]) { // 현재 수가 이전 수보다 크면
                    dp[N] = Math.max(dp[N], LIS(i) + 1);   // 이전 수 길이의 + 1과 현재 길이 중 큰 값을 길이로 저장
                }
            }
        }
        return dp[N];
    }
}
