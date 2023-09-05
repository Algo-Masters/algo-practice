import java.io.*;
import java.util.Stack;

// 쇠막대기 - 10799

public class yujin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] array = br.readLine().split("");   // 막대기와 레이저 입력 받기
        Stack<String> stack = new Stack<>();    // 스택 생성

        int result = 0;     // 잘려진 조각의 총 개수

        for (int i = 0; i < array.length; i++) {
            if(array[i].equals("(")) stack.push(array[i]);      // 막대기를 스택에 넣기
            else {
                if(array[i-1].equals("(")) {    // 레이저는 ()이기 때문에 현재 )이면서 이전 원소가 (일 경우 레이저로 판단
                    stack.pop();    // 스택에 레이저인 ( 없애기
                    result += stack.size();    // 레이저로 인해 잘려진 조각은 스택에 담긴 막대기 개수
                }
                else {      // 이전의 원소가 (이 아님 -> 막대기의 오른쪽 끝인 )로 판단
                    result++;   // 잘려진 조각의 개수에 1 더해주기
                    stack.pop();    // 막대기 끝났으니 스택에서 꺼내주기
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
