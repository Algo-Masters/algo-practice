import java.io.*;
import java.util.*;

public class Main {

    public static int[] num;
    public static Integer[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열 길이
        num = new int[n];
        sum = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<n; i++){
            sum[i] = num[i];
            for(int j = 0; j<i; j++){
                if(num[i] > num[j]) {
                    sum[i] = Math.max(sum[j]+num[i], sum[i]);
                }
            }
        }

        Arrays.sort(sum, Collections.reverseOrder());
        System.out.println(sum[0]);
    }
}
