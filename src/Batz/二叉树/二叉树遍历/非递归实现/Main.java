package Batz.二叉树.二叉树遍历.非递归实现;

import Batz.二叉树.二叉树遍历.非递归实现.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 知识点总结
 * 思路：
 * 1.前序遍历是在遍历整个二叉树第一次访问节点，中序遍历是第二次访问节点，后续遍历是第三次访问节点
 * 2.实现方式：递归(函数栈)，非递归，借用数据结构的栈
 *
 */
public class Main {
    /**
     * 二叉树的前序遍历
     * @param root
     * @return 非递归实现
     * 将二叉树  先把右子树压入栈 在压入左子树
     */
    public void preorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        Stack<TreeNode> stack = new Stack();
        stack.add(root);

        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.println(root.val);
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
    }

    /**
     * 二叉树的中序遍历
     * @param root
     * @return 非递归实现
     * 左 上 下  把二叉树
     */
    public void inorderTraversal(TreeNode root) {
        /**
         * 左节点不为null继续遍历  为空 从栈中弹出 打印当前节点 节点向右子树遍历
         */
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                System.out.println(stack.pop().val);
                root = root.right;
            }
        }
    }

    /**
     * 二叉树的后续遍历
     * @param root
     * @return 非递归实现
     * 左 右 上
     * 根据先序的特点，上左右，实现上右左很简单
     */
    public void postorderTraversal(TreeNode root) {
       Stack<TreeNode> s1 = new Stack<>();
       Stack<TreeNode> s2 = new Stack<>();
       s1.add(root);
       while (!s1.isEmpty()){
           root = s1.pop();
           //前序遍历此处应该打印当前节点  此处将其压入栈2
           s2.push(root);
           if(root.left != null){
               s1.push(root.left);
           }
           if(root.right != null){
               s1.push(root.right);
           }
       }
       while (!s2.isEmpty()){
           System.out.println(s2.pop().val);
       }
    }
}
