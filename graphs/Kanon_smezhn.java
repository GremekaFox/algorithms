import java.io.*;
import java.util.*;

public class Kanon_smezhn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));  

        String line;
        int n = Integer.parseInt(line = br.readLine());
        int m = 0;
    
        int arr1[] = new int[n];
        int arr2[][] = new int[n][n];
        String s[] = new String[n];

        while ((line = br.readLine()) != null) {
            s = line.split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.valueOf(s[i]);
            }
            for (int j = 0; j < n; j++) {
                arr2[m][j] = arr1[j];
            }
            m++;
        }

        PrintWriter pw = new PrintWriter("output.txt");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr2[j][i] == 1) {
                    pw.write((j + 1) + " ");
                    break;
                }
                if (j == n - 1) {
                    pw.write("0 ");
                }
                
            }
        }
        pw.close();
    }
}