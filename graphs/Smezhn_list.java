import java.io.*;
import java.util.*;

public class Smezhn_list {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();

        List[] arr = new List[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        while (sc.hasNext()) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            arr[j - 1].add(k);
            arr[k - 1].add(j);
        }

        PrintWriter pw = new PrintWriter(new File("output.txt"));
        for (int i = 0; i < n; i++) {
            arr[i].add(0, arr[i].size());
            for (Object j : arr[i]) {
                pw.print(j + " ");
            }
            pw.println();
        }
        pw.close();
    }
}