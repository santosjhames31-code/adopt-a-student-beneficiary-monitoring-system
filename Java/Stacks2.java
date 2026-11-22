package Java;

import java.util.Scanner;
import java.util.Arrays;

public class Stacks2 {
    int top = - 1;
    int size;
    int[] arr;
    
    Stacks2(int size){
        arr = new int[size];
    }
    
    void push(int data){
        if (isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = data;
    }

    int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int val = arr[top];
        arr[top] = 0;
        top--;
        return val;
    }

    void reverse(){
        int[] reversed = new int[arr.length];
        int i = arr.length - 1;
        for(int num : arr){
            reversed[i] = num;
            i--;
        }
        System.out.println(Arrays.toString(reversed));
        arr = reversed;
    }
        
    int search(int value){
        int index = -1;
        for(int i = 0; i <= top; i++){
            if (value == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    boolean isEmpty(){
        return top == -1; 
    }
    boolean isFull(){
        return top == arr.length - 1;
    }

    void display(){
        for(int num : arr){
            System.out.println(num);
        }
    }

}

class Main{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        Stacks2 stack = new Stacks2(Integer.parseInt(sc.nextLine()));

        while(true){
        
        printMenu();
            switch (Integer.parseInt(sc.nextLine())) {
                case 1:
                    System.out.print("Value : ");
                    int value = Integer.parseInt(sc.nextLine());
                    stack.push(value);
                    break;
                case 2:
                    System.out.println("Popped the value " + stack.pop());
                    break;
                case 3:
                    stack.reverse();
                    System.out.println("Stack reversed successfully!");
                    break;
                case 4:
                    System.out.print("Value : ");
                    int index = stack.search(Integer.parseInt(sc.nextLine()));
                    if(index == -1) System.out.println("Value not found :<");
                    else System.out.println("Value found at index " + index);
                    break;
                case 5:
                    stack.display();
                    break;
                case 6:
                    System.out.println("Successfully Exited");
                    return;
                default:
                    System.out.println("Invalid choice");
                break;
            }

        }
    }

    static void printMenu(){
        System.out.println("** Stacks **");
        System.out.println("[1] Push");
        System.out.println("[2] Pop");
        System.out.println("[3] Reverse");
        System.out.println("[4] Search");
        System.out.println("[5] Display");
        System.out.println("[6] Exit");
        System.out.print("Choice : ");
    }
    
}
