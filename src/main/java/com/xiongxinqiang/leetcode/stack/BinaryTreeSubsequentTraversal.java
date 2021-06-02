package com.xiongxinqiang.leetcode.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/13 10:47 上午
 *
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例：
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class BinaryTreeSubsequentTraversal {

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode();
        left1.val = 3;

        TreeNode right1 = new TreeNode();
        right1.val = 2;
        right1.right = left1;

        TreeNode node = new TreeNode();
        node.val = 1;
        node.left = right1;
//        System.out.println(postorderTraversal(node));
        System.out.println(postorderTraversal2(node));
    }

    /**
     * 官方方法2：迭代
     * 思路与算法
     *
     * 我们也可以用迭代的方式实现方法一的递归函数，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来，
     * 其余的实现与细节都相同，具体可以参考下面的代码。
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }



    /**
     * 方法1：递归  0ms 击败100%,内存36.7MB，击败63.61%
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;

    }


    public static void recursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        recursion(node.left, list);
        recursion(node.right, list);
        list.add(node.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
