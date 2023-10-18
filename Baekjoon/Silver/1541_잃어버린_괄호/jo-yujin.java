// 잃어버린 괄호

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class jo-yujin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int result = 0; // 값의 최소가 될 결과

        String[] splitByMinus = input.split("-");   // -를 기준으로 분리

        for(int i = 0; i < splitByMinus.length; i++) {
            String[] splitByPlus = splitByMinus[i].split("\\+"); // - 분리 -> + 분리
            int plusSum = 0;    // +로 분리된 숫자들을 더할 변수
            for(int j = 0; j < splitByPlus.length; j++) {
                plusSum += Integer.parseInt(splitByPlus[j]); // 더해준다.
            }

            if(i == 0) {
                result = plusSum;
            } else {
                result -= plusSum;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        br.close();
        br.close();
    }
}
