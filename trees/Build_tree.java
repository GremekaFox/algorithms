import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Build_tree implements Runnable {
    static class Node {
        int data;
        Node left, right;
    }

    static Node getNode(int data) {
        Node newNode = new Node();

        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    static Node addNode(Node root, int data) {
        if(root == null) {
            root = getNode(data);
            return root;
        }
        if(data < root.data) root.left = addNode(root.left, data);
        if(data > root.data) root.right = addNode(root.right, data);
        return root;
    }

    static Node fullfillBST() {
        Node root = null;
        try(Scanner scan = new Scanner(new File("input.txt"))) {
            while(scan.hasNext()) root = addNode(root, scan.nextInt());
        } catch(Exception e) { e.printStackTrace(); }
        return root;
    }

    static void leftTrav(Node root, PrintWriter out) {
        if (root == null) return;

        out.printf("%d\n", root.data);

        leftTrav(root.left, out);
        leftTrav(root.right, out);
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new  Build_tree(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        Node root = fullfillBST();
        try(PrintWriter out = new PrintWriter(new File("output.txt"))) {
            leftTrav(root, out);
        } catch(Exception e) { e.printStackTrace(); }
    }
}
