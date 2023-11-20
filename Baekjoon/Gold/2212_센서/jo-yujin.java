import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 센서
public class jo-yujin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 센서의 개수
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   // 집중국의 개수

        st = new StringTokenizer(br.readLine());

        int[] array = new int[N];   // 센서 배열
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());    // 센서 저장
        }

        Arrays.sort(array); // 좌표 정렬

        int[] difference = new int[N-1];    // 거리의 차
        for(int i = 0; i < N-1; i++) {
            difference[i] = array[i+1] - array[i];
        }

        Arrays.sort(difference);

        int minSum = 0;
        for(int i = 0; i < N-K; i++) {
            minSum += difference[i];
        }

        bw.write(Integer.toString(minSum));
        bw.flush();
        br.close();
        bw.close();
    }
}
