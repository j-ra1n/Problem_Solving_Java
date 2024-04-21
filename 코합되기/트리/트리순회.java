import java.util.*;

public class 트리순회 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nodes = new int[n];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = sc.nextInt();
        }

        String[] result = new String[3];

        result[0] = preorder(nodes, 0).trim(); // 마지막 공백제거
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();

        System.out.print(Arrays.toString(result));
    }

    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return nodes[idx] + " " + preorder(nodes, 2 * idx + 1) + preorder(nodes, 2 * idx + 2);
    }

    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return inorder(nodes, 2 * idx + 1) + nodes[idx] + " " + inorder(nodes, 2 * idx + 2);
    }

    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return postorder(nodes, 2 * idx + 1) + postorder(nodes, 2 * idx + 2) + nodes[idx] + " ";
    }
}
