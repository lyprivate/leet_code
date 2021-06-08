package com.xiongxinqiang.leetcode.stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/10 1:29 下午
 * <p>
 * 496. 下一个更大元素 I
 * <p>
 * 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
 * <p>
 * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。
 * <p>
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * 示例：
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * <p>
 * 提示：
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _496_NextGreaterElement {


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] arr = nextGreaterElement2(nums1, nums2);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    /**
     * 单调栈
     * 执行用时：6 ms, 在所有 Java 提交中击败了44.89%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了86.18%的用户
     * 思路：先对 nums2 中的每一个元素，求出它的右边第一个更大的元素；
     * 将上一步的对应关系放入哈希表（HashMap）中；
     * 再遍历数组 nums1，根据哈希表找出答案。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        //先遍历nums2，将第一个大于当前元素的值，维护到hash表中
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peekFirst() < nums2[i]) {
                map.put(stack.remove(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        //遍历nums1,到hash表取第一个最大值
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }


    /**
     * 老规矩，先上一手暴力解法
     * 执行用时：10 ms, 在所有 Java 提交中击败了12.91%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了57.65%的用户
     * 分析：时间复杂度O(NM) 这里 N 是数组 nums1 的长度， M 是数组 nums2 的长度,最差情况下需要遍历完 nums2 中的每个元素
     * 「暴力解法」时间复杂度高 ，空间复杂度低，优化「暴力解法」的思路是「空间换时间」
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        //第一次遍历nums1
        for (int i = 0; i < nums1.length; i++) {
            //第二次遍历nums2
            for (int j = 0; j < nums2.length; j++) {
                //找到x
                if (nums1[i] == nums2[j]) {
                    int top = ++j, max = -1;
                    //从x 开始遍历,找到右边第一个最大的值
                    while (top <= nums2.length - 1) {
                        if (nums2[top] > nums1[i]) {
                            max = nums2[top];
                            break;
                        }
                        ++top;
                    }
                    arr[i] = max;
                    break;
                }
            }
        }
        return arr;
    }

}
