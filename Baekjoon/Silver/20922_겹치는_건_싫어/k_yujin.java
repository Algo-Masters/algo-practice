import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_겹치는_건_싫어 {
    public final static int MAX_NUM = 200000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String [] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue [] numPos = new LinkedList[MAX_NUM + 1];
        int [] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        // 숫자 배열 입력
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start_idx = 0;
        int end_idx = 0;

        int result = 1;
        int count = 0;

        while(end_idx < N){
            int curNum = nums[end_idx];
            count++;

            if(numPos[curNum] == null){
                numPos[curNum] = new LinkedList();
            }
            numPos[curNum].add(end_idx);

            // 중복 개수 확인
            if(numPos[curNum].size() > K){
                result = Math.max(result, count -1);
                // 중복 개수 초과 - 중복 숫자가 나온 처음 위차 +1로 이동
                while(start_idx++ < (int) numPos[curNum].peek() +1){
                    numPos[nums[start_idx]].poll();
                    count--;
                }
            }
            else{
                result = Math.max(result, count);
            }
            end_idx++;
        }
        System.out.println(result);
    }
}
