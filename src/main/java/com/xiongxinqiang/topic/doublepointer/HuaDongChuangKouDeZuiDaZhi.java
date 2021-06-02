package com.xiongxinqiang.topic.doublepointer;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/11 10:56 上午
 * <p>
 * <p>
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例：
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HuaDongChuangKouDeZuiDaZhi {


    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(arr, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        long et = System.currentTimeMillis();
        System.out.println(et - st);
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || k > nums.length) {
            return new int[0];
        }
        int i = 0, j = k - 1;
        int[] res = new int[nums.length - k + 1];
        while (nums.length - 1 >= j) {
            int max = nums[i];
            for (int i1 = i; i1 <= j; i1++) {
                max = (nums[i1] >= max) ? nums[i1] : max;
            }
            res[i] = max;
            ++i;
            ++j;
        }
        return res;
    }


}
