package com.xiongxinqiang.leetcode.queue.easy;

import java.util.*;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/4/9 6:25 下午
 *
 * 933. 最近的请求次数
 * 题目描述不友好,简单来说就是,每次调用Ping()方法会给一个t,返回 t 到 t-3000 中间所有的请求数量
 *
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 *
 * 1 <= t <= 109
 * 保证每次对 ping 调用所使用的 t 值都 严格递增
 * 至多调用 ping 方法 10^4 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 测试提交
 */
public class ZuiJinRequestCount {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));// requests = [1]，范围是 [-2999,1]，返回 1
        System.out.println(recentCounter.ping(100));// requests = [1, 100]，范围是 [-2900,100]，返回 2
        System.out.println(recentCounter.ping(3001)); // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        System.out.println(recentCounter.ping(3002)); // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3

    }

}
class RecentCounter {

    //java ArrayDeque
    private ArrayDeque<Integer> queue1 = new ArrayDeque();

    int idx = -1;
    private static int[] queue = new int[10000];

    Queue<Integer> q;


    public RecentCounter() {
        q = new LinkedList();
    }

    /**
     * 27 ms ,47mb
     * 解析：妈的，这就是吃了没用过的亏。 将t添加到元素,然后循环将 小于t - 3000 毫秒之前的请求删除,最后返回长度
     * 官方
     * 方法一：队列
     * 我们只会考虑最近 3000 毫秒到现在的 ping 数，因此我们可以使用队列存储这些 ping 的记录。
     * 当收到一个时间 t 的 ping 时，我们将它加入队列，并且将所有在时间 t - 3000 之前的 ping 移出队列。
     *
     * @param t
     * @return
     */
    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }


    /**
     * 1041 ms,内存	46.9 MB
     *
     * @param t
     * @return
     */
    public int ping1(int t) {
        if (idx == -1) {
            Arrays.fill(queue, Integer.MAX_VALUE);
        }
        ++idx;
        queue[idx] = t;
        int reqCount = 0;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] >= (t - 3000) && queue[i] <= t) ++reqCount;
        }
        return reqCount;
    }

    /**
     * 2005 ms,内存	46.2 MB
     */
    public int ping2(int t) {
        queue1.add(t);
        int start = t - 3000;
        int end = t;
        int reqCount = 0;
        Iterator<Integer> iterator = queue1.iterator();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (val >= start && val <= end) ++reqCount;
        }
        return reqCount;
    }
}
