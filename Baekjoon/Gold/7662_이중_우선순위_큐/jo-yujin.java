// 이중 우선순위 큐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class jo-yujin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int K;
        String operator = "";
        int n = 0;

        for(int i = 0; i < T; i++){
            K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap();

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                operator = st.nextToken();
                n = Integer.parseInt(st.nextToken());

                if(operator.equals("I")) {  // I
                    map.put(n, map.getOrDefault(n, 0) + 1);     // 중복된 key일 경우 값에 + 1 를 더해준다.
                }
                else { // D
                    if(map.isEmpty())
                        continue;

                    int key = n == 1 ? map.lastKey() : map.firstKey();  // 1이면 최댓값, -1이면 최솟값의 키 가져온다.
                    int count = map.get(key);   // key가 저장된 개수

                    if (count == 1) {   // 중복되어 저장되지 않은 경우 key를 제거한다.
                        map.remove(key);
                    }
                    else {  // 중복되어 저장돼있는 경우 값에 -1을 해준다.
                        map.put(key, count - 1);
                    }
                }
            }
            if(map.isEmpty())     // 비어있을 경우
                System.out.println("EMPTY");
            else
                System.out.println(map.lastKey() + " " + map.firstKey());   // 최댓값 최솟값 출력
        }

    }
}
