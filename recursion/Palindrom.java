import java.io.*;
import java.util.*;

public class Palindrom {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("input.txt"));
        PrintStream ps = new PrintStream(new File("output.txt"));

        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        String st = sb.reverse().toString();
        
        int size = str.length();
        int mx[][] = new int[size + 1][size + 1];


        if(size > 2) {
            for(int i = 1; i < size + 1; i++) {
                for(int j = 1; j < size + 1; j++) {
                    if(str.charAt(i - 1) == st.charAt(j - 1)) {
                        mx[i][j] = mx[i - 1][j - 1] + 1;
                    }
                    else {
                        mx[i][j] = Math.max(mx[i][j - 1] , mx[i - 1][j]);
                    }
                }
            }

            ps.print(mx[size][size] + "\n");
            int i = size;
            int j = size;
            while(mx[i][j] > 0) {
                while(mx[i][j] == mx[i][j - 1])
                    j--;
                if(str.charAt(i - 1) == st.charAt(j - 1)) {
                    ps.print(str.charAt(i - 1));
                    j--;
                    i--;
                }
                else{
                    i--;
                }
            }
        }

        if (size == 0) {
            ps.print("0\n");
        }
        else if (size == 1) {
            ps.print("1\n");
            ps.print(str);
        }
        else if (size == 2) {
            if (str.charAt(0) != str.charAt(1)) {
                ps.print("1\n");
                ps.print(str.charAt(0));
            } 
            else {
                ps.print("2\n");
                ps.print(str.charAt(0));
                ps.print(str.charAt(1));
            }
        }
    }
}
