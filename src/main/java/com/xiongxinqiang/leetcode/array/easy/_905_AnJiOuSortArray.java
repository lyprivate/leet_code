package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/10 2:42 下午
 *
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中，A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _905_AnJiOuSortArray {


    public static void main(String[] args) {
//        int[] nums = new int[]{3,1,2,4};
        int[] nums = new int[]{1};
        for (int i : sortArrayByParity(nums)) {
            System.out.println(i);
        }
    }


    /**
     * 定义2个指针，偶数放到前面，奇数放到后面
     * 遍历时双指针，一个向前遍历，一个向后遍历
     * 时间复杂度O(n/2)
     * @param nums
     * @return
     */
    public static int[] sortArrayByParity(int[] nums) {
        //一次遍历
        int len = nums.length;
        int[] ans = new int[len];
        int o = 0, j = len - 1;
        for (int low = 0, high = len - 1; low <= high; low++, high--) {
            if ((nums[low] & 1) == 0) {
                ans[o++] = nums[low];
            }else {
                ans[j--] = nums[low];
            }
            if (low != high) {
                if ((nums[high] & 1) == 0) {
                    ans[o++] = nums[high];
                }else {
                    ans[j--] = nums[high];
                }
            }
        }
        return ans;
    }

}
