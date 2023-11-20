import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드 수(N)와 고인 물의 양(W) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // 간선 정보 변수
        ArrayList<Integer>[] lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        // N-1 개의 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            lists[u].add(v);
            lists[v].add(u);
        }

        // 최하단 리프 개수
        double count = 0;

        for (int i = 2; i <= N; i++) {
            if(lists[i].size() == 1) {
                count++;
            }
        }

        // 물이 멈췄을 경우는 모든 물이 최하단 리프에만 있음을 의미
        // 즉, (고인 물의 양 / 최하단 리프 개수) 출력
        System.out.println(String.format("%.4f", (double) W/count));
    }
}

