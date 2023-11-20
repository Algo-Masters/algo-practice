package DP;

import java.io.*;
import java.util.StringTokenizer;

// 주지수
public class no15724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 영토의 크기 N, M 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int area[][] = new int[N+1][M+1];

        // 단위 구역 내에 살고 있는 사람 수 입력받기
        for(int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1; m <= M; m++) {
                area[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // (1,1)에서 (n, m) 구역에 살고 있는 사람의 수 저장하기
        int[][]dp = new int[N+1][M+1];

        for(int n = 1; n <= N; n++) {
            for(int m = 1; m <= M; m++) {
                dp[n][m] = dp[n-1][m] + dp[n][m-1] + area[n][m] - dp[n-1][m-1];
            }
        }

        int x1, y1, x2, y2;
        // 진경대왕이 인구 수를 궁금해하는 직사각형 범위의 개수 입력받기
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {    // K만큼 좌표 입력받기
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            // (x1,y1) 에서 (x2,y2) 구역에 살고 있는 사람의 수 계산
            // dp(x2,y2)에서 (x1, y1)이전의 값 빼주기 (겹치는 부분을 더해줘야 한다.)
            bw.write(Integer.toString(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]) + '\n');
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
