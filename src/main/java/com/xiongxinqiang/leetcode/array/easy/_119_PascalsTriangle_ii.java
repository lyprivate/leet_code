package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/7/7 3:36 下午
 *
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 *   来源：力扣（LeetCode）
 *   链接：https://leetcode-cn.com/problems/pascals-triangle-ii/
 *   著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _119_PascalsTriangle_ii {



    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        res[0] = 1;
        for(int i = 1; i <= rowIndex; i++)
            for(int j = i; j > 0; j--)
                res[j] = i == j ? 1 : res[j] + res[j-1];
        return Arrays.asList(res);
    }


   /* public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            int idx = 0;
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    list.add(1);
                    continue;
                }
                List<Integer> integers = ans.get(i - 2);
                list.add(integers.get(idx) + integers.get(idx + 1));
                ++idx;
            }
            ans.add(list);
        }
        return ans;
    }*/
}
