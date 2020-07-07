package 剑指offer.从尾到头打印链表;

import OneQuestionEveryDay.Package_07.链表分割.ListNode;

import java.util.ArrayList;

public class Main {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            // 头插法构建逆序链表
            ListNode head = new ListNode(-1);
            while (listNode != null) {
                ListNode memo = listNode.next;
                listNode.next = head.next;
                head.next = listNode;
                listNode = memo;
            }
            // 构建 ArrayList
            ArrayList<Integer> ret = new ArrayList<>();
            head = head.next;
            while (head != null) {
                ret.add(head.val);
                head = head.next;
            }
            return ret;
        }
}
