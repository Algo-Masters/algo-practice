import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

       int[] edges = new int[N+1]; // 각 정점의 간선 개수

        for (int i=0; i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            edges[v1]++;
            edges[v2]++;
        }

        int Q = Integer.parseInt(br.readLine());
        for (int q=0; q < Q; q++){
            st = new StringTokenizer(br.readLine());
            int t =  Integer.parseInt(st.nextToken());
            int k =  Integer.parseInt(st.nextToken());

            if (t == 1) { // 단절점인지 확인
              if (edges[k] >= 2){
                  bw.write("yes\n");
              }
              else {
                  bw.write("no\n");
              }
            }
            else { // 모든 간선은 단절 선일 수 밖에 없다
                bw.write("yes\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

}
