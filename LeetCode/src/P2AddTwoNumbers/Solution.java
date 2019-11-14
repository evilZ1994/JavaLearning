package P2AddTwoNumbers;

/**
 * 两数相加
 *
 * 题目描述：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        int carry = val / 10;
        ListNode node = new ListNode(val % 10);
        ListNode temp = node;
        while (l1.next != null || l2.next != null || carry > 0) {
            val = carry;
            if (l1.next != null) {
                l1 = l1.next;
                val += l1.val;
            }
            if (l2.next != null) {
                l2 = l2.next;
                val += l2.val;
            }
            ListNode next = new ListNode(val % 10);
            carry = val / 10;
            temp.next = next;
            temp = next;
        }
        return node;
    }
}
