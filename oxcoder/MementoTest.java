import java.io.Serializable;

class Originator {
    public String sentence;

    public Originator(String sentence) {
        this.sentence = sentence;
    }

    public void setString(String sentence) {
        this.sentence = sentence;
    }

    public String getString() {
        return this.sentence;
    }
    //No.1
    //开始写代码，用备忘录模式实现游戏存档、角色死亡与读取存档这一过程
    public Memento getMemento(){
        return new Memento(sentence);
    }

    public void setMemento(Memento memento){
        this.sentence = memento.getString();
    }

    //end_code
}
//No.2
//开始写代码，设计Memento类
class Memento{
    private String sentence;

    public Memento(String sentence) {
        this.sentence = sentence;
    }

    public void setString(String sentence) {
        this.sentence = sentence;
    }

    public String getString() {
        return this.sentence;
    }
}




//end_code

public class MementoTest {
    public static void main(String[] args) {
        Originator originator = new Originator("沙瑞克之塔开始");
        System.out.println("存档:" + originator.getString());
        Memento mement = originator.getMemento();
        originator.setString("开始打沙瑞克之塔……角色全都死了");
        System.out.println("游戏开始:" + originator.getString());
        originator.setMemento(mement);
        System.out.println("读取存档:" + originator.getString());
    }
}