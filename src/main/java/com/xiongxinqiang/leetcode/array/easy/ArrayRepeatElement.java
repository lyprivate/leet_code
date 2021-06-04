package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/31 9:28 上午
 * <p>
 * 剑指 Offer 03. 数组中重复的数字
 * <p>
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * 2 <= n <= 100000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayRepeatElement {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber1(arr));
    }


    /**
     * 计数法
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            if (arr[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }


    /**
     * 排序后遍历，修改了原数据结构
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 官方题解，利用set
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber3(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }


    /**
     * 遍历 超时
     * 空间复杂度O(1),时间复杂度o(n^2)
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                if (nums[i] == nums[i + 1]) {
                    return nums[i];
                }
                int j = i + 1;
                while (j <= nums.length - 1) {
                    if (nums[i] == nums[j]) {
                        return nums[i];
                    }
                    ++j;
                }
            }
        }
        return 0;
    }

}
