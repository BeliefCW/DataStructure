package 剑指offer.栈和队列.用栈实现队列;

import java.util.Stack;


/*
用栈实现队列
两个队列
 */
public class Main {
        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2out();
            return out.pop();
        }

        public int peek() {
            in2out();
            return out.peek();
        }

        private void in2out() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

}
