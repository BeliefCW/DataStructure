package 剑指offer.链表.回文链表;

import OneQuestionEveryDay.Package_07.链表分割.ListNode;

public class Main {
    /**
     * 编写一个函数，检查输入的链表是否是回文的。
     *
     *  
     *
     * 示例 1：
     *
     * 输入： 1->2
     * 输出： false
     * 示例 2：


     使用两个指针  快慢指针 找到链表的中点  然后头插法反转后把部分链表
     * 输入： 1->2->2->1
     * 输出： true
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode dummyHead = new ListNode(-1);
        //头插法反转链表
        while (slow != null){
            ListNode s = slow.next;
            slow.next = dummyHead.next;
            dummyHead.next = slow;
            slow = s;
        }

        while (dummyHead.next != null){
            if(dummyHead.next.val != head.val){
                return false;
            }
            dummyHead = dummyHead.next;
            head = head.next;
        }
        return true;


    }
}
