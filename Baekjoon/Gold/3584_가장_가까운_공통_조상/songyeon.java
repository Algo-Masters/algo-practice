import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int[] tree; // 각 노드의 부모에 대한 정보 담아놓을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-->0){

            int N = Integer.parseInt(br.readLine());
            tree = new int[N + 1];
            for (int i=0;i<N-1;i++){
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                tree[child] = parent; // 각 노드의 부모를 저장
            }

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken()); // 공통 부모를 구해야할 node1
            int node2 = Integer.parseInt(st.nextToken()); // 공통 부모를 구해야할 node2

            ArrayList<Integer> path1 = new ArrayList<>(); // node1에서 루트 노드로 가는 경로
            ArrayList<Integer> path2 = new ArrayList<>(); // node2에서 루트 노드로 가는 경로

            // 경로에 현재 노드를 추가
            path1.add(node1);
            path2.add(node2);

            // 루트로 가는 경로 찾기
            findPath(node1,path1);
            findPath(node2,path2);

            //경로에 있는 노드를 비교하면서 가장 가까운 공통 부모를 찾는다 (index가 작을수록 depth가 깊은 노드)
            for (int i=0;i<path1.size();i++){
                boolean flag = false; // 가장 가까운 공통 부모를 찾았는지 여부
                int value = path1.get(i);
                for (int j=0;j<path2.size();j++){
                    if (value == path2.get(j)){
                        bw.write(value+"\n");
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    break;
                }
            }

            bw.flush();
        }

        br.close();
        bw.close();
    }

    public static void findPath(int node, ArrayList<Integer> path){
        if (tree[node] == 0) { // 루트 노드일때
            return;
        }
        path.add(tree[node]); // 루트 노드로 가는 경로상에 지나는 노드
        findPath(tree[node], path);
    }
}
