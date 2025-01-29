package day_01.singlylinkedlist.studentrecordmanagement;

public class Main {

    public static void main(String[] args) {
        // create the Student object.
        Student list=new Student();
        list.insertAtBeginning(23,"\"Sohan\"",19,'A');
        list.insertAtBeginning(2,"\"Mohan\"",23,'B');
        list.insertAtSpecificIndex(7,"\"Rohan\"",20,'A',1);
        list.display();
    }
}
