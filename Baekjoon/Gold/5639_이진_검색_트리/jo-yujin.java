// 이진 검색 트리

import java.io.*;

public class jo-yujin {
    public static Node tree;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int root = Integer.parseInt(br.readLine()); // 첫번째 줄 루트노드 입력받기
        tree = new Node(root);  // 트리의 루트노드 설정
        String input = "";

        while((input = br.readLine()) != null && !input.isEmpty()) {
            int data = Integer.parseInt(input); // 한줄씩 노드 입력받기
            addNode(data, tree);
        }   // 전위순회로 트리 만들기

        postOrder(tree);    // 후위순회로 출력
        bw.flush();
        br.close();
        bw.close();
    }
    public static void addNode(int data, Node node) {
        if(node.data > data) {  // 입력받은 노드의 데이터가 부모의 데이터보다 작다 -> 왼쪽
            if(node.left == null) {
                node.left = new Node(data);
                return;
            }
            addNode(data, node.left); // 노드의 왼쪽에 값이 있으면 왼쪽 노드에서 다시 확인하여 추가
        }
        else {  // 입력받은 노드의 데이터가 부모의 데이터보다 크다 -> 오른쪽
            if(node.right == null) {
                node.right = new Node(data);
                return;
            }
            addNode(data, node.right);  // 노드의 오른쪽에 값이 있으면 오른쪽 노드에서 다시 확인하여 추가
        }
    }

    public static void postOrder(Node node) throws IOException {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        bw.write(node.data + "\n");
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}


