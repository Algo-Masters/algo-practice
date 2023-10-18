import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 행복 유치원
public class jo-yujin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 유치원생 수
        int K = Integer.parseInt(st.nextToken());   // 나누려고 하는 조의 개수

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];     // 유치원생의 키들

        for(int i = 0; i < N; i++) {    // 키 입력받기
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] differece = new int[N-1]; // 키 차이를 담은 배열
        for(int i = 1; i < N; i++) {
            differece[i-1] = heights[i] - heights[i-1];
        }

        Arrays.sort(differece);    // 오름차순 정렬
        int result = 0;
        for(int i = 0; i < N-K; i++) {  // 유치원생 수 - K
            result += differece[i];
        }

        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        bw.close();
    }
}
