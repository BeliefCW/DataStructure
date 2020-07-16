package 剑指offer.链表.链表求和;

import OneQuestionEveryDay.Package_07.链表分割.ListNode;

public class Main {
    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     *
     * 这些数位是反向存放的，也就是个位排在链表首部。
     *
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * 示例：
     *
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     * @param l1
     * @param l2
     * @return
     *
     * 解题思路
     * 首先，我觉得肯定得遍历两个链表,因为所加得数字是链表逆序得的，如题，7 --> 1 --> 6则是716，5 -> 9 -> 2则是295，
     * 所以，链表的第一个结点的val值则是个位相加，并且相加的数 num/10 则为需要对十分位进的位数！  往后同理
     *
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //返回新链表的头节点
        ListNode  ans = new ListNode(0);
        ListNode  cur = ans;
        //表示每一次相加需要进的位数
        int count = 0;
        while (l1 != null || l2 != null){
            int num1 = (l1 == null) ? 0 : l1.val;
            int num2 = (l2 == null) ? 0 : l2.val;

            //每一次两链表的结点相加得到的数字   如第一次则为个位相加  也就是 7+5 = 12
            int num = num1 + num2 + count;
            // 7+5 = 12  应该进1  count就表示进的位数
            count = num/10;

            //把当前结点封装在新链表中
            cur.next = new ListNode(num % 10);
            cur = cur.next;

            //这个时候个位的相加完成  应该让链表进入下一个结点
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;


        }
        if(count == 1){
            cur.next = new ListNode(count);
        }
        return ans.next;


    }
}
