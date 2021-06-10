package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/10 1:40 下午
 *
 * 922. 按奇偶排序数组 II
 *
 * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 本人题解：https://leetcode-cn.com/problems/sort-array-by-parity-ii/solution/er-ci-bian-li-yi-ci-bian-li-shuang-zhi-z-7ew4/
 */
public class _922_AnJiOuSortArray {




    public static void main(String[] args) {
        int[] nums = new int[]{400, 200, 501, 701};
//        int[] nums = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
//        int[] nums = new int[]{3,4};
        for (int i : sortArrayByParityII2(nums)) {
            System.out.println(i);
        }
    }


    /**
     * 一次遍历
     * 定义o,j两个指针分别指向偶数索引、奇数索引
     * 一次遍历分别把偶数、奇数放在对应的索引位置上
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int o = 0, j = 1;
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 0) {
                //偶数
                ans[o] = nums[i];
                o += 2;
            } else {
                //奇数
                ans[j] = nums[i];
                j += 2;
            }
        }
        return ans;
    }



    /**
     * 双指针
     * 定义o,j两个指针分别指向偶数索引、奇数索引
     * 遍历时定义2个指针，一个从前往后遍历，一个从后往前遍历
     * 遍历时间复杂度O(n/2)
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII1(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int o = 0, j = 1;
        for (int low = 0, high = len - 1; low <= high; low++, high--) {
            //从前往后找
            if ((nums[low] & 1) == 0) {
                //偶数
                ans[o] = nums[low];
                o += 2;
            } else {
                //奇数
                ans[j] = nums[low];
                j += 2;
            }

            //从后往前找
            if ((nums[high] & 1) == 0) {
                //偶数
                ans[o] = nums[high];
                o += 2;
            } else {
                //奇数
                ans[j] = nums[high];
                j += 2;
            }
        }
        return ans;
    }



    /**
     * 两次遍历
     * 第一次遍历把所有的偶数放在索引为偶数的位置上，第二次遍历就放奇数
     *
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int i = 0;
        //把偶数放在 索引为偶数的位置上
        for (int num : nums) {
            if ((num & 1) == 0) {
                ans[i] = num;
                i += 2;
            }
        }
        i = 1;
        //把奇数放在 索引为奇数的位置上
        for (int num : nums) {
            if ((num & 1) != 0) {
                ans[i] = num;
                i += 2;
            }
        }
        return ans;
    }




}
