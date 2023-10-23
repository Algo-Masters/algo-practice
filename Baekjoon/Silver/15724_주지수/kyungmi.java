import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 영토 크기 N,M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 0,0 부터 n,m까지 사람 수 합
        int [][] peopleSum = new int[N+1][M+1];

        // 각 영토 별로 사람 수 입력
        int [][] peopleNums = new int[N+1][M+1];

        for(int n=1; n<=N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m=1; m<=M; m++) {
                peopleNums[n][m] = Integer.parseInt(st.nextToken());

                // 0,0 부터 n,m까지 사람 수 합
                // ( 내 앞 그룹의 합 + 내 위 그룹의 합 - 내 대각선 그룹의 합 + 나 )
                peopleSum[n][m] =
                        peopleSum[n-1][m] + peopleSum[n][m-1] - peopleSum[n-1][m-1] + peopleNums[n][m];
            }
        }

        // 궁근한 인구수 범위
        int K = Integer.parseInt(br.readLine());

        // 직사각형 범위에 따른 인구수 출력
        for(int k=0; k<K; k++) {
            // 직사각형 입력
            st = new StringTokenizer(br.readLine());

            int [] rect = new int[4];
            for(int i=0;i<4;i++)
                rect[i] = Integer.parseInt(st.nextToken());

            // 끝 꼭지점까지 합 - 앞 꼭지점 앞 그룹의 합 - 앞 꼭지점 위 그룹의 합 + 앞 꼭지점 대각선 그룹의 합
            // 앞 꼭지점 : x1,y1 | 끝 꼭지점 : x2,y2
            bw.write(peopleSum[rect[2]][rect[3]] - peopleSum[rect[0]-1][rect[3]]
                    - peopleSum[rect[2]][rect[1]-1] + peopleSum[rect[0]-1][rect[1]-1] + "\n");
        }
        bw.flush();
        bw.close();

    }
}