import java.io.*;

public class Main {

    public static class Node {
        int value;
        Node left, right;

        public Node (int value) {
            this.value = value;
        }
    }

    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String input = "";
        while((input = br.readLine()) != null && !input.equals("")) { // 입력받기
            insert(Integer.parseInt(input), root);
        }

        postOrder(root);

        bw.flush();
        br.close();
        bw.close();
    }

    public static void insert(int n, Node root) {

        if (n < root.value) { // 부모 노드보다 n 값이 작을 때
            if (root.left == null) {
                root.left = new Node(n); // 왼쪽 노드로 삽입
            }
            else {
                insert(n, root.left);
            }
        }
        else {// 부모 노드보다 n 값이 클 때
            if (root.right == null) {
                root.right = new Node(n); // 오른쪽 노드로 삽입
            }
            else {
                insert(n, root.right);
            }
        }
    }

    public static void postOrder(Node root) throws IOException { // 후위순회 (왼->오->루트)
        if (root.left != null){
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        bw.write(root.value+"\n");
    }

}
