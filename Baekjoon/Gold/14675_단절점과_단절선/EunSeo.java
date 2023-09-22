import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 문제조건의 트리의 점정 최대 개수가 100000 이므로
        // 크기가 100000인 배열 생성
        int[] array = new int[100000];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a] = array[a] + 1;
            array[b] = array[b] + 1;
        }

        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (k == 1){
                if(array[t] > 1){
                    sb.append("yes").append("\n");
                }else if(array[t] == 1){
                    sb.append("no").append("\n");
                }
            }else
                sb.append("yes").append("\n");
        }
        System.out.println(sb);
    }
}