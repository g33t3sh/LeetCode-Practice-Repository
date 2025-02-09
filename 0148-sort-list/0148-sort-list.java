import java.util.*;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) { 
        val = x; 
    }
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) {
            return null;
        }
        
        String[] values = data.replaceAll("[\\[\\]]", "").split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String value : values) {
            if (!value.trim().isEmpty()) {
                current.next = new ListNode(Integer.parseInt(value.trim()));
                current = current.next;
            }
        }

        return dummy.next;
    }
}

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next; 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head1 = ListNode.deserialize("[4,2,1,3]");
        ListNode sortedHead1 = solution.sortList(head1);
        System.out.print("Sorted List 1: ");
        printList(sortedHead1); 
        ListNode head2 = ListNode.deserialize("[-1,5,3,4,0]");
        ListNode sortedHead2 = solution.sortList(head2);
        System.out.print("Sorted List 2: ");
        printList(sortedHead2); 
        ListNode head3 = ListNode.deserialize("[]");
        ListNode sortedHead3 = solution.sortList(head3);
        System.out.print("Sorted List 3: ");
        printList(sortedHead3); 
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}