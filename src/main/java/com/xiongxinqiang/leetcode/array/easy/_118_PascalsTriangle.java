package com.xiongxinqiang.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/7/7 2:17 下午
 * <p>
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _118_PascalsTriangle {


    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
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
    }

}
