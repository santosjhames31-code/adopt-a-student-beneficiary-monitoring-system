package DSA;

class Node{
    int data;
    Node next;
}

class LinkedList{
    Node head;
    int size;

    void insert(int data){
        size++;
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
            System.out.println(n.data);
            n = n.next;
        }
    }

    void insertAtStart(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    void insertAtIndex(int data, int index){
        Node node = new Node();
        node.data = data;
        if(index == 0) insertAtStart(data);
        else{
            Node n = head;
            for(int i = 0; i < index - 1; i++){
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    void deleteByIndex(int index){
        Node n = head;
        Node emptyNode = null;
        
        if(index == 0){
           head = n.next;
        }
        else{
           for(int i = 0; i < index - 1; i++){
                n = n.next;
            }
            emptyNode = n.next;
            n.next = emptyNode.next; 
        }
        
    }

    void deleteByValue(int value){
        Node n = head;
        Node emptyNode = null;
        if(n.data == value) {
           deleteByIndex(0);
        }else{
           while(n != null){
            if(n.next.data == value) break;
            n = n.next;
        }
        emptyNode = n.next;
        n.next = emptyNode.next; 
        }
        
    }

    void reverse(){
        Node prev = null;
        Node n = head;
        while(n != null){
            Node next = n.next;  // save next before overwriting
            n.next = prev;       // reverse the link
            prev = n;            // move prev forward
            n = next;            // move curr forward
        }
        head = prev;
    }

    int search(int value){
        int position = 0;
        Node n = head;
        while(n != null){
            if(n.data == value) break; 
            position++;
            n = n.next;
        }
        if(position > size) position = -1;
    return position;
    
    }
    
    int max(){
        Node n = head;
        int max = 0;
        while(n != null){
            if (n.data > max) max = n.data;
            n = n.next;
        }
        return max;
    }

    int min(){
        int min = max();
        Node n = head;
        while(n != null){
            if(n.data < min) min = n.data;
            n = n.next;
        }
        return min;
    }
}

class Main{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insertAtStart(67);
        ll.insertAtIndex(0, 1);
        ll.deleteByValue(67);

        ll.display();

        System.out.println("Position : " + ll.search(67));

        ll.reverse();
        ll.display();
        System.out.println("Max : " + ll.max());
        System.out.println("Min : " + ll.min());
    }
} 