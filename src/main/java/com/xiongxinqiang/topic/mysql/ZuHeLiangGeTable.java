package com.xiongxinqiang.topic.mysql;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/5 9:27 上午
 * <p>
 * 175. 组合两个表
 * <p>
 * 表1: Person
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId 是上表主键
 * <p>
 * <p>
 * 表2: Address
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId 是上表主键
 *
 *
 * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
 * FirstName, LastName, City, State
 *
 */
public class ZuHeLiangGeTable {


    public static void main(String[] args) {
        //select
        //p.FirstName,p.LastName,a.City,a.State
        //from Person as p left join Address as a
        //on p.PersonId = a.PersonId
        String sql = "select \n" +
                "p.FirstName,p.LastName,a.City,a.State\n" +
                "from Person as p left join Address as a\n" +
                "on p.PersonId = a.PersonId";

        System.out.println(sql);


    }


}
