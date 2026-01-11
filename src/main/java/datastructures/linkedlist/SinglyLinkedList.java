package datastructures.linkedlist;

/**
 * Singly Linked List Implementation
 * A linear data structure where elements are stored in nodes
 */
public class SinglyLinkedList {
    
    private Node head;
    private int size;
    
    /**
     * Node class representing each element in the linked list
     */
    private static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Insert a node at the beginning
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /**
     * Insert a node at the end
     */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }
    
    /**
     * Delete a node with given value
     */
    public boolean delete(int data) {
        if (head == null) {
            return false;
        }
        
        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        
        return false;
    }
    
    /**
     * Search for a value in the linked list
     */
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Get the size of the linked list
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Display the linked list
     */
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        System.out.println("Singly Linked List Demo");
        
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);
        
        System.out.println("\nLinked List:");
        list.display();
        System.out.println("Size: " + list.getSize());
        
        System.out.println("\nSearching for 20: " + list.search(20));
        System.out.println("Searching for 100: " + list.search(100));
        
        list.delete(20);
        System.out.println("\nAfter deleting 20:");
        list.display();
        System.out.println("Size: " + list.getSize());
    }
}
