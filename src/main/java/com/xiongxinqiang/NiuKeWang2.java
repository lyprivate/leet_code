package com.xiongxinqiang;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/24 9:45 上午
 * <p>
 * 牛客网10到练习题2(华为OD机考)
 */
public class NiuKeWang2 {



    public static void main(String[] args) {
//        transport();
        tlv();
//        recording();
//        stringSplit();
//        maxNum();
        Scanner in = new Scanner(System.in);
        String strs = in.nextLine();
        String target = in.next();
        Map<Character,Integer> hashTable = new HashMap(16);
        for(int i = 0; i < strs.length();++i){
            char ch = strs.charAt(i);
            hashTable.put(ch,hashTable.getOrDefault(ch,0) + 1);
        }
        int count;
        char ch = target.charAt(0);
        if (ch >= 'a' && ch <= 'z') {
            count = (hashTable.get(ch) != null ? hashTable.get(ch) : 0) + (hashTable.get(target.toUpperCase().charAt(0)) != null ?
                    hashTable.get(target.toUpperCase().charAt(0)) : 0);
        }else if (ch >= 'A' && ch <= 'Z'){
            count = (hashTable.get(ch) != null ? hashTable.get(ch) : 0) + (hashTable.get(target.toLowerCase().charAt(0)) != null ?
                    hashTable.get(target.toLowerCase().charAt(0)) : 0);
        }else {
            count = hashTable.get(ch) != null ? hashTable.get(ch) : 0;
        }
        System.out.println(count);
    }

