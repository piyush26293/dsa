package leetcode.medium;

/**
 * LeetCode Problem: Add Two Numbers
 * Problem: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * 
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    
    /**
     * Definition for singly-linked list node
     */
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    /**
     * Solution - O(max(m,n)) time, O(max(m,n)) space
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    /**
     * Helper method to create a linked list from an array
     */
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    /**
     * Helper method to print a linked list
     */
    public static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(",");
            }
            head = head.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        System.out.println("LeetCode - Add Two Numbers Problem\n");
        
        // Test case 1: 342 + 465 = 807
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        
        System.out.print("Input: l1 = ");
        printList(l1);
        System.out.print("       l2 = ");
        printList(l2);
        
        ListNode result = addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printList(result);
        
        // Test case 2: 0 + 0 = 0
        System.out.println();
        ListNode l3 = createList(new int[]{0});
        ListNode l4 = createList(new int[]{0});
        
        System.out.print("Input: l1 = ");
        printList(l3);
        System.out.print("       l2 = ");
        printList(l4);
        
        ListNode result2 = addTwoNumbers(l3, l4);
        System.out.print("Output: ");
        printList(result2);
        
        // Test case 3: 9999999 + 9999 = 10009998
        System.out.println();
        ListNode l5 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l6 = createList(new int[]{9, 9, 9, 9});
        
        System.out.print("Input: l1 = ");
        printList(l5);
        System.out.print("       l2 = ");
        printList(l6);
        
        ListNode result3 = addTwoNumbers(l5, l6);
        System.out.print("Output: ");
        printList(result3);
    }
}
