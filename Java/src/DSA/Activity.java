package DSA;

class Node{
    String name;
    int id;
    double grade;
    Node next;
}

class LinkedList{
    Node head;
    void addStudent(String name, int id, double grade){
        Node node = new Node();
        node.name = name;
        node.id = id;
        node.grade = grade;
        node.next = null;
        if(head == null) head = node;
        else{
            Node n = head;
            while(n.next != null){
                n = n.next;
            }
            
            node = n.next;
        }
    }

    void display(){
        Node n = head;
        while(n != null){
            System.out.println("Node  : " + n);
            System.out.println("Name  : " + n.name);
            System.out.println("ID : " + n.id);
            System.out.println("Grade : " + n.grade);
            n = n.next;
        }
    }

}

public class Activity {
// Add a student.
// Display all students.
// Search for a student by ID.
// Delete a student by ID.

public static void main(String[] args) {
    
    LinkedList ll = new LinkedList();
    ll.addStudent("Jhames", 1234, 89.5);
    ll.addStudent("Gian", 67676, 91.5);

    ll.display();
}

}
