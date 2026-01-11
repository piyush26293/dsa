package datastructures.stack;

/**
 * Stack Implementation using Array
 * LIFO (Last In First Out) data structure
 */
public class Stack {
    
    private int[] arr;
    private int top;
    private int capacity;
    
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    /**
     * Push an element onto the stack
     */
    public void push(int item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[++top] = item;
    }
    
    /**
     * Pop an element from the stack
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return arr[top--];
    }
    
    /**
     * Peek at the top element without removing it
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return arr[top];
    }
    
    /**
     * Check if stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Check if stack is full
     */
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    /**
     * Get the size of the stack
     */
    public int size() {
        return top + 1;
    }
    
    /**
     * Display stack elements
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        
        System.out.println("Stack Demo");
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        System.out.println("\nStack after pushes:");
        stack.display();
        System.out.println("Size: " + stack.size());
        
        System.out.println("\nTop element (peek): " + stack.peek());
        
        System.out.println("\nPopped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        
        System.out.println("\nStack after pops:");
        stack.display();
        System.out.println("Size: " + stack.size());
    }
}
