import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Sum_nodes {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> sum = new HashSet<Integer>();
        Files.lines(Paths.get("input.txt"), StandardCharsets.UTF_8).forEach(item -> sum.add(Integer.parseInt(item)));
        double res = 0;
        for(Integer item : sum) res += item;
        FileWriter fw = new FileWriter("output.txt");
        String str = String.format("%.0f", res);
        fw.write(str);
        fw.close();
    }  
}