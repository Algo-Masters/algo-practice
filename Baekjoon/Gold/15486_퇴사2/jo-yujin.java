package DP;


import java.io.*;
import java.util.StringTokenizer;

// 퇴사
public class no15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] time = new int[N+2];      // 상담을 완료하는데 걸리는 기간 Ti
        int[] pay = new int[N+2];       // 받을 수 있는 금액   Pi
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];  // i일까지 일했을 때 받을 수 있는 최대 수익
        int max = 0;
        for(int i = 1; i < N+2; i++) {
            if(max < dp[i])  max = dp[i];

            int endDay = i + time[i];  // 상담이 끝나는 날
            if (endDay < N + 2) {
                dp[endDay] = Math.max(dp[endDay], max + pay[i]);
                // 이미 구해진 수익 + 상담이 끝났을 때 받는 수익과 그 날의 수익중 최대 수익
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();
        br.close();
        bw.close();
    }
}
