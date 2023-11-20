import java.io.*;
import java.util.StringTokenizer;

public class BOJ_가장긴짝수연속한부부수열 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String [] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start =0; int end = 0;
        int length = 0; int odd_count =0;
        int result = 0;

        // 홀수이면 k++, 짝수이면 count++,
        while(end < N){
            if(nums[end] %2 ==0){
                length++;
            }
            else{
                odd_count++;
            }

            end++;
            result = Math.max(result, length);
            if(odd_count <= K)
                continue;

            // 초과 -가장 처음 만나는 홀수 제외
            while(true){
                if(nums[start] %2 != 0){
                    odd_count--;
                    start++;
                    break;
                }
                else{ // 짝수
                    start++;
                    length--;
                }

            }
        }

        System.out.println(result);
    }
}
