import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int[] kids;
    static int[] heightSub;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 유치원생의 수
        int k = Integer.parseInt(st.nextToken()); // 조의 개수
        int result = 0;

        kids = new int[n];
        heightSub = new int[n-1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            kids[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<n-1; i++){ // 인접한 학생들의 키의 차를 배열에 저장
            heightSub[i] = kids[i+1] - kids[i];
        }
        Arrays.sort(heightSub);
        for(int i = 0; i<n-k; i++){
            result += heightSub[i];
        }
        System.out.println(result);

    }
}