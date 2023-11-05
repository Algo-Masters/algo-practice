import java.awt.desktop.QuitEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

       // 케이스 실행
        for(int t=0;t<T;t++) {
            // 동전 가지 수
            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer> coins = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 동전 입력
            for (int n=0;n<N;n++) {
                coins.add(Integer.parseInt(st.nextToken()));
            }

            // 만들어야할 금액 M
            int M = Integer.parseInt(br.readLine());

            int [] dp = new int [M+1];
            dp[0] = 1;

            // i부터 M까지 구할 수 있는 값 구하기
            // dp[i] = i번째 수를 만들 수 있는 경우의 수 개수
            for (int n=0;n<N;n++) {
                for(int i=coins.get(n);i<=M;i++) {
                    dp[i] += dp[i - coins.get(n)];
                }
            }

            bw.write(dp[M] + "\n");
        }
        bw.flush();
        bw.close();
    }
}