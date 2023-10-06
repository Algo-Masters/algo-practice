import java.util.*;
import java.io.*;

public class Main  {

    static ArrayList<Integer>[] list;
    static int leaf = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드의 수
        int w = Integer.parseInt(st.nextToken()); // 고인 물의 양

        list = new ArrayList[n+1];
        for(int i = 1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        // 트리 연결정보 입력받음
        for(int i = 0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        // 정점에서 물을 흘려주기 때문에
        // 리프 노드 검사는 정점 다음 노드 부터 확인
        for(int i = 2; i<list.length; i++){
            if(list[i].size() == 1)
                leaf += 1;
        }

        // 소수점 10번째 자리까지 출력하는것에 주의
        System.out.println(String.format("%.10f", (double)w/leaf));

    }
}