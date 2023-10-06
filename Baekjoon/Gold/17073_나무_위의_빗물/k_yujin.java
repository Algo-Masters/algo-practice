import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int rainCount = Integer.parseInt(st.nextToken());

        ArrayList [] edge = new ArrayList[nodeCount+1];

        // 초기화
        for(int i=1; i<=nodeCount; i++){
            edge[i] = new ArrayList<Integer>();
        }

        // 간선 추가
        for(int i=0; i<nodeCount-1; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            edge[v].add(u);
            edge[u].add(v);

        }


        // 말단 노드 구하기
        for(int i = 2; i< edge.length; i++) {
            if (edge[i].size() == 1)
                count++;
        }

        // 출력과 같이 소수점 10자리로 포맷팅
        System.out.println(String.format("%.10f", (double)rainCount/count));

    }



}




