import java.io.*;
import java.util.*;

public class Matrix_smezhn {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int m = sc.nextInt();

        for (int[] i : arr) {
            for (int j : i) {
                j = 0;
            }
        }

        for (int k = 0; k < m; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            arr[i - 1][j - 1] = 1;
            arr[j - 1][i - 1] = 1;
        }

        PrintWriter pw = new PrintWriter("output.txt");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.write((arr[i][j]) + " ");
            }
            pw.write("\n");
        }
        pw.close();
    }
}
