import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int start = 1;
        int end = n;
        while(start<=end) {
            int min = Math.min(arr[start], arr[end]);
            int between = end - start - 1;
            max = Math.max(between * min, max);
            if(arr[start] < arr[end]) {
                start++;
            }else {
                end--;
            }
        }

        System.out.println(max);
    }
}
