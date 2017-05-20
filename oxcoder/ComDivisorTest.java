public class ComDivisorTest {
    public static void main(String[] args) {
        int a ,b,m;
        a = 90;
        b = 9;
        deff cd = new deff();
        m = cd.deff(a,b);
        int n = a * b / m;
        System.out.println("最大公约数: " + m);
        System.out.println("最小公倍数: " + n);
    }
}
class deff{

    public int deff(int x, int y) {
        int t;
        //No.1
        //开始写代码




        while(y != 0)
        {
            t = y;
            y = x % y;
            x = t;
        }
        return x;



        //end_code
    }

}