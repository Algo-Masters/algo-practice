import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 가장 큰 수, 가장 작은 수를 알아내기 쉽게 treemap 사용 (value는 그 값의 개수)
            TreeMap<Integer, Integer> treeMet = new TreeMap<>();

            int K = Integer.parseInt(br.readLine());

            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String mode = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                // mode가 I일때, tree map에 삽입
                if (mode.equals("I")) {
                    if(treeMet.containsKey(num)) {
                        treeMet.put(num, treeMet.get(num)+1);
                    }
                    else {
                        treeMet.put(num, 1);
                    }
                }

                // mode가 D일 경우, tree map에서 최댓값 및 최솟값 1개만 삭제
                else {
                    // tree map이 비어있지 않을 경우만
                    if (!treeMet.isEmpty()) {
                        // 최댓값 삭제
                        if (num == 1) {
                            int last = treeMet.lastKey();
                            if(treeMet.get(last) == 1) {
                                treeMet.remove(last);
                            }
                            else {
                                treeMet.put(last, treeMet.get(last)-1);
                            }
                        }
                        // 최솟값 삭제
                        else {
                            int first = treeMet.firstKey();
                            if(treeMet.get(first) == 1) {
                                treeMet.remove(first);
                            }
                            else {
                                treeMet.put(first, treeMet.get(first)-1);
                            }
                        }
                    }
                }
            }

            // 비어있을 경우 출력
            if (treeMet.isEmpty()) {
                bw.write("EMPTY\n");
            }
            // 남이 있을 경우 출력
            else {
                bw.write(treeMet.lastKey() + " " + treeMet.firstKey()+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}