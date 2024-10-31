
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2;

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        int carry = 0;

        while (curr1 != null || curr2 != null) {
            int digit1 = curr1 != null ? curr1.val : 0;
            int digit2 = curr2 != null ? curr2.val : 0;

            int sum = digit1 + digit2 + carry;

            ListNode tempNode = new ListNode(sum % 10);
            temp.next = tempNode;
            temp = temp.next;
            carry = sum / 10;

            curr1 = curr1 != null ? curr1.next : curr1;
            curr2 = curr2 != null ? curr2.next : curr2;
        }

        if (carry > 0) {
            ListNode tempNode = new ListNode(carry);
            temp.next = tempNode;
            temp = temp.next;
        }

        temp.next = null;

        return result.next;
    }
}