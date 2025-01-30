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
        String[] values = data.replaceAll("[\\[\\] ]", "").split(","); 
        ListNode dummyHead = new ListNode(0); 
        ListNode current = dummyHead;
        for (String value : values) {
            if (!value.isEmpty()) {
                current.next = new ListNode(Integer.parseInt(value)); 
                current = current.next; 
            }
        }
        return dummyHead.next; 
    }
}
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; 
        }
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head; 
        }
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null; 
        current.next = head; 
        return newHead; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "[1,2,3,4,5]";
        ListNode head = ListNode.deserialize(input);
        ListNode rotatedHead = solution.rotateRight(head, 2);
        ListNode current = rotatedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}