    /**
     * 5、组成最大数
     * 小组中每位都有一张卡片，卡片上是6位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。
     * 输入描述:
     * “,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多25个人
     * 输出描述:
     * 最大的数字字符串
     * 示例1
     * 输入
     * 22,221
     * 输出
     * 22221
     * 示例2
     * 输入
     * 4589,101,41425,9999
     * 4589,101,45895,9999
     * 输出
     * 9999458941425101
     */
    public static void maxNum() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(",");
        String sum = "";
        for (int i = 0; i < s.length-1; i++) {
            for (int j = i+1; j < s.length ; j++) {
                String s1 = s[i].length() >= s[j].length() ? s[i] : s[j];
                String s2 = s[i].length() < s[j].length() ? s[i] : s[j];
                for (int k = 0; k < s2.length(); k++) {
                    if ((k == s2.length() - 1) && (s1.charAt(k) == s2.charAt(k))) {
                        if (k == s1.length() - 1) {
                            break;
                        } else if ((s1.charAt(k + 1) < s2.charAt(0))) {
                            String s3 = s1;
                            s1 = s2;
                            s2 = s3;
                            break;
                        }
                    } else {
                        if (s1.charAt(k) < s2.charAt(k)) {
                            String s3 = s1;
                            s1 = s2;
                            s2 = s3;
                            break;
                        }else if (s1.charAt(k) > s2.charAt(k)) {
                            break;
                        }
                    }
                }
                s[i]=s1;
                s[j]=s2;
            }
        }
        for (int i = 0; i <s.length ; i++) {
            sum+=s[i];
        }
        System.out.println(sum);
       /* Scanner in = new Scanner(System.in);
        String[] content = in.next().split(",");
        for (int i = 0; i < content.length; i++) {
            int len1 = content[i].length();
            int pos = 0, j = i + 1;
            for (; j < content.length; ) {
                int len2 = content[j].length();
                int valI, valJ;
                valI = pos >= len1 ? Integer.parseInt(String.valueOf(content[i].charAt(len1 - 1))) : Integer.parseInt(String.valueOf(content[i].charAt(pos)));
                valJ = pos >= len2 ? Integer.parseInt(String.valueOf(content[j].charAt(len2 - 1))) : Integer.parseInt(String.valueOf(content[j].charAt(pos)));
                if (valJ > valI) {
                    String temp = content[i];
                    content[i] = content[j];
                    content[j] = temp;
                    ++j;
                } else if (valJ == valI) {
                    pos++;
                } else {
                    ++j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : content) {
            sb.append(s);
        }
        System.out.println(sb.toString());*/
    }


    /**
     * 4、字符串分割
     * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
     * 对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；反之，
     * 如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
     * <p>
     * 输入描述:
     * 输入为两行，第一行为参数K，第二行为字符串S。
     * 输出描述:
     * 输出转换后的字符串。
     * 示例1
     * 输入
     * 3
     * 12abc-abCABc-4aB@
     * 输出
     * 12abc-abc-ABC-4aB-@
     * 说明
     * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每3个字符一组为abC、ABc、4aB、@，abC中小写字母较多，转换为abc，
     * ABc中大写字母较多，转换为ABC，4aB中大小写字母都为1个，不做转换，@中没有字母，连起来即12abc-abc-ABC-4aB-@
     * 示例2
     * 输入
     * 12
     * 12abc-abCABc-4aB@
     * 输出
     * 12abc-abCABc4aB@
     * 说明
     * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每12个字符一组为abCABc4aB@，这个子串中大小写字母都为4个，不做转换，连起来即12abc-abCABc4aB@
     */
    public static void stringSplit() {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        String[] strs = in.next().split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0] + "-");
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == count) {
                sb.append(conversion(strs[i]) + "-");
                continue;
            }
            String str = "";
            for (int n = i; n < strs.length; n++) {
                str = str + strs[n];
            }
            StringBuilder stringBuilder = new StringBuilder();
            int temp = 0;
            for (int j = 0; j < str.length(); j++) {
                stringBuilder.append(str.charAt(j));
                temp++;
                if (temp == count || j == str.length() - 1) {
                    sb.append(conversion(stringBuilder.toString()) + "-");
                    temp = 0;
                    stringBuilder = new StringBuilder();
                }
            }
            break;
        }
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }

    public static String conversion(String str) {
        char[] chars = str.toCharArray();
        int big = 0;
        int small = 0;
        for (char ch : chars) {
            if (ch >= 'a' && ch <= 'z') {
                ++small;
            }
            if (ch >= 'A' && ch <= 'Z') {
                ++big;
            }
        }
        if (big - small > 0) {
            return str.toUpperCase();
        } else if (small - big > 0) {
            return str.toLowerCase();
        }
        return str;
    }


    /**
     * 练习题-字符串：
     * 3、考勤信息
     * 公司用一个字符串来表示员工的出勤信息：
     * absent：缺勤
     * late：迟到
     * leaveearly：早退
     * present：正常上班
     * 现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下：
     * 缺勤不超过一次；没有连续的迟到/早退；任意连续7次考勤，缺勤/迟到/早退不超过3次
     * 输入描述:
     * 用户的考勤数据字符串，记录条数 >= 1；输入字符串长度<10000；不存在非法输入
     * 如：
     * 2
     * present
     * present absent present present leaveearly present absent
     * 输出描述:
     * 根据考勤数据字符串，如果能得到考勤奖，输出"true"；否则输出"false"，对于输入示例的结果应为：
     * true false
     * 示例1：
     * 输入
     * 2
     * present
     * present present
     * 输出
     * true true
     * 示例2：
     * 输入
     * 2
     * present
     * present absent present present leaveearly present absent
     * 输出
     * true false
     */
    public static void recording() {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String[] info = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            String s = sc.nextLine();
            info[i] = s;
        }
        Map<String, String> dir = new HashMap<String, String>() {{
            put("absent", "absent");
            put("late", "late");
            put("leaveearly", "leaveearly");
        }};
        List<Boolean> ans = new ArrayList<>();
        for (String str : info) {
            // * absent：缺勤
            //     * late：迟到
            //     * leaveearly：早退
            //     * present：正常上班
            int absentCount = 0;
            boolean ret = true;
            String[] contents = str.split(" ");
            for (int i = 0; i < contents.length; i++) {
                if ("absent".equals(contents[i])) {
                    absentCount++;
                }
                //缺勤>1
                if (absentCount > 1) {
                    ret = false;
                    ans.add(false);
                    break;
                }
                //连续迟到早退
                if (i != contents.length - 1) {
                    boolean flag = ("late".equals(contents[i]) || "leaveearly".equals(contents[i])) && ("late".equals(contents[i + 1]) || "leaveearly".equals(contents[i + 1]));
                    if (flag) {
                        ret = false;
                        ans.add(false);
                        break;
                    }
                }
                if (contents.length - i >= 7) {
                    int errCount = 0;
                    //近7次考勤
                    int n = i;
                    for (int j = 0; j < 7; j++) {
                        if (dir.containsKey(contents[n])) {
                            ++errCount;
                        }
                        ++n;
                    }
                    if (errCount > 3) {
                        ret = false;
                        ans.add(false);
                        break;
                    }
                }
            }
            if (ret) {
                ans.add(true);
            }
        }
        for (Boolean an : ans) {
            System.out.print(an + " ");
        }
    }


    /**
     * 2、TLV解码
     * TLV编码是按[Tag Length Value]格式进行编码的，一段码流中的信元用Tag标识，Tag在码流中唯一不重复，Length表示信元Value的长度，Value表示信元的值。
     * 码流以某信元的Tag开头，Tag固定占一个字节，Length固定占两个字节，字节序为小端序。
     * 现给定TLV格式编码的码流，以及需要解码的信元Tag，请输出该信元的Value。
     * 输入码流的16机制字符中，不包括小写字母，且要求输出的16进制字符串中也不要包含小写字母；码流字符串的最大长度不超过50000个字节。
     * 输入描述:
     * 输入的第一行为一个字符串，表示待解码信元的Tag；
     * 输入的第二行为一个字符串，表示待解码的16进制码流，字节之间用空格分隔。
     * 输出描述:
     * 输出一个字符串，表示待解码信元以16进制表示的Value。
     * 示例1：
     * 输入
     * 31
     * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
     * 输出
     * 32 33
     * 说明
     * 需要解析的信元的Tag是31，从码流的起始处开始匹配，Tag为32的信元长度为1（01 00，小端序表示为1）；
     * 第二个信元的Tag是90，其长度为2；第三个信元的Tag是30，其长度为3；第四个信元的Tag是31，其长度为2（02 00），所以返回长度后面的两个字节即可，即32 33。
     */
    public static void tlv() {
        Scanner in = new Scanner(System.in);
        String key = in.nextLine();
        String tag = in.next();
        String[] arr = in.nextLine().replaceAll("[a-z]", "").split("[ ]");
        int length;
        String value = "";
        for (int i = 0; i < arr.length; ) {
            tag = "";
            length = 0;
            value = "";
            tag = arr[i];
            length = Integer.valueOf(arr[i + 2] + arr[i + 1], 16);
            for (int j = 1; j <= length; j++) {
                value += arr[i + 2 + j] + " ";
            }
            if (key.equals(tag)) {
                System.out.println(value.trim());
            }
//				System.out.println(tag+" "+length+" "+value.trim());
            i = i + 2 + length + 1;
        }
    }


    /**
     * 1、快递运输
     * 一辆运送快递的货车，运送的快递均放在大小不等的长方体快递盒中，为了能够装载更多的快递，同时不能让货车超载，需要计算最多能装多少个快递。
     * 注：快递的体积不受限制，快递数最多1000个，货车载重最大50000。
     * 输入描述:
     * 第一行输入每个快递的重量，用英文逗号分隔，如：5,10,2,11
     * 第二行输入货车的载重量，如：20
     * 不需要考虑异常输入。
     * 输出描述:
     * 输出最多能装多少个快递，如：3
     * 示例1：
     * 输入
     * 5,10,2,11,2
     * 20
     * 输出
     * 3
     * 说明
     * 货车的载重量为20，最多只能放三个快递5、10、2，因此输出3
     */
    public static void transport() {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int weight = in.nextInt();
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);
        int count = 0, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            if (temp < weight) {
                ++count;
            } else {
                System.out.println(count);
                return;
            }
        }
        System.out.println(count);
    }

}
