import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최상위 루트 제작 및 설정
        Node firstNode = new Node(Integer.parseInt(br.readLine()));

        // 가장 최신 노드
        Node currentNode = firstNode;

        // 남은 전위 순회 값 입력
        String newInput = "";
        while((newInput = br.readLine()) != null && !newInput.isEmpty()) {
            Node newNode = new Node(Integer.parseInt(newInput));

            inputFrontCheck(firstNode, newNode);
        }

        // 후위순회 출력
        printBackCheck(firstNode);
        bw.flush();
        bw.close();
    }

    public static void inputFrontCheck(Node node, Node newNode) {
        // 현재 노드보다 새로운 노드 값이 작을 경우
        if(node.root > newNode.root) {
            // 왼쪽 노드가 없을 경우, 왼쪽 노드로 설정
            if(node.left == null)
                node.left = newNode;
            // 아닐 경우, 더 깊게 들어가기
            else
                inputFrontCheck(node.left, newNode);
        }
        // 현재 노드보다 새로운 노드 값이 클 경우
        else {
            // 오른쪽 노드가 없을 경우, 오른쪽 노드로 설정
            if(node.right == null)
                node.right = newNode;
            // 아닐 경우, 더 깊게 들어가기
            else
                inputFrontCheck(node.right, newNode);
        }
    }

    public static int printBackCheck(Node node) throws IOException {
        if(node == null) {
            return -1;
        }
        printBackCheck(node.left);
        printBackCheck(node.right);
        bw.write(node.root + "\n");

        return node.root;
    }

    public static class Node {
        public int root;
        public Node left = null;
        public Node right = null;

        public Node(int root) {
            this.root = root;
        }
    }
}