
class Stack{
    int top = -1;
    int[] list = new int[5];

    void insert(int data){
        top++;
        list[top] = data;
    }

    int getTop(){
        return list[top];
    }

    void display(){
        for(int e : list){
            System.out.println(e);
        }
    }

}

public class stacks {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        System.out.println("Top : " + s.getTop());
        s.display();
    
    }
}
