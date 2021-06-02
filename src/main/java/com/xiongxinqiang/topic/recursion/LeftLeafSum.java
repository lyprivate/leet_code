package com.xiongxinqiang.topic.recursion;

import org.junit.Test;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2020/11/26 5:11 下午
 */

/**
 * 题目：计算给定二叉树的所有左叶子之和
 * 类型：递归
 * 力扣编号：404
 */
public class LeftLeafSum {


    @Test
    public void test() {
        TreeNode var3 = new TreeNode(15, null, null);
        TreeNode var4 = new TreeNode(7, null, null);
        TreeNode var2 = new TreeNode(20, var3, var4);
        TreeNode var1 = new TreeNode(9, null, null);
        TreeNode var10 = new TreeNode(3, var1, var2);
        int sum = sumOfLeftLeaves(var10);
        System.out.println("sum = " + sum);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += dfs(node.right);
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
