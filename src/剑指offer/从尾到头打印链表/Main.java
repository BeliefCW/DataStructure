package 剑指offer.从尾到头打印链表;

import OneQuestionEveryDay.Package_07.链表分割.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Main {

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
     * 使用栈的结构
     * @param listNode
     * @return
     */
    private ArrayList<Integer> PrintListFromTailToHead(ListNode listNode){
            Stack<Integer> stack = new Stack<>();
            while (listNode != null){
                stack.add(listNode.val);
                listNode = listNode.next;
            }

            ArrayList<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()){
                list.add(stack.pop());
            }
            return list;
        }

}
