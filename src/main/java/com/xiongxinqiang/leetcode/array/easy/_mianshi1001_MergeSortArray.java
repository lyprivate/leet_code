package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/9 10:04 上午
 *
 * 面试题 10.01. 合并排序的数组
 *
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化A 和 B 的元素数量分别为m 和 n。
 *
 * 示例：
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 提示：
 * A.length == n + m
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _mianshi1001_MergeSortArray {


    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        merge1(A,m,B,n);
        for (int i : A) {
            System.out.println(i);
        }
    }


    /**
     * 官方题解：方法三：逆向双指针
     * 观察可知，A 的后半部分是空的，可以直接覆盖而不会影响结果。因此可以指针设置为从后向前遍历，每次取两者之中的较大者放进 A 的最后面。
     *
     * 严格来说，在此遍历过程中的任意一个时刻，A 数组中有 m-pa-1− 个元素被放入 A 的后半部，
     * B 数组中有 n-pb-1 个元素被放入 A 的后半部，而在指针 pa 的后面，AA 数组有 m+n−pa−1 个位置。由于
     *
     * m+n−pa−1≥m−pa−1+n−pb−1   等价于  pb≥−1
     *
     * 永远成立，因此 pa 后面的位置永远足够容纳被插入的元素，不会产生 pa 的元素被覆盖的情况。
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge1(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                cur = B[pb--];
            } else if (pb == -1) {
                cur = A[pa--];
            } else if (A[pa] > B[pb]) {
                cur = A[pa--];
            } else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
    }



    /**
     * 先合并，在排序
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        int len = B.length;
        for (int i = 0; i < len; i++) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }


}
