package 剑指offer.从尾到头打印链表;

import OneQuestionEveryDay.Package_07.链表分割.ListNode;

import java.util.ArrayList;

public class Main {

        ArrayList<Integer> list = new ArrayList<>();
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            // 头插法构建逆序链表
            ListNode dummyHead = new ListNode(-1);
            while (listNode != null){
                ListNode s = listNode.next;
                listNode.next = dummyHead.next;
                dummyHead.next = listNode;
                listNode = s;
            }
            ArrayList<Integer> list = new ArrayList<>();
            dummyHead = dummyHead.next;
            while (dummyHead != null){
                list.add(dummyHead.val);
                dummyHead = dummyHead.next;
            }
            return list;
        }

    /**
     * 递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> PrintListFromTailToHead(ListNode listNode){
        recur(listNode);
        return list;
    }

    private void recur(ListNode listNode){
        if(listNode == null){
            return;
        }
        recur(listNode.next);
        list.add(listNode.val);
    }

}
