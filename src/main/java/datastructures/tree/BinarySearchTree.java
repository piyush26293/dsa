package datastructures.tree;

/**
 * Binary Search Tree Implementation
 * A tree data structure where each node has at most two children
 * Left child < Parent < Right child
 */
public class BinarySearchTree {
    
    private Node root;
    
    /**
     * Node class representing each element in the tree
     */
    private static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public BinarySearchTree() {
        this.root = null;
    }
    
    /**
     * Insert a value into the BST
     */
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    /**
     * Search for a value in the BST
     */
    public boolean search(int data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        
        if (root.data == data) {
            return true;
        }
        
        if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
    
    /**
     * Delete a value from the BST
     */
    public void delete(int data) {
        root = deleteRec(root, data);
    }
    
    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return null;
        }
        
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            // Node with two children: Get inorder successor
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        
        return root;
    }
    
    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    
    /**
     * In-order traversal (Left, Root, Right)
     */
    public void inorder() {
        System.out.print("In-order: ");
        inorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    
    /**
     * Pre-order traversal (Root, Left, Right)
     */
    public void preorder() {
        System.out.print("Pre-order: ");
        preorderRec(root);
        System.out.println();
    }
    
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    
    /**
     * Post-order traversal (Left, Right, Root)
     */
    public void postorder() {
        System.out.print("Post-order: ");
        postorderRec(root);
        System.out.println();
    }
    
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        
        System.out.println("Binary Search Tree Demo\n");
        
        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        System.out.println("Tree after insertions:");
        bst.inorder();
        bst.preorder();
        bst.postorder();
        
        // Search
        System.out.println("\nSearching for 40: " + bst.search(40));
        System.out.println("Searching for 100: " + bst.search(100));
        
        // Delete
        System.out.println("\nDeleting 20...");
        bst.delete(20);
        bst.inorder();
        
        System.out.println("\nDeleting 30...");
        bst.delete(30);
        bst.inorder();
        
        System.out.println("\nDeleting 50...");
        bst.delete(50);
        bst.inorder();
    }
}
