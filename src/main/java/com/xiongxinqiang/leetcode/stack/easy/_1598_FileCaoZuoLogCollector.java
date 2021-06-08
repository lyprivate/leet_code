package com.xiongxinqiang.leetcode.stack.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/12 11:32 上午
 *
 * 1598. 文件夹操作日志搜集器
 *
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 *
 * 下面给出对变更操作的说明：
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 *
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 *
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 *
 * 示例1：
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 *
 * 示例2：
 * 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 *
 * 示例3：
 * 输入：logs = ["d1/","../","../","../"]
 * 输出：0
 *
 * 提示：
 * 1 <= logs.length <= 103
 * 2 <= logs[i].length <= 10
 * logs[i] 包含小写英文字母，数字，'.' 和 '/'
 * logs[i] 符合语句中描述的格式
 * 文件夹名称由小写英文字母和数字组成
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/crawler-log-folder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1598_FileCaoZuoLogCollector {



    public static void main(String[] args) {
        String[] logs = new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"};
        System.out.println(minOperations(logs));
    }




    /**
     * 无栈操作，1ms 击败100%
     * 思路：统计../出现了多少次，x/出现了多少次, x/ - ../ 就是回到父级的次数
     *
     * @param logs
     * @return
     */
    public static int minOperations(String[] logs) {
        //记录x/操作 - ../操作
        int count = 0;
        for (String log : logs) {
            if (!log.equals("./") && !log.equals("../")) {
                ++count;
            }
            if (log.equals("../")) {
                if (count > 0) {
                    --count;
                }
            }
        }
        return count;
    }
}
