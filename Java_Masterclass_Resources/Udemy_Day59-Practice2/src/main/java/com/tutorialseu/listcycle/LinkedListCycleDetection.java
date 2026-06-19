package com.tutorialseu.listcycle;

public class LinkedListCycleDetection {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;  // No cycle possible if there are 0 or 1 nodes
        }

        ListNode slow = head;         // Slow pointer
        ListNode fast = head.next;    // Fast pointer starts ahead by one step

        // Loop until fast pointer reaches the end (null) or slow meets fast
        while (fast != null && fast.next != null) {
            if (slow == fast) {       // If slow and fast meet, there's a cycle
                return true;
            }
            slow = slow.next;         // Move slow pointer by 1 step
            fast = fast.next.next;    // Move fast pointer by 2 steps
        }

        return false;  // If fast reaches the end, no cycle
    }

    public static void main(String[] args) {
        // Example 1: Linked list with a cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next; // Creating a cycle at node 3

        System.out.println("Cycle present: " + hasCycle(head));  // Expected Output: true

        // Example 2: Linked list without a cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        System.out.println("Cycle present: " + hasCycle(head2));  // Expected Output: false
    }
}