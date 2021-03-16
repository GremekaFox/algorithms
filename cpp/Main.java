import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);

  int n = 0;
  int m = 0;
   long a = 0;
   long b = 0;
   long c = 0;
  scanf("%d %d", &n, &m);
  for(int i = 0; i < n; i++) {
    for(int j = 0; j < m; j++) {
      scanf("%llu", &matr[i][j]);
      if(i > 0) {
        a = j > 0 ? matr[i - 1][j - 1] : INT64_MAX;
        b = matr[i - 1][j];
        c = j < m - 1 ? matr[i - 1][j + 1] : INT64_MAX;
      }
      matr[i][j] += min(a, b, c);
    }
  }

  long long res = matr[n - 1][0];
  for(int j = 1; j < m; j++) res = min(res, matr[n - 1][j]);

  printf("%llu", res);
        
    }
}

const int str = 200;
const int row = 1000;
long long matr[str][row];

long long min(long long a, long long b, long long c) {
  long long min = a;
  if(min > b) min = b;
  if(min > c) min = c;
  return min;
}

int main() {
  
}
