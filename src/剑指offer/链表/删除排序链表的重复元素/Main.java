package 剑指offer.链表.删除排序链表的重复元素;

import OneQuestionEveryDay.Package_07.链表分割.ListNode;

/*
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
 */
public class Main {
    /**
     * 删除重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = head;
        while (newHead != null && newHead.next != null){
            ListNode cur = newHead.next;
            if(newHead.val == cur.val){
                newHead.next = cur.next;
            }else {
                newHead = newHead.next;
            }
        }
        return head;
    }
}
