import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class jo-yujin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 정점의 개수
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        for(int i = 0; i <= N; i++) {    // 정점에 해당하는 배열을 생성하여 array에 추가
            array.add(new ArrayList<Integer>());
        }

        StringTokenizer st;
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 연결된 정점을 각 정점에 추가
            array.get(a).add(b);
            array.get(b).add(a);
        }

        int q = Integer.parseInt(br.readLine()); // 질의의 개수
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());   // 질의 유형(1: k번 정점이 단절점인지, 2: k번째 간선이 단절선인지)
            int k = Integer.parseInt(st.nextToken());   // 정점 or 간선

            if(t == 1) {    // 단절점?
                if(array.get(k).size() == 1) // 연결된 정점이 하나일 경우
                    System.out.println("no");
                else
                    System.out.println("yes");
            }
            else {  // 단절선?
                System.out.println("yes");
            }
        }
    }
}
