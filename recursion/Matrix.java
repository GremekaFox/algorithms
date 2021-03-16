import java.util.*;
import java.io.*;

public class Matrix {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        PrintStream ps = new PrintStream(new File("output.txt"));

		int[] arr = new int[n + 1];

		for (int i = 0; i < n; i++){
		    arr[i] = sc.nextInt();
			if (i != n - 1)
				sc.nextInt();
		}   

        arr[n] = sc.nextInt();

		int[][] res = new int [n + 1][n + 1];
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++){
				int k = j + i - 1;
				res[j][k] = 2147483647;
                
				for (int l = j; l <= k - 1; l++){
					res[j][k] = Math.min(res[j][k], res[j][l] + res[l + 1][k] + arr[j - 1] * arr[l] * arr[k]);
				}
			}
		}

        ps.println(res[1][n]);
	}
}
