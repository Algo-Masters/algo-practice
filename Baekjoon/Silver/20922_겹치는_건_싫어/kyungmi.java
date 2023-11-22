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

        int [] nums = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int start = 0, end = 0;
        int [] numsCount = new int[100001];

        while(end < N) {
            while (end < N && numsCount[nums[end]] < K) {
                numsCount[nums[end]]++;
                end++;
            }
            result = Math.max(result, end - start);
            numsCount[nums[start]]--;
            start++;
        }

        System.out.println(result);
    }
}