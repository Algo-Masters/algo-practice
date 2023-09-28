import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());

        // 테스트 실행
        for (int t = 0; t < T; t++) {
            // 노드 개수 입력
            int N = Integer.parseInt(br.readLine());

            // 노드가 입력됬는지 체크하기 위한 맵
            HashMap<Integer, Node> trees = new HashMap<>();

            // 트리 간선 입력 (부모 자식 관계 입력)
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                // 부모 노드가 입력받았던 적 있는 경우, 노드 가져오기
                // 없는 경우, 최상위 노드 취급하여 생성
                Node a;
                if (trees.containsKey(A)) {
                     a = trees.get(A);
                } else {
                    a = new Node(null, A);
                    trees.put(A, a);
                }

                // 자식 노드가 입력받았던 적 있는 경우, 노드 가져와서 부모 노드만 새로 등록
                // 없는 경우, 부모노드의 자식으로 생성
                if(trees.containsKey(B)) {
                    Node b = trees.get(B);
                    b.parent = a;
                }
                else {
                    trees.put(B, new Node(a, B));
                }
            }

            // 비교 군 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node first = trees.get(Integer.parseInt(st.nextToken()));
            Node second = trees.get(Integer.parseInt(st.nextToken()));

            // 두 노드의 트리 깊이가 같을 때까지 비교
            while(first.getDepth() != second.getDepth()) {
                if(first.getDepth() > second.getDepth())
                    first = first.parent;
                else
                    second = second.parent;
            }

            // 두 노드의 깊이가 같아졌으므로, 부모가 같을 때까지 둘 다 부모 노드로 이동
            while(first.current != second.current) {
                first = first.parent;
                second = second.parent;
            }

            // 부모 노드가 같아졌으므로 부모노드 출력
            bw.write(first.current + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static class Node {
        int current;
        Node parent;

        public Node(Node parent, int current) {
            this.parent = parent;
            this.current = current;
        }

        // 깊이를 알아내는 함수
        public int getDepth() {
            if(parent != null) {
                return parent.getDepth()+1;
            }
            else return 0;
        }
    }
}