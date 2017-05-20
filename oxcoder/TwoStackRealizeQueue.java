import java.util.*;

public class TwoStackRealizeQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    TwoStackRealizeQueue(){
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    //No.1
    //开始写代码，用两个栈实现一个队列
    //q :
    //  > ....]s1     s2[.....   >
    public int offer(int o){//push

        stack1.push(o);
        return o;
    }

    public int poll(){//pop

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

//        if(stack1.empty()){
//            throw new EmptyStackException();
//        }
//        while(!stack1.empty()){
//            stack2.push(stack1.pop());
//        }
//        int qhead  = stack2.empty()?-1:stack2.pop();
//        while (!stack2.empty()){
//            stack1.push(stack2.pop());
//        }
//        return qhead;

    }
    //end_code
    public static void main(String[] args) {
        TwoStackRealizeQueue queue=new TwoStackRealizeQueue();
        List<Integer> number=new ArrayList<Integer>();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        queue.offer(4);
//        queue.offer(5);
        number.add(queue.poll());
        number.add(queue.poll());
        number.add(queue.poll());
        number.add(queue.poll());
        number.add(queue.poll());
        System.out.println(number);
    }
}
/*
用java代码实现使用两个栈来实现一个队列
 */