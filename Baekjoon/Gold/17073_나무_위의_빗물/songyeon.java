package new_start;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int leafNodeCnt = 0;
    public static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int W = Integer.parseInt(st.nextToken()); // 물의 양

        edges = new ArrayList[N+1]; // 트리의 간선 정보
        for (int e=0;e<edges.length;e++){
            edges[e] = new ArrayList<Integer>();
        }

        for (int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges[u].add(v);
            edges[v].add(u);
        }

        for (int i=2;i<=N;i++){ //N이 2일 때 고려
            if (edges[i].size() == 1){
                leafNodeCnt++;
            }
        }

        System.out.println((double)W/leafNodeCnt);
        bw.flush();
    }
}
