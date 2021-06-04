package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/24 4:10 下午
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例1:
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 示例2：
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 限制：
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class QueShiDeShuZi {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3};
        System.out.println(missingNumber1(arr));
    }

    //二分法
    public static int missingNumber2(int[] nums) {
        int i = 0, j = nums[nums.length - 1];
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    //双指针
    public static int missingNumber1(int[] nums) {
        int j = nums[nums.length - 1];
        for (int i = 0; i <= j; i++, j--) {
            if (i != nums[i]) {
                return i;
            }
            /*
             * 区分不存在的数字是不是n - 1,
             * 举例：[0,1,2]
             * last idx = 2,last ele = 2
             */
            int val = nums.length - 1 == nums[nums.length - 1] ? nums[j] : nums[j - 1];
            if (val != j) {
                return j;
            }
        }
        return nums.length ;
    }

    //暴力遍历,傻瓜式解法
    public static int missingNumber(int[] nums) {
        int top = 0;
        for (int num : nums) {
            if (num != top) {
                return top;
            }
            top++;
        }
        return top;
    }

}
