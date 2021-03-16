import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Delete_from_tree implements Runnable {
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}

		public void print(PrintWriter pw) {
			pw.print(data + "\n");
			if(left != null) left.print(pw);
			if(right != null) right.print(pw);
		}
	}

	static class BinSeT {
		static Node addNode(Node root, int data) {
			if(root == null) {
				root = new Node(data);
				return root;
			}
			if(data < root.data) root.left = addNode(root.left, data);
			if(data > root.data) root.right = addNode(root.right, data);

			return root;
		}

		static Node deleteNode(Node root, int data) {
			if(root == null) return root;

			if(data < root.data) root.left = deleteNode(root.left, data);
			if(data > root.data) root.right = deleteNode(root.right, data);

			if(data == root.data) {
				if(root.left == null) return root.right;
				if(root.right == null) return root.left;

				root.data = minVal(root.right);
				root.right = deleteNode(root.right, root.data);
			}
			return root;
		}

		static int minVal(Node root) {
			int minval = root.data;
			while(root.left != null) {
				minval = root.left.data;
				root = root.left;
			}
			return minval;
		}
	}

	public static void main(String[] args) throws IOException {
		new Thread(null, new Delete_from_tree(), "", 64 * 1024 * 1024).start();
	}

	public void run() {
		Node root;

		try(Scanner scan = new Scanner(new File("input.txt"))) {
			int number = scan.nextInt();
			root = new Node(scan.nextInt());

			while(scan.hasNext()) BinSeT.addNode(root, scan.nextInt());

			root = BinSeT.deleteNode(root, number);

			try(PrintWriter out = new PrintWriter(new File("output.txt"))) {
				root.print(out);
			} catch(Exception e) { e.printStackTrace(); }
		} catch(Exception e) { e.printStackTrace(); }
	}
}