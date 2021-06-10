package com.xiongxinqiang.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/10 9:10 上午
 *
 * 1636. 按照频率将数组升序排序
 *
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 *
 * 请你返回排序后的数组。
 *
 *
 * 示例1：
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 *
 * 示例2：
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 *
 * 示例3：
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 *
 * 提示：
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-increasing-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1636_AnZhaoPingLvArraySortAsc {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3};
//        int[] nums = new int[]{2,3,1,3,2};
//        int[] nums = new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1};
        for (int i : frequencySort(nums)) {
            System.out.println(i);
        }
    }


    public static int[] frequencySort(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        //用哈希表记录每个元素出现的次数
        HashMap<Integer, Integer> hashTable = new HashMap<>(16);
        for (int i = 0,j = nums.length -1; i <= j; i++,j--) {
            hashTable.put(nums[i], hashTable.getOrDefault(nums[i], 0) + 1);
            if (i != j) {
                hashTable.put(nums[j], hashTable.getOrDefault(nums[j], 0) + 1);
            }
        }
        List<Integer> list = new ArrayList<>(hashTable.keySet());
        //排序
        list.sort((o1, o2) -> {
            //判断是否相同
            if (hashTable.get(o1).equals(hashTable.get(o2))) {
                //相同按照本身值大小排序
                //o1 - o2 = ASC   o2 - o1 = DESC
                return o2 - o1;
            }
            return hashTable.get(o1) - hashTable.get(o2);
        });
        int i = 0, j = 0;
        while (j < list.size()) {
            for (int val = 0; val < hashTable.get(list.get(j)); val++) {
                ans[i++] = list.get(j);
            }
            j++;
        }
        return ans;
    }

    /**
     * 思路：频次高位，原值取反（降序），拼接正数。排序后还原原值
     * 题解里的神仙，双百
     * @param nums
     * @return
     */
    public static int[] frequencySort1(int[] nums) {
        int[] cnts = new int[201];
        for (int n : nums){
            cnts[n + 100] ++;
        }
        for (int i = 0; i < nums.length; i ++){
            nums[i] = 10000 * cnts[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++){
            nums[i] = 100 - nums[i] % 10000 ;
        }

        return nums;
    }







}
