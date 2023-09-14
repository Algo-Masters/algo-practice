import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> pq = new TreeMap<>(); // 우선순위 큐(맵으로 구현)

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Character cmd = st.nextToken().charAt(0); // 명령어
                int value = Integer.parseInt(st.nextToken()); // 값

                switch(cmd){
                    case 'I':
                        if (pq.containsKey(value)){
                            pq.put(value, pq.get(value) + 1);
                        }
                        else {
                            pq.put(value, 1);
                        }
                        break;

                    case 'D':
                        if (!pq.isEmpty()){
                            int target; // 지워질 값

                            if (value == -1) { 
                                target = pq.firstKey(); // 가장 작은 수
                            }
                            else { 
                                target = pq.lastKey(); // 가장 큰 수
                            }

                            if (pq.get(target) == 1){ // 중복 값이 없을 때 맵에서 삭제
                                pq.remove(target);
                            }
                            else {
                                pq.put(target, pq.get(target) - 1);
                            }
                        }
                        break;
                }
            }
            if (!pq.isEmpty()){
                bw.write(pq.lastKey()+" "+pq.firstKey()+"\n");
            }
            else {
                bw.write("EMPTY\n");
            }
        }

        bw.flush(); // 결과 출력
        br.close();
        bw.close();
    }
}
