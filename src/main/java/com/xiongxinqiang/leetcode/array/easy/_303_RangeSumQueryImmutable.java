package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author X.xq
 * @version 1.0
 * @date 2021/8/25 1:38 下午
 * <p>
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 104
 * -105<= nums[i] <=105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _303_RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }


    /**
     * 基本写法 O(n)
     */
    static class NumArray1 {
        int[] arr;

        public NumArray1(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            while (left <= right) {
                sum += arr[left];
                ++left;
            }
            return sum;
        }
    }

    /**
     * 前缀和写法
     * sumRange(i,j) 复杂度 O(1)
     */
    static class NumArray {

        int[] sum;

        public NumArray(int[] nums) {
            int len = nums.length;
            sum = new int[len + 1];
            for (int i = 0; i < nums.length; i++) {
                //i = nums[i] + nums[i - 1];
                //上一次的和 + 加当前数值
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sum[right + 1] - sum[left];
        }
    }

}
