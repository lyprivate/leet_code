package com.xiongxinqiang.topic.common;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2020/11/28 11:06 上午
 */

/**
 * 猜数字：二分法
 * 力扣编号：374
 */
public class GuessNumber {


    public static void main(String[] args) {
        System.out.println(guessNumber(50000));
    }


    public static int guessNumber(int n) {
        long st = System.currentTimeMillis();
        int count = 0;
        int result = 0;
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = getResult(mid);
            if (res == 0) {
                result = mid;
                break;
            } else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;

            ++count;
        }
        long eT = System.currentTimeMillis();
        System.out.println("耗时：" + (eT - st) + ",毫秒");
        System.out.println("一共猜：" + count + "次");
        return result;
    }

    private static int getResult(int num) {
        int pick = 20000;
        if (num > pick) {
            return -1;//你猜的比我选中的要大
        } else if (num < pick) {
            return 1;//你猜的比我选中的要小
        } else {
            return 0;//猜中
        }
    }

}
