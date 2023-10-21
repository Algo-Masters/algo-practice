import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수열의 크기(N) 입력
        int N = Integer.parseInt(br.readLine());

        // 수열 입력
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // nodes 배열은 nums[i]와 i부터 수열을 시작했을 때 최장 수열 len을 기록
        ArrayList<Node> nodes = new ArrayList<>();

        // 뒤에서부터 최장 수열 길이 확인
        for (int i = N - 1; i >= 0; i--) {
            int len = 0;

            // nodes에 있는 sum 값들을 통해 현재 값의 최장 수열 길이 알아내기
            for (int j = nodes.size() - 1; j >= 0; j--) {
                Node node = nodes.get(j);

                // 만약 현재 수가 해당 node의 수보다 크고 sum도 해당 수보다 클 경우 -> sum 변경
                if (node.num > nums[i] && len < node.sum)
                    len = node.sum;
            }
            // nodes 배열에 추가
            nodes.add(new Node(nums[i], len + nums[i]));
        }

        // nodes 배열을 len 길이 순으로 내림차순 나열
        Collections.sort(nodes);

        // 가장 큰 len 출력
        int result = nodes.get(0).sum;

        bw.write(result + "\n");
        bw.flush();
        bw.close();

    }

    public static class Node implements Comparable<Node> {
        public int num;
        public int sum;

        public Node(int num, int sum) {
            this.num = num;
            this.sum = sum;
        }

        @Override
        public int compareTo(Node n) {
            return n.sum - this.sum;
        }
    }
}