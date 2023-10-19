import java.io.*;
import java.util.*;

// BaekJoon 4358 - 생태학 - KimEunSeo
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float count = 0; // 총 나무 개수
        String tree = br.readLine();
        HashMap<String, Integer> trees = new HashMap<>();
        trees.put(tree, 1); // 제일 첫번째 나무를 넣어준다
        count++;

        while ((tree = br.readLine()) != null) { // br이 없을 때까지 반복
            if (tree.isEmpty()) // 더 이상 입력 받을게 없으면 종료
                break;

            if (trees.containsKey(tree)){ // 다음번 나무가 map에 있는지 확인한다, True면 존재하는 것
                int treeCount = trees.get(tree); // 나무 key를 통해 value 찾기
                trees.put(tree, treeCount+1); // value에 + 1 하여 key에 put 해준다
            }else{ // map에 해당 나무가 없으면 ->  처음 등장한 나무면
                trees.put(tree,1); // map에 value 1로 넣어준다
            }
            count++; // 나무개수 증가
        }

        List<String> keys = new ArrayList<>(trees.keySet()); // map의 key들 가져오기
        Collections.sort(keys); // key 오름차순 정렬

        for(String key : keys){ // 출력을 위한 반복문
            if (key != null) {
                System.out.print(key + " "); // 나무 이름 출력
                System.out.printf("%.4f%n", trees.get(key) / count * 100); // 비율을 소수점 4자리까지 출력
            }
        }
    }
}