

public class Stacks{
    int top = -1;
    int size;
    int[] array;

    Stacks(int size){
        this.size = size;
        this.array = new int[size];
    }

    void push(int num){
        
        if (isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        array[top] = num;
    }

    void pop(){

        if(isEmpty()) {
            System.out.println("Stack is empty"); 
            return;  
        }
        array[top] = 0;
        top--;
    }

    int peek(){
        return array[top];
    }

    boolean isEmpty(){
        return top == -1;
    }

    boolean isFull(){
        return top >= array.length - 1;
    }

    int size(){
        return top + 1;
    }

    void display(){
        for(int num : array){
            System.out.println(num);
        }
    }

}

class Main{
    public static void main(String[] args){
        
        Stacks stacks = new Stacks(5);

        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);
        stacks.pop();
        stacks.pop();
        stacks.pop();
        stacks.display();
        System.out.println("Top : " +stacks.peek());
        System.out.println("Size : " + stacks.size());

    } 
}