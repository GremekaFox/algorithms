import java.io.*;
import java.util.*;

public class BFS {

    static int stop = 1;

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

        ArrayDeque<Integer> deq = new ArrayDeque<>();
        
            for (int i = 0; i < n; i++) {
                if (flag[i] == 0) {
                   flag[i] = stop++;
                    deq.add(i);
                }
                while (!deq.isEmpty()) {    
                    int tmp = deq.pop();
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (flag[j] == 0 && matrix[tmp][j] == 1) {
                            flag[j] = stop++;
                            deq.add(j);
                      
                        }
                    }
                }
            }

        PrintWriter pw = new PrintWriter("output.txt");
        for (int i : flag) {
          pw.write(i + " ");  
        } 
        pw.close();
    }
}