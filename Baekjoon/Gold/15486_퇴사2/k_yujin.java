import java.io.*;
import java.util.StringTokenizer;
public class BOJ_퇴사2 {

    static BufferedReader br;
    static BufferedWriter bw ;

    static int [] period;
    static int [] cost;
    static int [] dp;
    static int N;
    public static void main(String [] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();
        solution();
        bw.write(dp[0]+"\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        period = new int[N+2];
        cost = new int[N+2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            period[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solution() {
        for(int i= N-1; i>=0; i--) {
            int j = i+period[i];
            if(j > N){ // 정해진 기간(N)을 넘어 제외 대상
                dp[i] = dp[i+1];
            }
            else{
                // dp[i]에는 현재 날까지 얻을 수 있는 최대 비용을 저장(시작은 가장 왼쪽부터)
                // i번째 비용 > i일부터 기간 i동안 얻을 수 있는 비용 => dp[i]값 갱신
                dp[i] = Math.max(dp[i+1], dp[j] + cost[i]);
            }
        }
    }


}
