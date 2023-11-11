import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] exp = br.readLine().split("-"); // '-' 기준 나누기
        int sum = Integer.MAX_VALUE;
        for (String op: exp) {
            String[] operands = op.split("\\+");  // '+' 기준 나누기
            int currSum = 0;
            for (int i=0;i< operands.length;i++){
                currSum += Integer.parseInt(operands[i]);
            }
            if (sum == Integer.MAX_VALUE){
                sum = 0;
                currSum *= -1;
            }
            sum -= currSum;
        }

        bw.write(sum+"");
        bw.flush();

        br.close();
        bw.close();
    }
}
