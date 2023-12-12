import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = N;
        int max = 0;

        while(start < end) {
            int startNum = nums[start];
            int endNum = nums[end];
            max = Math.max(max, Math.min(startNum, endNum) * (end - start - 1));

            if(startNum > endNum) {
                end--;
            }
            else  {
                start++;
            }
        }
        System.out.println(max);
    }
}