import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken()) % 2;
        }

        int result = 0;
        int start = 0, end = 0;
        int newK = K;

        while (end < N) {
            while (end < N && newK >= 0) {
                if (nums[end] == 1) {
                    newK--;
                }
                end++;
            }
            result = Math.max(result, end - start - (K - newK));
            if (nums[start] == 1) {
                newK++;
            }
            start++;
        }

        System.out.println(result);
    }
}