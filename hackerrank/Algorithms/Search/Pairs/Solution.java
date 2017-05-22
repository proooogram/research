import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**

a : 1 5 3 4 2
k : 2
求数组a中两元素差的绝对值为k, 符合条件的元素对个数

-k:		-1		3		1		2		0		:  ak: add k
a : 		 1		5		3		4		2
+k:		 3		7		5		6		4		:  sk : substract k 

找ak和a中相同元素, 找sk和a中相同元素,  个数相加
同样的被重复了一次,    所以除以2, 得到结果

将a 反转为f:  a的内容作为f的下标, f的内容表示标记这里有a的一个元素   ：  
	注意，由于a起点可能比较大， 所以要将a统统减速a的最小元素min，这样f尽可能小、尽可能密集.   
然后ak到f中查找, sk到f中查找, 计数

注意: 如果两层循环遍历的话 消耗时间不符合hackerrank的要求
样本16是此方案的陷进， ：  a非常分散， 总共只有10个元素，直接内存不够, 
就到这了
*/
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
