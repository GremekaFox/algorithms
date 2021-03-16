import java.util.*;

public class Ones {
	public static void main(String[] args) {
        final long m = (int) (Math.pow(10, 9) + 7);
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
    
        long cn = 1;
        for (int i = N; i > N - K; --i) {
            cn = (cn * i) % m;
        }
        long dn = 1;
        for (int i = 1; i <= K; ++i) {
            dn = (dn * i) % m;
        }
    
        System.out.println((cn * Ferma(dn, m - 2, m)) % m);
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
