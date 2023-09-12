import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tree;

        double total = 0; // 전체 나무 수
        HashMap<String, Integer> trees = new HashMap<>(); // 나무 이름, 개수
        while ((tree = br.readLine()) != null && !(tree.isEmpty())) {
            total++;
            if (!trees.containsKey(tree)) {
                trees.put(tree, 1);
            }
            else {
                trees.put(tree, trees.get(tree) + 1);
            }
        }

        List<String> keyList = new ArrayList<>(trees.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2)); // 키 값에 대해 정렬

        for (String key: keyList){
            String result = String.format("%.4f", trees.get(key)/total*100);
            bw.write(key+" "+result+"\n");
        }

        bw.flush(); // 결과 출력

        br.close();
        bw.close();
    }
}
