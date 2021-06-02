package com.xiongxinqiang.noifelse.tacticsfactory;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/17 5:35 下午
 *
 * <p>
 * 策略模式+工厂方法消除if else
 * <p>
 * 设需求为，根据不同勋章类型，处理相对应的勋章服务
 * </p>
 */
public class TacticsFactory {

    public static void main(String[] args) {
        String medalType = "guest";
        service(medalType);
        System.out.println("-----------------");
        MedalServicesFactory.getMedalService(medalType).showMedal();
    }


    private static void service(String medalType) {
        if ("guest".equals(medalType)) {
            System.out.println("嘉宾勋章");
        } else if ("vip".equals(medalType)) {
            System.out.println("会员勋章");
        } else if ("guard".equals(medalType)) {
            System.out.println("展示守护勋章");
        }
    }

}
