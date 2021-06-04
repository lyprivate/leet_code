package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/1 2:55 下午
 *
 * 941. 有效的山脉数组
 *
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * arr.length >= 3
 * 在0 < i< arr.length - 1条件下，存在i使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * 示例1：
 * 输入：arr = [2,1]
 * 输出：false
 *
 * 示例2：
 * 输入：arr = [3,5,5]
 * 输出：false
 *
 * 示例3：
 * 输入：arr = [0,3,2,1]
 * 输出：true
 *
 * 提示：
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidMountainArray {




    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 2};
//        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};
//        int[] arr = new int[]{3, 5, 5};
        int[] arr = new int[]{0, 3, 2, 1};
//        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(validMountainArray1(arr));
    }


    public static boolean validMountainArray1(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        //第一个元素不需要遍历
        int i = 0, n = arr.length;
        //先上山
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            ++i;
        }
        /*
         * 检查是否只存在上山或只存在下山
         * 如果i = 0 说明一直在下山，i = n -1 ，说明一直都在上上
         * 最高点不能是数组的第一个位置或最后一个位置
         */
        if (i == 0 || i == n - 1) {
            return false;
        }
        //目前i就是峰值，开始下山
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            ++i;
        }
        return i == n - 1;
    }


    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int start = 0, end = arr.length - 1;
        while (start < end && arr[start] < arr[start + 1]) {
            start++;
        }
        while (start < end && arr[end] < arr[end - 1]) {
            end--;
        }
        return (start == end) && (start != 0 && end != arr.length - 1);
    }

}
