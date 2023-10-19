import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수 입력
        String s = br.readLine();

        int result = 0;

        // - 로 문자를 분리
        String [] minusNum = s.split("-");

        // 해당 문자열 수만큼 반복
        for(int i=0;i<minusNum.length;i++) {
            // + 로 문자를 분리
            String [] plusNum = minusNum[i].split("\\+");

            int sum = 0;
            // 해당 문자열 수만큼 반복
            for(int j=0;j<plusNum.length;j++) {
                // 모두 더한다
                sum += Integer.parseInt(plusNum[j]);
            }
            // index가 0일 경우에는 result가 더한 값
            if(i == 0)
                result = sum;
                // index가 0 이상일 경우에는 result에서 sum값을 뺀다.
            else
                result -= sum;
        }

        System.out.println(result);

    }
}