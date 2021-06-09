package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/8 2:46 下午
 *
 * 1582. 二进制矩阵中的特殊位置
 *
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵mat 中特殊位置的数目 。
 *
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 *
 *
 * 示例1：
 * 输入：mat = [[1,0,0],
 *            [0,0,1],
 *            [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 *
 *
 * 示例2：
 * 输入：mat = [[1,0,0],
 *            [0,1,0],
 *            [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 *
 *
 * 示例3：
 * 输入：mat = [[0,0,0,1],
 *            [1,0,0,0],
 *            [0,1,1,0],
 *            [0,0,0,0]]
 * 输出：2
 *
 *
 * 示例4：
 * 输入：mat = [[0,0,0,0,0],
 *            [1,0,0,0,0],
 *            [0,1,0,0,0],
 *            [0,0,1,0,0],
 *            [0,0,0,1,1]]
 * 输出：3
 *
 * 提示：
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1582_SpecialPositionsInBinaryMatrix {

    public static void main(String[] args) {
//        int[][] mat = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] mat = new int[][]{{0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(numSpecial(mat));

    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.67%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了85.76%的用户
     *
     * @param mat
     * @return
     */
    public static int numSpecial(int[][] mat) {
        int ret = 0;
        for (int i = 0, j = mat.length - 1; i <= j; i++, j--) {
            ret += traverse(mat[i], mat);
            if (i == j) {
                continue;
            }
            ret += traverse(mat[j], mat);
        }
        return ret;
    }

    public static int traverse(int[] ints, int[][] mat) {
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] == 1 && rowCount(ints) && cellCount(mat, j)) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 当前列是否只存在一次1
     *
     * @param mat
     * @param j
     * @return
     */
    public static boolean cellCount(int[][] mat, int j) {
        int count = 0;
        for (int i = 0, m = mat.length - 1; i <= m; i++, m--) {
            if (mat[i][j] == 1) {
                ++count;
            }
            if (mat[m][j] == 1 && i != m) {
                ++count;
            }
            if (count > 1) {
                break;
            }
        }
        return count == 1;
    }


    /**
     * 当前行是否只存在一次1
     *
     * @param nums
     * @return
     */
    public static boolean rowCount(int[] nums) {
        int count = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (nums[i] == 1) {
                ++count;
            }
            if (nums[j] == 1 && i != j) {
                ++count;
            }
            if (count > 1) {
                break;
            }
        }
        return count == 1;
    }

}
