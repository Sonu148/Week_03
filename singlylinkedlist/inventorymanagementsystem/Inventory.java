package day_01.singlylinkedlist.inventorymanagementsystem;

public class Inventory {
    // head and tail of the linked list
    private Node head;
    private Node tail;
    // number of the elements in the linked list
    private int size;

    // node class to represent items in inventory
    class Node {
        //attribute of the inventory
        String itemName;
        int itemId;
        int quantity;
        double price;
        private Node next;

        // constructor to create a new node
        public Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }

        public Node(String itemName, int itemId, int quantity, double price, Node next) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = next;
        }
    }

    // insert a new item at beginning
        public void insertAtBeginning(String itemName, int itemId, int quantity, double price){
            Node node= new Node(itemName,itemId, quantity,price);
            node.next=head;
            head=node;
           if(tail==null){
               tail=head;
           }
           size++;
        }
        // insert a new item at last
        public void insertAtLast(String itemName, int itemId, int quantity, double price){
            if(tail==null){
                insertAtBeginning(itemName,itemId, quantity,price);
            }
            Node  node= new Node(itemName,itemId, quantity,price);
            tail.next=node;
            tail=node;
            size++;
        }

        //insert the item At Specific Index
        public void insertAtSpecificIndex(String itemName, int itemId, int quantity, double price, int index){
            if(index==0){
                insertAtBeginning(itemName,itemId, quantity,price);
                return;
            }
            if(index==size){
                insertAtLast(itemName, itemId, quantity, price);
                return;
            }
            Node temp=head;
            for(int i=1; i<index; i++){
                temp=temp.next;
            }
            Node node =new Node(itemName,itemId, quantity,price, temp.next);
            temp.next=node;
            size++;
        }
    // remove an item from inventory
    public void removeByItemId(int itemId) {
        if (head == null) return;

        // If the head node is the one to be deleted
        if (head.itemId == itemId) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }

        // Search for the node to delete
        Node temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }

        // If the item was found
        if (temp.next != null) {
            temp.next = temp.next.next;
            if (temp.next == null) {  // If the node to delete was the tail
                tail = temp;
            }
            size--;
        }
    }

    // update  the quantity of the item
    public void updateQuantity(int itemId, int newQuantity) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }
    // search the  item using the item id
    public Node searchByItemId(int itemId) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // Return null if not found
    }
   // searching the item by the item name
    public Node searchByItemName(String itemName) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // Return null if not found
    }

    // method for calculate the total value of the inventory
    public double calculateTotalValue() {
        double totalValue = 0;
        Node temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        return totalValue;
    }
    // sorting the item using merge sort
    public void sortByItemName() {
        head = mergeSort(head, "name");
    }

    private Node mergeSort(Node head, String criteria) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head, criteria);
        Node right = mergeSort(nextOfMiddle, criteria);

        return merge(left, right, criteria);
    }
    // Merge two sorted lists based on the given criteria (name or price)
    private Node merge(Node left, Node right, String criteria) {
        if (left == null) return right;
        if (right == null) return left;

        if (criteria.equals("name")) {
            if (left.itemName.compareTo(right.itemName) < 0) {
                left.next = merge(left.next, right, criteria);
                return left;
            } else {
                right.next = merge(left, right.next, criteria);
                return right;
            }
        } else if (criteria.equals("price")) {
            if (left.price < right.price) {
                left.next = merge(left.next, right, criteria);
                return left;
            } else {
                right.next = merge(left, right.next, criteria);
                return right;
            }
        }
        return null;
    }
    // Find the middle node of the list
    private Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    // method for the display the items of the inventory
    public void display(){
            Node temp=head;
            while(temp!=null){

                System.out.println("Item name  : "+ temp.itemName +", Id : "+temp.itemId+", quantity : "+temp.quantity+", price : "+temp.price );
                temp=temp.next;
            }
        }

}
