import java.util.*;
import java.io.*;

public class Main  {
    static class Node{

        int node;
        Node left;
        Node right;
        Node(int node){
            this.node = node;
        }
        void insert(int node){
            if(node < this.node) // 현재 노드보다 매개변수 노드 값이 작은 경우
                if(this.left == null) // 현재 노드의 left가 null인 경우
                    this.left = new Node(node); // 매개변수 노드를 현재 노드의 left로 생성
                else // 현재 노드의 left가 null이 아니면
                    this.left.insert(node); // 현재 노드의 left에 insert
            else // 현재 노드보다 매개변수 노드가 큰 경우
                if(this.right == null) // 현재 노드의 right가 null인 경우
                    this.right = new Node(node); // 매개변수 노드를 현재 노드의 right로 생성
                else  // 현재 노드의 right가 null이 아니면
                    this.right.insert(node); // 현재 노드의 right에 insert
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        Node node = new Node(Integer.parseInt(br.readLine()));
        while(true){
            str = br.readLine();
            if(str == null || str.equals("")) // 더 이상 입력이 없으면 반복문 종료
                break;

            node.insert(Integer.parseInt(str)); // Node class에 입력값 삽입
        }
        postOrder(node);
    }
    static void postOrder(Node node){ // 후위순회(왼-오-루트)
        if(node == null)
            return;

        postOrder(node.left); // 왼쪽
        postOrder(node.right); // 오른쪽
        System.out.println(node.node); // 루트
    }
}