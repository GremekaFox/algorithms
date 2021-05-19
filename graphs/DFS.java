import java.io.*;
import java.util.*;

public class DFS {

    static int stop = 1;

    static void dfs(int matrix[][], int flag[], int i) {
        for (int j = 0; j < matrix[i].length; j++){
            if (matrix[i][j] == 1 && flag[j] == 0) {
                flag[j] = stop++;
                dfs(matrix, flag, j);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(new File("input.txt"));
        int n = scan.nextInt();
        int matrix[][] = new int[n][n];
        int flag[] = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < n; i++)
            if (flag[i] == 0) {
                flag[i] = stop++;
                dfs(matrix, flag, i);
            }

        PrintWriter pw = new PrintWriter("output.txt");
        for (int i : flag) {
            pw.write(i + " ");  
        } 
        pw.close();
    }        
}
