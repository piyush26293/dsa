package datastructures.queue;

/**
 * Queue Implementation using Array
 * FIFO (First In First Out) data structure
 */
public class Queue {
    
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    
    public Queue(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    /**
     * Add an element to the queue
     */
    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }
    
    /**
     * Remove an element from the queue
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
    
    /**
     * Get the front element without removing it
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[front];
    }
    
    /**
     * Check if queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Check if queue is full
     */
    public boolean isFull() {
        return size == capacity;
    }
    
    /**
     * Get the size of the queue
     */
    public int size() {
        return size;
    }
    
    /**
     * Display queue elements
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        
        System.out.println("Queue Demo");
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        System.out.println("\nQueue after enqueues:");
        queue.display();
        System.out.println("Size: " + queue.size());
        
        System.out.println("\nFront element (peek): " + queue.peek());
        
        System.out.println("\nDequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        
        System.out.println("\nQueue after dequeues:");
        queue.display();
        System.out.println("Size: " + queue.size());
        
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println("\nQueue after more enqueues:");
        queue.display();
    }
}
