import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 남은 일 수
        int N = Integer.parseInt(br.readLine());

        // dp 값
        int [] dp = new int[N+1];

        // 최대 수익
        int max = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            // N일에 따른 상담 일정 입력
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            // max보다 현재 dp값이 클 경우 변경
            if(max < dp[i])
                max = dp[i];

            // dp 값 설정
            if (t+i < N + 1) {
                dp[t+i] = Math.max(dp[t+i], max + p);
            }
        }

        // 마지막 날도 근무 했을 수도 있으니 확인
        if(max < dp[N])
            max = dp[N];

        System.out.println(max);
    }

}