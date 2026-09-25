class Node{
    int data;
    Node next;
}

class LinkedList{
    Node head;
    
    void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) head = node;
        else{
            Node n = head;
            while(n.next != null){
                n = n.next;
        } 
        n.next = node;      
    }
}

    void display(){
        Node n = head;
        while(n != null){
            System.out.println(n + " " + n.data);
            n = n.next;
        }
    }

    void insertStart(int data){
        Node node = new Node();
        node.next = head;
        node.data = data;
        head = node;
    }

    void insertIndex(int data, int index){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (index == 0) insertStart(data);
        else{
            Node n = head;
            for(int i = 0; i < index - 1; i++){
                n = n.next; 
            }   
            n.next = node;
            node.next = n.next;
        }
    }

    void delete(int index){
        Node n = head;
        Node del = null;
        for(int i = 0; i < index - 1; i++){
            n = n.next; 
        }   
        del = n.next;
        n.next = del.next;
    }


}

public class practice {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5); 
    
        list.display();
    }
}
