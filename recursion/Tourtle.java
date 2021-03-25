import java.io.*;
import java.util.*;

public class Tourtle {
	public static void main(String[] args) throws FileNotFoundException {
        final long e = (int) (Math.pow(10, 9) + 7);
        
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        int m = sc.nextInt();
    
        long cn = 1;
        for (int i = n + m - 2; i >= n; --i) {
            cn = (cn * i) % e;
        }
        long dn = 1;
        for (int i = 1; i < m; ++i) {
            dn = (dn * i) % e;
        }
    
        PrintStream ps = new PrintStream(new File("output.txt"));

        ps.print((cn * Ferma(dn, e - 2, e)) % e);
    }
    
    static long Ferma(long a, long pow, long mod) {
        long m = 1;
        while (pow > 0) {
            if (pow % 2 == 1) {
                m = (m * a) % mod;
            }
            a = (a * a) % mod;
            pow >>= 1;
        }

        return m;
    }
}
