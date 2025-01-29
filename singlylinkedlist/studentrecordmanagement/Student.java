package day_01.singlylinkedlist.studentrecordmanagement;

class Student{
   private Node head;
   private Node tail;
   private int size;

   //class node to store the data of students on the linkedlist
   class Node{
     int rollNumber;
     String name;
     int age;
     char grade;
     Node next;
        //constructor t create a new node
        public Node( int rollNumber, String name,int age, char grade){
        this.rollNumber =rollNumber;
        this.name =name;
        this.age = age;
        this.grade = grade;

    }
     //constructor to create a new node with index
       public Node( int rollNumber, String name,int age, char grade,Node next){
           this.rollNumber =rollNumber;
           this.name =name;
           this.age = age;
           this.grade = grade;
           this.next = next;
       }
  }
  // method for adding node at the beginning.
  public void insertAtBeginning(int rollNumber, String name, int age, char grade){
       Node node = new Node(rollNumber,name,age, grade);
       node.next=head;
       head=node;

       if(tail==null){
           tail=head;
       }
       size++;
  }
  // method for the adding the node at the last of the linked list
  public void insertAtLast(int rollNumber, String name,int age, char grade){
      if(tail==null){
          insertAtBeginning(rollNumber,name,age,grade);
      }
      Node node =new Node(rollNumber,name,age,grade);
      tail.next=node;
      tail=node;
      size++;
  }
    // method for the adding the node at specific index of the linked list
  public void insertAtSpecificIndex(int rollNumber, String name,int age , char grade  ,int index){
       if(index==0){
           insertAtBeginning(rollNumber,name,age,grade);
           return;
       }
       if(index==size){
           insertAtLast(rollNumber,name,age, grade);
           return;
       }
       Node temp=head;
       for(int i=1; i<index; i++){
           temp=temp.next;
       }
       Node node = new Node (rollNumber,name,age,grade,temp.next);
       temp.next=node;
       size++;
  }

  // method to display the details of the student in linked list
  public void display(){
       Node temp=head;
       while(temp!=null){
           System.out.println("Roll Number of Student: "+temp.rollNumber+" Name of a Student: "+temp.name+" Age of Student: "+temp.age+" Grade of Student: "+temp.grade);
           temp=temp.next;
       }
  }
}