import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리 - 가장 가까운 공통 조상

public class jo-yujin {
    static int[] tree;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());  // 노드의 수
            tree = new int[N + 1];
            visit = new boolean[N + 1];

            for(int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken()); // 부모
                int child = Integer.parseInt(st.nextToken()); // 자식
                tree[child] = parent;
            }

            st = new StringTokenizer(br.readLine()); // 가장 가까운 공통 조상을 구할 두 노드
            int child1 = Integer.parseInt(st.nextToken());
            int child2 = Integer.parseInt(st.nextToken());
            findParent(child1, child2);
        }
    }

    static void findParent(int child1, int child2) {
        while(child1 > 0) { // 첫번째로 입력받은 노드를 루트 노트까지 체크하면서 이동
            visit[child1] = true;   // 방문한 노드 체크
            child1 = tree[child1]   // 부모 노드로 이동
            ;       }

        while(child2 > 0) { // 두번째로 입력받은 노드를 루트 노드로 이동
            if(visit[child2]) {  // 이동중 이미 체크되어 있을 경우 공통 조상임
                System.out.println(child2);
                break;
            }
            child2 = tree[child2]; // 부모 노드로 이동
        }

    }
}
