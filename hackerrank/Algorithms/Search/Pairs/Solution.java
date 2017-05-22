import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int pairs(int[] a,int k) {
        int c = 0;
        int min = a[0];
        for(int i = 0;  i < a.length; i++) {
            if(min>a[i]) min=a[i];
        }
        int max = a[0];
        for(int i = 0;  i < a.length; i++) {
            if(max<a[i]) max=a[i];
        }
        int[] ak = new int[a.length];
        int[] sk = new int[a.length];
        byte[] f = new byte[max-min+1];//min as 0
        for(int i = 0;  i < a.length; i++) {
            ak[i] = a[i]+k;
            sk[i] = a[i]-k;
        }
        for(int i = 0;  i < a.length; i++) {
            f[a[i] - min  ] = 1;
        }
        for(int i = 0;  i < ak.length; i++) {
            if(ak[i] - min >=0&&ak[i] - min <f.length&&  f[ak[i] - min ] >=1) {
//                f[ak[i] - min ] ++;
                c++;
            }
        }
        for(int i = 0;  i < sk.length; i++) {
            if(sk[i] - min >=0&&sk[i] - min <f.length&&  f[sk[i] - min ] >=1) {
//                f[sk[i] - min ]++;
                c++;
            }
        }



        return c/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}
