package com.xiongxinqiang.leetcode.array;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/3 9:51 上午
 *
 * 1550. 存在连续三个奇数的数组
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 * 示例1：
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 *
 * 示例2：
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *
 * 提示：
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 *
 *
 * 链接：https://leetcode-cn.com/problems/three-consecutive-odds/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 */
public class ThreeJiShuDeArray {



    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1};
//        int[] arr = new int[]{1, 3, 2};
        System.out.println(threeConsecutiveOdds(arr));
    }


    /**
     * 暴力
     *
     * @param arr
     * @return
     */
    public static boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i <= arr.length - 3; i++) {
            if ((arr[i] & 1) != 0 && (arr[i + 1] & 1) != 0 && (arr[i + 2] & 1) != 0) {
                return true;
            }
        }
        return false;
    }

}
