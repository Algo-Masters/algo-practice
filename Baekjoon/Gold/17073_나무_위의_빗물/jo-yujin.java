import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 나무 위의 빗물
public class jo-yujin {
    public static ArrayList<Integer>[] links;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());   // 트리 노드의 수
        int W = Integer.parseInt(st.nextToken());   // 1번 노드에 고인 물의 양
        links = new ArrayList[N + 1];    // 간선 정보

        for(int i = 1; i <= N; i++) {
            links[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i < N; i++) {    // N-1 만큼의 간선 정보 입력받아 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            links[a].add(b);
            links[b].add(a);
        }

        int reafNodeCount = 0;  // 리프 노드의 개수
        for(int i = 2; i <= N; i++) {
            if(links[i].size() == 1) {   // 연결된 노드가 하나 => 리프 노드
                reafNodeCount++;    // 리프 노드의 개수 증가
            }
        }

        String result = String.format("%.10f", (double) W / reafNodeCount); // 고인 물의 양 / 리프노드 개수
        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }
}
