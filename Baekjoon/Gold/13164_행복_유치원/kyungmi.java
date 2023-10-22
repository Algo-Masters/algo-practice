import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 원색 수(N)와 조 수(K) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 근처 값과의 차이 값
        int [] gaps = new int[N-1];

        // 원생
        int [] people = new int[N];

        // 원생 입력
        st = new StringTokenizer(br.readLine());
        people[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++) {
            people[i] = Integer.parseInt(st.nextToken());
            // 차이값 구하기
            gaps[i-1] = people[i] - people[i-1];
        }

        // 차이 값 정렬
        Arrays.sort(gaps);

        // 조 비용 결과 구하기
        int sumCash = 0;
        for(int i=0;i<N-K;i++) {
            sumCash += gaps[i];
        }

        // 출력
        bw.write(sumCash + "\n");
        bw.flush();
        bw.close();
        }
}

