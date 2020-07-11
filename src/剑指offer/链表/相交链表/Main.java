package 剑指offer.链表.相交链表;

import OneQuestionEveryDay.Package_07.链表分割.ListNode;

/*
编写一个程序，找到两个单链表相交的起始节点。
 */
public class Main {
    /**
     * 假设两条链表的分别为A 和  B
     * 首先，设第一个链表的长度为 a+c 第二个链表长度为 b+c  c为链表公共的部分  则 a+b+c = c+b+a
     * 然后定义两个指针  L1指向A链表的头节点  L2指向B链表的头节点 当L1遍历到A链表的末尾的时候，让A指向B链表的头节点也就是headB
     * 同样 L2到B链表的末尾时，指向A链表的头节点    当L1 == L2 的时候，则到了相交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2){
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}