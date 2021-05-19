import java.io.*;
import java.util.*;
 
public class Brackets {

    public static boolean Check(char a, char b) {
        if(a == '(' && b == ')') 
            return true;
        if(a == '{' && b == '}') 
            return true;
        if(a == '[' && b == ']') 
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("input.txt"));
        String s = sc.nextLine();
        Stack<Character> st = new Stack<Character>();
        char check = 0;

        PrintWriter pw = new PrintWriter("output.txt");
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') 
                st.push(s.charAt(i));
            else {
                if(st.size() ==  0) {
                    pw.write("NO" + "\n" + i);
                    pw.close();
                    return;
                }
                check = st.peek();
                if(Check(check, s.charAt(i))) {
                  st.pop();
                }
                else {
                    pw.write("NO" + "\n" + i);
                    pw.close();
                    return;
                }
            }
        }
        if(!st.empty()) {
            pw.write("NO" + "\n" + s.length());
            pw.close();
            return;
        }
        pw.write("YES");
        pw.close();
    }  
}