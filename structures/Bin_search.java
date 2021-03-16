import java.io.*;
import java.util.*;

public class Bin_search {
    public static void main(String[] args) throws IOException {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        int k = sc.nextInt();

        int z;
        for(int i = 0; i < k; i++){
            z = sc.nextInt();
            System.out.println(search(arr, n, z) + " " + lower(arr, n, z) + " " + upper(arr, n, z));
        }
    }
    
    static int lower(int[] arr, int lengh, int elem) {
        int l = 0;
        int k = 0;
        int r = lengh;
        while(l < r) {
            k = (l + r) / 2;
            if(elem <= arr[k]){
                r = k;
            }
            else{
                l = k + 1;
            }
        }
        return l;
    }
    
    static int upper(int[] arr, int lengh, int elem) {
        int l = 0;
        int k = 0;
        int r = lengh;
        while(l < r) {
            k = (l + r) / 2;
            if(elem < arr[k]){
                r = k;
            }
            else{
                l = k + 1;
            }
        }
        return l;
    }


    static int search(int[] arr, int lengh, int elem) {
        int l = 0;
        int k = 0;
        int r = lengh;
        while(l < r) {
            k = (l + r) / 2;
            if(elem == arr[k]) return 1;
            if(elem < arr[k]){
                r = k;
            }
            else{
                l = k + 1;
            }
        }
        return 0;
    }
}
