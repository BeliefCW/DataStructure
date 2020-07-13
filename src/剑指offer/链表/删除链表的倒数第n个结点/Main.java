package 剑指offer.链表.删除链表的倒数第n个结点;

import OneQuestionEveryDay.Package_07.链表分割.ListNode;

/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Main {
    /**
     * 使用一趟扫描完成  快慢指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast = head;
        ListNode slow = head;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        if(fast == null){
            return head.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head.next;
    }
}
