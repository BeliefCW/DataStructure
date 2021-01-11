package Batz.二叉树.二叉树遍历.递归实现;


public class Main{

    /**
     * 二叉树的前序遍历
     * @param root
     * @return 递归实现
     */
    public void preorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.println(root);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /**
     * 二叉树的中序遍历
     * @param root
     * @return 递归实现
     */
    public void inorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root);
        inorderTraversal(root.right);
    }

    /**
     * 二叉树的后续遍历
     * @param root
     * @return 递归实现
     */
    public void postorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root);
    }

}
