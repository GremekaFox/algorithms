import java.io.*;
import java.util.*;

public class Roads_1 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner("input.txt");
        int n = fs.nextInt();
        int m = fs.nextInt();
        Roads b = new Roads(n);

        StringBuilder str = new StringBuilder();
        int x,y;
        for (int i = 0; i < m; i++) {
            x = fs.nextInt();
            y = fs.nextInt();
            b.Union(x,y);
            str.append(b.get_k()).append("\n");
        }

        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.write(str.toString());
        out.close();
    }
}


class Roads {
    int[] size;
    int[] edge;
    int k;

    public Roads(int n){
        this.size = new int[n];
        this.edge = new int[n];

        for(int i = 0; i < n; i++) {
            this.size[i] = 1;
            this.edge[i] = i + 1;
        }
        this.k = n;
    }

    public int find_parent(int x) {
        if(edge[x - 1] == x) {
            return -1;
        }
        return edge[x - 1];
    }
    
    public int find_set(int x) {
        if (x == edge[x - 1])
            return x;
        return edge[x - 1] = find_set(edge[x - 1]);
    }

    public void Union(int x, int y) {
        int x_lead = find_set(x);
        int y_lead = find_set(y);
        if (x_lead != y_lead) {
            if(size[x_lead - 1] < size[y_lead - 1]) {
                int tmp = x_lead;
                x_lead = y_lead;
                y_lead = tmp;
                tmp = x;
                x = y;
                y = x;
            }

            edge[y_lead - 1] = x_lead;
            size[x_lead - 1] += size[y_lead - 1];
            while (find_parent(x) != -1) {
                size[x - 1] += size[y_lead - 1];
                x = find_parent(x);
            }
            k--;
        }
    }

    public int get_k() {
        return this.k;
    }
}

class FastScanner {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public FastScanner(String fileName) throws IOException {
        reader = new BufferedReader(new FileReader(fileName));
    }

    public String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = reader.readLine();
            if (line == null) {
                throw new EOFException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public Long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}