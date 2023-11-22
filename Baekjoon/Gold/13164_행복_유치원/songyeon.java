import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> heights = new ArrayList<>(); // 키 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> heightDiff = new ArrayList<>(); // 키 차이 배열
        for (int i = 1; i < N; i++) {
            heightDiff.add(heights.get(i) - heights.get(i - 1));
        }

        Collections.sort(heightDiff);

        int cost = 0;
        for (int i = 0; i < N - K; i++) { // N-1 개에서 K-1 개 제외
            cost += heightDiff.get(i);
        }

        bw.write(cost+"");
        bw.close();
        br.close();
    }
}
