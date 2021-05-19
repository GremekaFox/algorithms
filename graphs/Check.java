import java.io.*;
import java.util.*;

public class Check {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(new File("input.txt"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n + 1][n + 1];

		boolean a = false;
		boolean b = false;

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (x == y) {
				a = false;
				b = true;
				break;
			}
			
			if (arr[x][y] == 1 || arr[y][x] == 1) {
				a = true;
				b = true;
			}			
			
			arr[x][y] = arr[y][x] = 1;
		}

		PrintWriter pw = new PrintWriter("output.txt");

		if (a == false && b == false) {
			pw.write("Yes" + "\nYes" + "\nYes");
		}
		else if(a == true || b == true) {
			pw.write("No");
			
			if (a == true) {
				pw.write("\nYes");
			}
			else 
				pw.write("\nNo");

			if (b == true) {
				pw.write("\nYes");
			}
			else
				pw.write("\nNo");
		}
		pw.close();
	}
}