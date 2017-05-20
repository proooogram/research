import java.util.ArrayList;
abstract class MusicClass{
    public String name;
    public ArrayList<MusicClass> list;
    public abstract void add(MusicClass component);
    public abstract void remove(MusicClass component);
    public abstract void display();
}
//No.1
//开始写代码，使用组合模式，请构造Song和ConcreteMusicClass类

class Song extends MusicClass{

    Song(String name){
        this.name = name;
        this.list = new ArrayList<>();
    }
    @Override
    public void add(MusicClass component) {
        list.add(component);
    }

    @Override
    public void remove(MusicClass component) {
        list.remove(component);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (MusicClass e:list){
            sb.append(e +",");
        }
        return  (name+":"+new String(sb) ) ;
    }

    @Override
    public void display() {
        System.out.println(this.toString()) ;
    }
}

class  ConcreteMusicClass extends MusicClass{
    ConcreteMusicClass(String name){
        this.name = name;
        this.list = new ArrayList<>();

    }

    @Override
    public void add(MusicClass component) {
        list.add(component);

    }

    @Override
    public void remove(MusicClass component) {
        list.remove(component);

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for (MusicClass e:list){
            sb.append(e +";");
        }
        return (name+"::"+new String(sb) ) ;
    }
    @Override
    public void display() {
        System.out.println(this.toString() ) ;

    }
}

//end_code
public class CompositeTest {
    public static void main(String args[]){
        Song song1=new Song("七里香");
        Song song2=new Song("东风破");
        ConcreteMusicClass concreteMusicClassZhou=new ConcreteMusicClass("周杰伦");

        Song song3=new Song("我的歌声里");
        Song song4=new Song("jar of love");
        ConcreteMusicClass concreteMusicClassQu=new ConcreteMusicClass("曲婉婷");

        ConcreteMusicClass root=new ConcreteMusicClass("root");

        //No.2
        //开始写代码，补充完整main函数

        concreteMusicClassZhou.add(song1);
        concreteMusicClassZhou.add(song2);
        concreteMusicClassQu.add(song3);
        concreteMusicClassQu.add(song4);

        root.add(concreteMusicClassZhou);
        root.add(concreteMusicClassQu);

        root.display();
        //end_code
    }
}

/*
用java代码实现组合模式，周杰伦的歌有：七里香和东风破，曲婉婷的歌有：我的歌声里和jar of love，将歌曲与对应的歌手归类，用组合模式实现这一过程，Song是歌曲类，ConcreteMusicClass是歌手类，均继承MusicClass类，请自行构造这两个类
 */
