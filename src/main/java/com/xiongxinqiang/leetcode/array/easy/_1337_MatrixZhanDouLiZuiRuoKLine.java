package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/3 3:52 下午
 *
 * 1337. 矩阵中战斗力最弱的 K 行
 * 给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。
 *
 * 如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 * 示例1：
 * 输入：mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 *
 * 示例2：
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 *
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class _1337_MatrixZhanDouLiZuiRuoKLine {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}
                , {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
//        int[][] mat = new int[][]{{1, 0}, {0, 0}, {1, 0}};
        int k = 3;
        for (int i : kWeakestRows(mat, k)) {
            System.out.println(i);
        }
    }


    /**
     * @param mat
     * @param k
     * @return
     */
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] ret = new int[k];
        int[][] arr = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            //0存放当前矩阵的行数，1存放当前平民第一次出现的位置
            arr[i][0] = i;
            arr[i][1] = binarySearch(mat[i]);
        }
        //排序,如果平民出现位置相同，则按照索引位排序
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i][0];
        }
        return ret;
    }

    /**
     * 二分搜索,找出第一个出现的平民
     *
     * @param arr
     * @return
     */
    public static int binarySearch(int[] arr) {
        //第一个就是平民直接返回
        if (arr[0] == 0) {
            return 0;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //是平民 且上一个是军人
            if (arr[mid] == 0 && arr[mid - 1] == 1) {
                return mid;
            } else if (arr[mid] > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr.length;
    }


    /**
     * 评论
     * 双百方案： 将每一行的士兵数量x1000+索引存到一个新的列表里，然后对这个列表进行排序，取前面的k位对1000取余即是需要的索引值。
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows1(int[][] mat, int k) {
        int[] list = new int[mat.length];
        int[] result = new int[k];
        for (int i = 0; i < mat.length; i++) {
            list[i] = count(mat[i]) * 100 + i;
        }
        Arrays.sort(list);
        for (int i = 0; i < k; i++) {
            result[i] = list[i] % 100;
        }
        return result;
    }

    public int count(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            if (n != 1) {
                break;
            }
            sum += n;
        }
        return sum;
    }
}
