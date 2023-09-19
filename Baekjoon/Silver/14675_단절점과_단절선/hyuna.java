import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 q14675 - 단절점과 단절선
public class Main {
    public static int N, q;
    public static ArrayList<ArrayList<Integer>> links = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 정점의 개수
        for(int i=0;i<=N;i++){
            links.add(new ArrayList<Integer>());
        }

        for(int i=0;i<N-1;i++){ // 간선 정보
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            links.get(a).add(b);
            links.get(b).add(a);
        }

        q = Integer.parseInt(br.readLine()); // 질의의 개수
        for(int i=0;i<q;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken()); // 질의 유형
            int k = Integer.parseInt(st.nextToken()); // k번째 정점/간선

            switch (t){
                case 1: // 단절점인지
                    if(links.get(k).size()==1){
                        // 연결된 정점 개수가 1개인 경우
                        bw.write("no\n");
                    }
                    else{
                        bw.write("yes\n");
                    }
                    break;
                case 2: // 단절선인지
                    // 간선을 끊으면 무조건 2개 이상의 그래프로 나뉨
                    bw.write("yes\n");
                    break;
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
