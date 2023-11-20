import java.util.*;
import java.io.*;

public class Main {
    public static int[][] meeting;
    public static int[] price;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        meeting = new int[n+2][2];
        price = new int[n+2];
        StringTokenizer st;

        for(int i = 1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            meeting[i][0] = t;
            meeting[i][1] = p;
        }

        int max = -1;
        for(int i = 1; i<=n+1; i++) {
            if(max < price[i])
                max = price[i];
            int nextDate = i + meeting[i][0];
            if(nextDate < n+2) {
                price[nextDate] = Math.max(price[nextDate], max + meeting[i][1]);
            }
        }
        System.out.println(price[n+1]);

    }
}
