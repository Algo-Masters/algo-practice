import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class k_yujin {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        String input;
        int count = 0;

        // 테스트 케이스가 끝날 때까지 루프
        while ((input = br.readLine())!= null){
            if(input.isEmpty()) break;
            count++;
            // 해쉬맵에 포함되어 있으면 카운트 +1
            if(hash.containsKey(input)){
                hash.put(input, hash.get(input)+1);
            }
            // 새로운 key로 카운트는 1
            else{
                hash.put(input,1);
            }
        }

        // 오름차순 정렬
        List<String> keys = new ArrayList<>(hash.keySet());
        keys.sort((s1,s2)-> s1.compareTo(s2) );

        // 정렬된 순서에 따라 비율 계산 후 출력
        for(int i=0; i< keys.size(); i++){
            double ratio = ((hash.get(keys.get(i))/(count*1.0)))*100;
            System.out.println(keys.get(i) +" " + String.format("%.4f", ratio));
        }
    }

}
