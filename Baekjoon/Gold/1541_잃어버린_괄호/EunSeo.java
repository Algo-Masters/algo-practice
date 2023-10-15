import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] SplitBySub = str.split("-"); // -를 기준으로 문자열 분리
        int result = Integer.MAX_VALUE;

        for(int i = 0; i<SplitBySub.length; i++){
            String[] SplitByAdd = SplitBySub[i].split("\\+"); // 다시 분리된 문자열들을 + 를 기준으로 분리
            int SplitSum = 0;
            for(int j = 0; j<SplitByAdd.length; j++){
                SplitSum += Integer.parseInt(SplitByAdd[j]); // +를 기준으로 분리된 문자열들을 전부 더함
            }
            if(result == Integer.MAX_VALUE){ // 수식에서 첫번째로 등장하는 양수라면
                result = SplitSum;
            }else{ // 이후 등장하는 양수라면
                result -= SplitSum; // 전부 빼준다
            }

        }
        System.out.println(result);

    }
}