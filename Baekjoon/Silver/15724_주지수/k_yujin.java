import java.io.*;
import java.util.StringTokenizer;
public class BOJ_주짓수 {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;

    public static int [][] dp;
    public static int [][] nums;
    public static Range[] ranges;
    public static int [] result;

    public static void run() throws Exception {
        input();
        solution();
        output();
    }

    public static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nums = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        // nums 배열 채우기(주지수)
        for(int i =1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j< M+1; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        result = new int[K];
        ranges = new Range[K];

        // range 배열 채우기(범위)
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            ranges[i] = new Range(x1,y1,x2,y2);
        }
    }

    public static void solution(){
        // 구간 합 구하기
        for(int i =1; i< nums.length; i++){
            for(int j =1; j< nums[0].length; j++){
                dp[i][j] = nums[i][j]+ dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        // 범위에 따른 구간합 구하기
        for(int k=0; k<ranges.length; k++){
            Range range = ranges[k];
            result[k] = dp[range.x2][range.y2] // 전체 사각형
                    - dp[range.x1-1][range.y2] - dp[range.x2][range.y1-1] // 안쪽 사각형
                    + dp[range.x1-1][range.y1-1]; // 겹친 부분
        }

    }
    public static void output() throws Exception{
        for(int i=0; i< result.length; i++){
            bw.write(result[i] + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    public static void main(String [] args) throws Exception {
        new BOJ_주짓수().run();
    }
}
class Range{
    int x1;
    int y1;
    int x2;
    int y2;

    public Range(int x1,int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
