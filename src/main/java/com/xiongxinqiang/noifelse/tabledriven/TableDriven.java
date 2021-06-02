package com.xiongxinqiang.noifelse.tabledriven;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/17 3:15 下午
 * <p>
 * 方式一：表驱动
 * 介绍：对于逻辑表达模式固定的 if...else 代码，可以通过某种映射关系，将逻辑表达式用表格的方式表示；
 * 再使用表格查找的方式，找到某个输入所对应的处理函数，使用这个处理函数进行运算。
 * </p>
 * <p>
 * 适用场景
 * 逻辑表达模式固定的 if...else
 * </p>
 */
public class TableDriven {

    public static void main(String[] args) {
        System.out.println(optimizationBefore("张三"));
        System.out.println("------------------------------");
        System.out.println(optimizationAfter("张三"));

    }


    /**
     * 优化前
     * 某种表达式执行某一链函数
     *
     * @return 该用户住址
     */
    private static String optimizationBefore(String name) {
        if (name.equals("张三")) {
            return myNameIsZS(name);
        } else if (name.equals("李四")) {
            return myNameIsLS(name);
        } else if (name.equals("王五")) {
            return myNameIsWW(name);
        }
        return "key有误";
    }


    /**
     * 优化后
     * 某种表达式执行某一链函数
     *
     * @return 该用户住址
     */
    private static String optimizationAfter(String name) {
        Map<String, Function<String, String>> actionMappings = new HashMap<>(16);
        actionMappings.put("张三", (someParams) -> { return myNameIsZS(someParams); });
        actionMappings.put("李四", (someParams) -> { return myNameIsLS(someParams); });
        actionMappings.put("王五", (someParams) -> { return myNameIsWW(someParams); });;
        return actionMappings.get(name).apply(name);
    }

    private static String myNameIsWW(String name) {
        String address = "北京";
        System.out.println("我的名字叫：" + name);
        System.out.println("今年18岁");
        return address;
    }

    private static String myNameIsLS(String name) {
        String address = "上海";
        System.out.println("我的名字叫：" + name);
        System.out.println("今年19岁");
        return address;
    }

    private static String myNameIsZS(String name) {
        String address = "深圳";
        System.out.println("我的名字叫：" + name);
        System.out.println("今年20岁");
        return address;
    }

}
