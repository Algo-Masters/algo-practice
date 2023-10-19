// 생태학

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class jo-yujin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new TreeMap<>();

        String str = "";
        Double count;
        Double totalCount = 0.0;
        while(true) {
            str = br.readLine();
            if(str == null || str.length() == 0)
                break;

            if(map.containsKey(str)) {    // 이미 값이 존재할 경우
                count = map.get(str) + 1;
                map.put(str, count);
            }
            else {  // 존재하지 않을 경우
                map.put(str, 1.0);
            }
            totalCount++;
        }
        for(Map.Entry<String, Double> entry: map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(" " + String.format("%.4f", entry.getValue() / totalCount * 100));
        }

    }
}
