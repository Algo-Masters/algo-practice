import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 센서 수(N)와 집중국 수(K) 입력
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // 센서
        int [] sensors = new int[N];

        // 원생 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        // 센서 값 정렬
        Arrays.sort(sensors);

        // 근처 값과의 차이 값
        int [] gaps = new int[N-1];
        for(int i=1;i<N;i++) {
            gaps[i-1] = sensors[i] - sensors[i-1];
        }

        // 센서 값 정렬
        Arrays.sort(gaps);

        // 조 비용 결과 구하기
        int receiveArea = 0;
        for(int i=0;i<N-K;i++) {
            receiveArea += gaps[i];
        }

        // 출력
        bw.write(receiveArea + "\n");
        bw.flush();
        bw.close();
        }
}

