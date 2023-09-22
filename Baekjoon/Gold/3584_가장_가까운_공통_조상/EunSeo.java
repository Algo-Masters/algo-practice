import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visit;
    static int[] parentNode;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t = 0; t<T; t++){
            n = Integer.parseInt(br.readLine()); // 노드의 수
            visit = new boolean[n+1]; // 방문 처리를 위한 배열 visit
            parentNode = new int[n+1];

            for(int i = 1; i<n; i++){ // 연결 정보 입력
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parentNode[b] = a; // 배열 인덱스 = 배열 값 노드의 자식 노드
            }

            st = new StringTokenizer(br.readLine());
            int find1 = Integer.parseInt(st.nextToken()); // 공통 부모를 찾을 노드들
            int find2 = Integer.parseInt(st.nextToken());
            findParentNode(find1, find2);
        }

    }
    static void findParentNode(int node1, int node2){
        while(node1 > 0){ // node1 < 0 인 경우 루트 노드에 도달한 것
            visit[node1] = true;
            node1 = parentNode[node1]; // node1 의 부모를 다시 node1에 저장하여 while 반복
        }
        while(node2 > 0){ // node2 < 0 인 경우 루트 노드에 도달한 것
            if(visit[node2]){ // 만약 visit[node2] 가 이미 방문 했던 노드일 경우
                // 해당 노드는 node1의 부모 노드고 node1과 node2의 최소 공통 부모 노드다.
                System.out.println(node2);
                break;
            }else{
                node2 = parentNode[node2];
            }
        }

    }
}
