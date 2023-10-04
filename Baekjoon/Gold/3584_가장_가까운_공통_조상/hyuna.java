import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int T, N, K;
    public static int[] depth;
    public static boolean[] isRoot;
    public static int[][] parent; // parent[K][V] = 정점 V의 2^K번째 조상 정점 번호
    public static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        while(T-->0){
            N = Integer.parseInt(br.readLine()); // 트리 구성하는 노드 개수

            tree = new ArrayList[N+1];
            for(int i=1;i<=N;i++){
                tree[i] = new ArrayList<>();
            }

            isRoot = new boolean[N+1];
            Arrays.fill(isRoot,true);

            for(int i=1;i<=N-1;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree[parent].add(child);
                isRoot[child] = false;
            }

            int rootIdx = 0;
            for(int i=1;i<=N;i++){
                if(isRoot[i]){
                    rootIdx = i;
                    break;
                }
            }

            // 트리 최대 높이 구하기
            K = (int)(Math.ceil(Math.log(N)/Math.log(2)));
            depth = new int[N+1];
            parent = new int[K+1][N+1];
            dfs(rootIdx,1);
            fillParent();

            // 가장 가까운 공통 조상
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(Integer.toString(lca(a,b))+"\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }

    // 깊이 구하기
    public static void dfs(int id, int cnt){
        depth[id] = cnt;

        int len = tree[id].size(); // 자식 depth
        for(int i=0;i<len;i++){
            int next = tree[id].get(i);

            if(depth[next] == 0){
                dfs(next, cnt+1);
                parent[0][next] = id; // 첫번째 부모 기록
            }
        }
    }

    // parent 채우기
    public static void fillParent(){
        for(int i=1;i<=K;i++){
            for(int j=1;j<=N;j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
    }

    public static int lca(int a, int b){
        // a = b보다 depth가 크거나 같은 정점
        if(depth[a] < depth[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int i=K;i>=0;i--){
            if(Math.pow(2,i) <= depth[a] - depth[b]){
                a = parent[i][a]; // a의 2^i번째 부모로 변경
            }
        }

        if(a == b){ // 두 정점이 같은 경우
            return a;
        }

        // 공통부모 바로 아래까지 올리기
        for(int i=K;i>=0;i--){
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        return parent[0][a];
    }
}