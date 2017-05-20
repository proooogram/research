abstract class AbstractDisplay {
    public abstract void print();

    public final void display() {
        print();
    }
}
//No.1
//开始写代码，用模板模式实现输出一个字符和输出一个字符串，请自行构造CharDisplay类和StringDisplay类
class CharDisplay extends AbstractDisplay{
    private char c;

    CharDisplay(char c){
        this.c = c;
    }
    @Override
    public void print() {
        System.out.println(c);
    }
}

class StringDisplay extends AbstractDisplay{

    private String s;

    public StringDisplay(String s) {
        this.s= s;
    }

    @Override
    public void print() {
        System.out.println(s);
    }
}


//end_code
public class TemplateTest {
    public static void main(String[] args) {
        AbstractDisplay abstractDisplayChar = new CharDisplay('A');
        AbstractDisplay abstractDisplayString = new StringDisplay("Hello World");
        abstractDisplayChar.display();
        abstractDisplayString.display();
    }
}

//用java代码实现模板模式，准备一个抽象类，将部分逻辑以具体方法以及具体构造子类的方式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑。