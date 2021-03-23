import java.io.*;
import java.util.*;

public class Bin_heap {
    public static void main(String[] args) throws FileNotFoundException {

        int n;
        int[] arr;

        try (Scanner sc = new Scanner(new FileReader("input.txt"))) {
            n = sc.nextInt();
            arr = new int[n + 1];
            int i = 1;
            while (sc.hasNext()) {
                arr[i] = sc.nextInt();
                i++;
            }
        }

        try (PrintWriter pw = new PrintWriter(new File("output.txt"))){
            for (int i = n; i >= 2;) {
                if (arr[i] >= arr[i / 2]) 
                i--;
                else {
                    pw.print("No");
                    pw.close();
                    System.exit(0);
                }
            }
            pw.print("Yes");
            pw.close();
        }
    }
}