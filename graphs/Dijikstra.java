import java.io.*;
import java.util.*;

public class Dijikstra {
    public static void main(String[] args) throws IOException {
        Scanner fs = new Scanner("input.txt");
        int n = fs.nextInt();
        int m = fs.nextInt();
        ArrayList<ArrayList<Graf_ver>> matr = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            matr.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int u = fs.nextInt()-1;
            int v = fs.nextInt()-1;
            long w = fs.nextLong();

            matr.get(u).add(new Graf_ver(v, w));
            matr.get(v).add(new Graf_ver(u, w));
        }



        Comparator<Graf_ver> cmp = new Comparator<Graf_ver>() {
            @Override
            public int compare(Graf_ver o1, Graf_ver o2) {
                if (o1.w < o2.w) {
                    return -1;
                } else if (o1.w > o2.w) {
                    return 1;
                }

                return 0;
            }
        };

        write(distances(matr,0,n,m,cmp));
    }

    public static void write (long num) {
        try {
            try (PrintWriter out = new PrintWriter(new File("output.txt").getAbsoluteFile())) {
                out.write(String.valueOf(num));
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long distances(ArrayList<ArrayList<Graf_ver>> matr, int start, int n, int m, Comparator<Graf_ver> cmp){
        if(m==0) return 0;
        Queue<Graf_ver> q = new PriorityQueue<>(m, cmp);
        boolean[] processed = new boolean[n];

        long[] dist = new long[n];
        for(int i=1; i<n; i++)
            dist[i]=Long.MAX_VALUE;

        q.add(new Graf_ver(start, 0L));
        while (!q.isEmpty()){
            Graf_ver t = q.poll();

            if(processed[t.u]){
                continue;
            }


            processed[t.u] = true;
            dist[t.u] = t.w;

            for (int i=0; i<matr.get(t.u).size(); i++){
                if(matr.get(t.u).get(i).w + t.w > t.w)
                    q.add(new Graf_ver(matr.get(t.u).get(i).u, matr.get(t.u).get(i).w + t.w));
            }

        }

        //System.out.println(dist[n-1]);
        return dist[n-1];
    }

}


class Graf_ver{
    int u;
    long w;

    public Graf_ver(int a, long b){
        this.u=a;
        this.w=b;
    }

}