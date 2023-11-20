import java.util.*;
import java.io.*;

public class Main {

    public static int[][] population;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        population = new int[n+1][m+1];
        for(int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=m; j++){
                int pop = Integer.parseInt(st.nextToken());
                population[i][j] = pop + population[i-1][j] + population[i][j-1] - population[i-1][j-1];
            }
        }
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = population[x2][y2] - population[x2][y1-1] - population[x1-1][y2] + population[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
