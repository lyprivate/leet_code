package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/7 4:08 下午
 *
 * 985. 查询后的偶数和
 *
 * 给出一个整数数组A和一个查询数组queries。
 *
 * 对于第i次查询，有val =queries[i][0], index= queries[i][1]，我们会把val加到A[index]上。然后，第i次查询的答案是 A 中偶数值的和。
 *
 * （此处给定的index = queries[i][1]是从 0 开始的索引，每次查询都会永久修改数组A。）
 *
 * 返回所有查询的答案。你的答案应当以数组answer给出，answer[i]为第i次查询的答案。
 *
 * 示例：
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 *
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _985_ChaXunHouDeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        for (int i : sumEvenAfterQueries(nums, queries)) {
            System.out.println(i);
        }
    }


    /**
     * 让我们尝试不断调整 S，即每一步操作之后整个数组的偶数和。
     *
     * 我们操作数组中的某一个元素 A[index] 的时候，数组 A 其他位置的元素都应保持不变。
     * 如果 A[index] 是偶数，我们就从 S 中减去它，然后计算 A[index] + val 对 S 的影响（如果是偶数则在 S 中加上它）。
     *
     * @param nums
     * @param queries
     * @return
     */
    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ret = new int[nums.length];
        int S = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                S += nums[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], index = queries[i][1];
            if ((nums[index] & 1) == 0) {
                S -= nums[index];
            }
            nums[index] += val;
            if ((nums[index] & 1) == 0) {
                S += nums[index];
            }
            ret[i] = S;
        }
        return ret;
    }



}
