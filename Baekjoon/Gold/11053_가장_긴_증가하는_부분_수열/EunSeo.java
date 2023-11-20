import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] num = new int[n]; // 예제 입력 숫자
        int[] distance = new int[n]; // 수열 길이

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1; // max = 최대 수열 길이
        for(int i = 0; i<n; i++){
            distance[i] = 1;
            for(int j = 0; j<i; j++){
                if(num[i] > num[j])
                    distance[i] = Math.max(distance[i], distance[j]+1);
            }
            max = Math.max(max, distance[i]);
        }
        System.out.println(max);

    }

}