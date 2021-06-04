package com.xiongxinqiang.leetcode.stack.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/13 1:56 下午
 *
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 示例1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode();
        left1.val = 3;

        TreeNode right1 = new TreeNode();
        right1.val = 2;
        right1.left = left1;

        TreeNode node = new TreeNode();
        node.val = 1;
        node.right = right1;
        System.out.println(inorderTraversal(node));
        System.out.println(inorderTraversal2(node));
    }


    /**
     * 方法2：迭代
     * 思路与算法
     *
     * 方法一的递归函数我们也可以用迭代的方式实现，两种方式是等价的，区别在于递归的时候隐式地维护了一个栈，
     * 而我们在迭代的时候需要显式地将这个栈模拟出来，其他都相同，具体实现可以看下面的代码。
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    /**
     * 方法1：递归
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root,list);
        return list;
    }

    private static void recursion(TreeNode node,List<Integer> list) {
        if (node == null) {
            return;
        }
        recursion(node.left, list);
        list.add(node.val);
        recursion(node.right, list);
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
