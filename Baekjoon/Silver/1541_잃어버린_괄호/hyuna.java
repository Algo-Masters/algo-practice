import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine(); // 식

        int num = 0;
        int tmpNum = 0;
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if(Character.isDigit(ch)){ // 숫자인 경우
                num *= 10;
                num += Integer.parseInt(Character.toString(ch));
            }
            else{ // +,-인 경우
                tmpNum += num;
                if(ch == '-'){ // -인 경우
                    dq.addLast(tmpNum);
                    tmpNum = 0;
                }
                num = 0;
            }
        }
        dq.addLast(tmpNum+num);

        int ans = dq.pollFirst();
        while(!dq.isEmpty()){
            ans -= dq.pollFirst();
        }

        bw.write(Integer.toString(ans)+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}