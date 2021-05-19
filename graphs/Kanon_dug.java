import java.io.*;
import java.util.*;

public class Kanon_dug {
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("input.txt"));
        int n = scan.nextInt();
        int arr[] = new int[n];

        while (scan.hasNext()) {
            int root = scan.nextInt();
            arr[scan.nextInt() - 1] = root;
        }
    
        PrintWriter pw = new PrintWriter("output.txt");
        for (int i = 0; i < n; i++) {
            String text = String.valueOf(arr[i]);
            pw.write(text + " ");
        }
        pw.close();
    }
}