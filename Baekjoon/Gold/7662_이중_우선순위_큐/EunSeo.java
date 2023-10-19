import java.io.*;
import java.util.*;

// BaekJoon 7662 - 이중 우선순위 - KimEunSeo
// 1회차 우선순위큐 2개로 풀었으나 시간초과
public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 데이터 개수

        // 데이터를 저장할때 키값을 기준으로 바로 정렬을 수행하는 TreeMap 사용
        // 첫번째 Integer -> 삽입할 숫자
        // 두번째 Integer -> 삽입한 숫자의 개수, 이미 넣었던 숫자가 또 input 될 수도 있기 때문.

        StringTokenizer st;

        for(int i = 0; i<t; i++){
            int k = Integer.parseInt(br.readLine()); // 연산 횟수 k
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int j = 0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                char operator = st.nextToken().charAt(0); // 연산자
                int num = Integer.parseInt(st.nextToken()); // input할 숫자
                //System.out.println(operator + " " + num);

                if(operator == 'I'){ // 연산자가 I라면 숫자를 삽입해야한다
                    // map에 num을 삽입해준다.
                    // 만약 이미 map에 존재하는 숫자를 input하는 거라면 +1 해준다.
                    map.put(num, map.getOrDefault(num, 0)+1);
                }else { // 연산자가 I가 아닌 D라면
                    if (map.isEmpty()) // 삭제연산이지만 map이 비어있다면 continue
                        continue;
                    else if(num == 1) { // num이 1이면 최대값(lastEntry) 삭제
                        // TreeMap은 Key에 중복값이 저장되지 않기때문에 해줘야하는 과정이다.
                        if (map.get(map.lastKey()) == 1){ // 만약 최대값인 수가 1개 존재할 경우
                            map.remove(map.lastKey()); // remove한다
                        }else{ // 최대값이 1개 이상 존재하면
                            int val = map.get(map.lastKey());
                            map.put(map.lastKey(), val - 1); // 최대값 개수를 -1 해준다.
                        }
                    }
                    else { // num이 -1이면 최소값(firstEntry) 삭제
                        if (map.get(map.firstKey()) == 1){ // 만약 최솟값인 수가 1개 존재할 경우
                            map.remove(map.firstKey()); // remove한다
                        }else{ // 최솟값이 1개 이상 존재하면
                            int val = map.get(map.firstKey());
                            map.put(map.firstKey(), val - 1);
                        }
                    }
                }
            }
            if(map.isEmpty()){ // map이 비어있으면 EMPTY 출력
                System.out.println("EMPTY");
            }else { // map이 비어있지 않다면 최대값 lastKey와 최솟값 firstKey 출력
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }


    }
}