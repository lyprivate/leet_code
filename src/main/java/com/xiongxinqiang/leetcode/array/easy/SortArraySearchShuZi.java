package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/31 1:18 下午
 *
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 示例1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 示例2：
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortArraySearchShuZi {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
//        int[] nums = new int[]{1, 2, 3};
        int target = 2;
        System.out.println(search1(nums, target));
    }


    /**
     * 评论大佬，二分
     * 排序数组 nums 中的所有数字 target 形成一个窗口，记窗口的 左 / 右边界 索引分别为 left 和 right ，分别对应窗口左边 / 右边的首个元素。
     *
     * 本题要求统计数字 target 的出现次数，可转化为：使用二分法分别找到 左边界 left 和 右边界 rightr ，易得数字 target 的数量为 right - left - 1right−left−1 。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }




    /**
     * 双指针，题目主要还是希望看到二分
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) {
            return 1;
        }
        int count = 0;
        for (int i = 0, j = nums.length; i < j; i++, j--) {
            if (nums[i] == target) {
                ++count;
            }
            if (nums[j - 1] == target && i != j - 1) {
                ++count;
            }
        }
        return count;
    }

}
