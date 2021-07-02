package com.xiongxinqiang;

import java.util.*;
import java.util.concurrent.Executors;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/23 8:59 下午
 *
 * 牛客网10到练习题1(华为OD机考)
 */
public class NiuKeWang1 {



    public static void main(String[] args) {
//        dcsz();
//        searchZsAndMid();
//        searchStr();
//        countStr();
//        capacitySort();
//        area();
//        car();
//        minSum();
//        isChildStr();
//        student();

    }


    /**
     * 10、按身高和体重排队
     * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；
     * 对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
     * 输入描述:
     * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
     * 输出描述:
     * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始
     * 示例1：
     * 输入
     * 4
     * 100 100 120 130
     * 40 30 60 50
     * 输出 2 1 3 4
     * 说明 : 输出的第一个数字2表示此人原始编号为2，即身高为100，体重为30的这个人。由于他和编号为1的人身高一样，但体重更轻，因此要排在1前面。
     * 示例2：
     * 输入
     * 3
     * 90 110 90
     * 45 60 45
     * 输出 1 3 2
     * 说明 : 1和3的身高体重都相同，需要按照原有位置关系让1排在3前面，而不是3 1 2
     */
    public static void student() {
        Scanner in = new Scanner(System.in);
        String size = in.nextLine();
        String[] height = in.nextLine().split(" ");
        String[] weight = in.nextLine().split(" ");
        int[] result = new int[height.length];
        //初始化编号
        for (int i = 0; i < height.length; i++) {
            result[i] = i + 1;
        }
        for (int i = 0; i < weight.length - 1; i++) {
            for (int j = i; j < weight.length - 1; j++) {
                //如果当前学生的身高,大于下一个学生的身高
                if (Integer.parseInt(height[j]) > Integer.parseInt(height[j + 1])) {
                    //编号互换(题目只要求输出编号,身高就没必要换位了)
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                } else if (height[j].compareTo(height[j + 1]) == 0) {
                    //身高相同,按照体重排序
                    if (Integer.parseInt(weight[j]) > Integer.parseInt(weight[j + 1])) {
                        int index = result[j];
                        result[j] = result[j + 1];
                        result[j + 1] = index;
                    }
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }


    /**
     * 9、判断字符串子序列
     * 给定字符串 target和 source, 判断 target 是否为 source 的子序列。
     * 你可以认为 target 和 source 中仅包含英文小写字母。字符串 source可能会很长（长度 ~= 500,000），而 target 是个短字符串（长度 <=100）。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"abc"是"aebycd"的一个子序列，而"ayb"不是）。
     * 请找出最后一个子序列的起始位置。
     * 输入描述:
     * 第一行为target，短字符串（长度 <=100）
     * 第二行为source，长字符串（长度 ~= 500,000）
     * 输出描述:
     * 最后一个子序列的起始位置， 即最后一个子序列首字母的下标
     * 示例1
     * 输入
     * abc
     * abcaybec
     * 输出
     * 3
     * 说明
     * 这里有两个abc的子序列满足，取下标较大的，故返回3
     * 备注:
     * 若在source中找不到target，则输出-1
     */
    public static void isChildStr() {
        Scanner in = new Scanner(System.in);
        char[] target = in.nextLine().toCharArray();
        char[] source = in.nextLine().toCharArray();
        int tLen = target.length;
        int sLen = source.length;
        int firstIdx = 0;
        //因为是求最后一个子序列的首字母起始位置，所以我们后续遍历
        //在source中找到target目标字符就跳出循环，找下一个字符
        //利用hash表存储每个目标字符出现的位置
        //判断哈希表中的字符与目标字符是否一致
        Map<Character, Integer> hashTable = new HashMap<>(tLen);
        if (tLen <= 0 || sLen <= 0) {
            System.out.println(-1);
            return;
        }
        for (int i = tLen - 1; i >= 0; i--) {
            for (int j = sLen - 1; j >= 0; j--) {
                if (target[i] == source[j]) {
                    //命中
                    hashTable.put(source[j], j);
                    break;
                }
            }
        }
        for (char ch : target) {
            if (!hashTable.containsKey(ch)) {
                firstIdx = -1;
            }
        }
        if (firstIdx != -1) {
            System.out.println(hashTable.get(target[0]));
        } else {
            System.out.println(firstIdx);
        }
    }


    /**
     * 8、整数对最小和
     * 给定两个整数数组array1、array2，数组元素按升序排列。假设从array1、array2中分别取出一个元素可构成一对元素，现在需要取出k对元素，并对取出的所有元素求和，计算和的最小值
     * 注意：两对元素如果对应于array1、array2中的两个下标均相同，则视为同一对元素。
     * 输入描述:
     * 输入两行数组array1、array2，每行首个数字为数组大小size(0 < size <= 100);
     * 0 < array1[i] <= 1000
     * 0 < array2[i] <= 1000
     * 接下来一行为正整数k
     * 0 < k <= array1.size() * array2.size()
     * 输出描述:
     * 满足要求的最小和
     * 示例1
     * 输入
     * 3 1 1 2
     * 3 1 2 3
     * 2
     * 输出
     * 4
     * 说明
     * 用例中，需要取2对元素
     * 取第一个数组第0个元素与第二个数组第0个元素组成1对元素[1,1];
     * 取第一个数组第1个元素与第二个数组第0个元素组成1对元素[1,1];
     * 求和为1+1+1+1=4，为满足要求的最小和
     */
    public static void minSum() {
        //8 1 1 2 2 4 7 8 9
        //8 2 3 4 5 6 7 8 9
        Scanner in = new Scanner(System.in);
        String[] sp1 = in.nextLine().split(" ");
        String[] sp2 = in.nextLine().split(" ");
        int k = in.nextInt();
        int[] arr1 = new int[Integer.parseInt(sp1[0])];
        int[] arr2 = new int[Integer.parseInt(sp2[0])];
        for (int i = 0; i < sp1.length - 1; i++) {
            arr1[i] = Integer.parseInt(sp1[i + 1]);
        }
        for (int i = 0; i < sp2.length - 1; i++) {
            arr2[i] = Integer.parseInt(sp2[i + 1]);
        }
        List<Integer> correct = new ArrayList<>();
        for (int num : arr1) {
            int target = binarySearch(arr2, num);
            if (target != -1) {
                correct.add(num * 2);
            }
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += correct.get(i);
        }
        System.out.println(sum);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 7、靠谱的车
     * 程序员小明打了一辆出租车去上班。出于职业敏感，他注意到这辆出租车的计费表有点问题，总是偏大。
     * 出租车司机解释说他不喜欢数字4，所以改装了计费表，任何数字位置遇到数字4就直接跳过，其余功能都正常。
     * 比如：
     * 1.     23再多一块钱就变为25；
     * 2.     39再多一块钱变为50；
     * 3.     399再多一块钱变为500；
     * 小明识破了司机的伎俩，准备利用自己的学识打败司机的阴谋。
     * 给出计费表的表面读数，返回实际产生的费用。
     * <p>
     * 输入描述:
     * 只有一行，数字N，表示里程表的读数。
     * (1<=N<=888888888)。
     * 输出描述:
     * 一个数字，表示实际产生的费用。以回车结束。
     * 示例1：
     * 输入 5
     * 输出 4
     * 说明: 5表示计费表的表面读数。4表示实际产生的费用其实只有4块钱。
     * 示例2：
     * 输入 17
     * 输出 15
     * 说明 : 17表示计费表的表面读数。15表示实际产生的费用其实只有15块钱。
     * 示例3：
     * 输入 100
     * 输出 81
     * 说明: 100表示计费表的表面读数。81表示实际产生的费用其实只有81块钱。
     */
    public static void car() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int ans = N, temp = 0, k = 0, j = 1;
        while (N > 0) {
            if (N % 10 > 4) {
                temp += (N % 10 - 1) * k + j;
            } else {
                temp += (N % 10) * k;
            }
            k = k * 9 + j;
            j *= 10;
            N /= 10;
        }
        System.out.println(ans - temp);
    }


    /**
     * 6、太阳能板最大面积
     * 给航天器一侧加装长方形或正方形的太阳能板（图中的红色斜线区域），需要先安装两个支柱（图中的黑色竖条），再在支柱的中间部分固定太阳能板。
     * 但航天器不同位置的支柱长度不同，太阳能板的安装面积受限于最短一侧的那根支柱长度。如图：
     * 现提供一组整形数组的支柱高度数据，假设每根支柱间距离相等为1个单位长度，计算如何选择两根支柱可以使太阳能板的面积最大。
     * 输入描述:
     * 10,9,8,7,6,5,4,3,2,1
     * 注：支柱至少有2根，最多10000根，能支持的高度范围1~10^9的整数。柱子的高度是无序的，例子中递减只是巧合。
     * 输出描述:
     * 可以支持的最大太阳能板面积：（10米高支柱和5米高支柱之间）
     * 25
     * 示例1
     * 输入
     * 10,9,8,7,6,5,4,3,2,1
     * 输出
     * 25
     * 备注:
     * 10米高支柱和5米高支柱之间宽度为5，高度取小的支柱高也是5，面积为25。任取其他两根支柱所能获得的面积都小于25。所以最大的太阳能板面积为25。
     */
    public static void area() {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split(",");
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = Integer.parseInt(arr[i]);
                int b = Integer.parseInt(arr[j]);
                int c = Math.abs(a - b);
                if (a > b) {
                    if (res < b * c) {
                        res = b * c;
                    }
                } else {
                    if (res < a * c) {
                        res = a * c;
                    }
                }
            }
        }
        System.out.println(res);
    }


    /**
     * 5、磁盘容量排序
     * 磁盘的容量单位常用的有M，G，T这三个等级，它们之间的换算关系为1T = 1024G，1G = 1024M，现在给定n块磁盘的容量，
     * 请对它们按从小到大的顺序进行稳定排序，例如给定5块盘的容量，1T，20M，3G，10G6T，3M12G9M排序后的结果为20M，3G，3M12G9M，1T，10G6T。
     * 注意单位可以重复出现，上述3M12G9M表示的容量即为3M+12G+9M，和12M12G相等。
     * 输入描述:
     * 输入第一行包含一个整数n(2 <= n <= 100)，表示磁盘的个数，接下的n行，每行一个字符串(长度大于2，小于30)，表示磁盘的容量，由一个或多个格式为mv的子串组成，其中m表示容量大小，v表示容量单位，例如20M，1T，30G，10G6T，3M12G9M。
     * 磁盘容量m的范围为1到1024的正整数，容量单位v的范围只包含题目中提到的M，G，T三种，换算关系如题目描述。
     * 输出描述:
     * 输出n行，表示n块磁盘容量排序后的结果。
     * 示例1：
     * 输入3 1G 2G 1024M
     * 输出1G 1024M 2G
     * 说明 1G和1024M容量相等，稳定排序要求保留它们原来的相对位置，故1G在1024M之前
     * 示例2：
     * 输入 3 2G4M 3M2G 1T
     * 输出 3M2G 2G4M 1T
     * 说明
     * 1T的容量大于2G4M，2G4M的容量大于3M2G
     */
    public static void capacitySort() {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            strList.add(in.next());
        }
        Map<Character, Integer> unit = new HashMap<Character, Integer>() {
            {
                put('M', 1);
                put('G', 1024);
                put('T', 1024 * 1024);
            }
        };
        LinkedHashMap<String, Integer> hashTable = new LinkedHashMap<>();
        for (String str : strList) {
            int left = 0, right;
            int sum = 0;
            for (int i = 1; i < str.length(); i++) {
                if (unit.containsKey(str.charAt(i))) {
                    right = i - 1;
                    int num = getNum(str, left, right);
                    sum += num * unit.get(str.charAt(i));
                    left = i + 1;
                }
            }
            hashTable.put(str, sum);
        }
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };
        List<Map.Entry<String, Integer>> ans = new ArrayList<>(hashTable.entrySet());
        Collections.sort(ans, comparator);
        for (Map.Entry<String, Integer> entry : ans) {
            System.out.print(entry.getKey() + " ");
        }
    }

    private static int getNum(String str, int left, int right) {
        String num = "";
        while (left <= right) {
            num = num + str.charAt(left++) + "";
        }
        return Integer.parseInt(num);
    }

    /**
     * 4、字符串统计
     * 给定两个字符集合，一个为全量字符集，一个为已占用字符集。已占用的字符集中的字符不能再使用，要求输出剩余可用字符集。
     * 输入描述:
     * 1、输入为一个字符串，一定包含@符号。@前的为全量字符集，@后的字为已占用字符集。
     * 2、已占用字符集中的字符一定是全量字符集中的字符。字符集中的字符跟字符之间使用英文逗号分隔。
     * 3、每个字符都表示为字符加数字的形式，用英文冒号分隔，比如a:1，表示1个a字符。
     * 4、字符只考虑英文字母，区分大小写，数字只考虑正整形，数量不超过100。
     * 5、如果一个字符都没被占用，@标识仍然存在，例如a:3,b:5,c:2@
     * 输出描述:
     * 输出可用字符集，不同的输出字符集之间回车换行。
     * 注意，输出的字符顺序要跟输入一致。不能输出b:3,a:2,c:2
     * 如果某个字符已全被占用，不需要再输出。
     * 示例1
     * 输入
     * a:3,b:5,c:2@a:1,b:2
     * 输出
     * a:2,b:3,c:2
     * 说明
     * 全量字符集为3个a，5个b，2个c。
     * 已占用字符集为1个a，2个b。
     * 由于已占用字符不能再使用，因此，剩余可用字符为2个a，3个b，2个c。
     * 因此输出a:2,b:3,c:2
     */
    public static void countStr() {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String[] split = text.split("@");
        if (split.length < 2) {
            System.out.println(split[0]);
            return;
        }
        HashMap<Character, Integer> hashTable = new HashMap<>(16);
        for (String str : split[1].split(",")) {
            hashTable.put(str.charAt(0), Integer.parseInt(String.valueOf(str.charAt(str.length() - 1))));
        }
        String[] allStr = split[0].split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < allStr.length; i++) {
            String str = allStr[i];
            Integer useV = hashTable.getOrDefault(str.charAt(0), 0);
            int allV = Integer.parseInt(String.valueOf(str.charAt(str.length() - 1)));
            if (allV - useV > 0) {
                sb.append(str.charAt(0)).append(":").append(allV - useV);
                if (i != allStr.length - 1) {
                    sb.append(",");
                }
            }
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }


    /**
     * 3、寻找相同子串
     * 给你两个字符串 t 和 p ，要求从 t 中找到一个和 p 相同的连续子串，并输出该字串第一个字符的下标。
     * 输入描述:
     * 输入文件包括两行，分别表示字符串 t 和 p ，保证 t 的长度不小于 p ，且 t 的长度不超过1000000，p 的长度不超过10000。
     * 输出描述:
     * 如果能从 t 中找到一个和 p 相等的连续子串，则输出该子串第一个字符在t中的下标（下标从左到右依次为1,2,3,…）；
     * 如果不能则输出”No”；如果含有多个这样的子串，则输出第一个字符下标最小的。
     * 示例1
     * 输入
     * AVERDXIVYERDIAN
     * RDXI
     * 输出
     * 4
     */
    public static void searchStr() {
        Scanner in = new Scanner(System.in);
        String t = in.nextLine();
        String p = in.nextLine();
        //方法1
        int idx = t.indexOf(p);
        if (idx == -1) {
            System.out.println("No");
        } else {
            System.out.println(idx + 1);
        }
        //方法2
        /*char[] chars = t.toCharArray();
        int i = 0, n = chars.length - 1;
        while (i <= n) {
            if (chars[i] == p.charAt(0)) {
                //找到第一个字符
                int temp = i + 1;
                StringBuilder sb = new StringBuilder();
                for (int i1 = 0; i1 < p.length(); i1++) {
                    sb.append(chars[i++]);
                }
                if (sb.toString().equals(p)) {
                    System.out.println(temp);
                    return;
                }
            }
            ++i;
        }
        System.out.println("No");*/
    }


    /**
     * 2、查找众数及中位数
     * 众数是指一组数据中出现次数量多的那个数，众数可以是多个
     * 中位数是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数
     * 查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数
     * 输入描述:
     * 输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
     * 输出描述:
     * 输出众数组成的新数组的中位数
     * 示例1：
     * 输入
     * 10 11 21 19 21 17 21 16 21 18 15
     * 输出
     * 21
     * 示例2：
     * 输入
     * 2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
     * 输出
     * 3
     * 示例3：
     * 输入
     * 5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
     * 输出
     * 7
     */
    public static void searchZsAndMid() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] split = str.split(" ");
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (String num : split) {
            map.put(Integer.parseInt(num), map.getOrDefault(Integer.parseInt(num), 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                for (int i = 0; i < entry.getValue(); i++) {
                    ans.add(entry.getKey());
                }
            }
        }
        ans.sort(Integer::compareTo);
        int len = ans.size();
        if ((len & 1) != 0) {
            System.out.println(ans.get(len / 2));
            return;
        }
        System.out.println((ans.get(len / 2) + ans.get(len / 2 - 1)) / 2);
    }


    /**
     * 1、求解连续数列
     * 求解连续数列
     * 已知连续正整数数列{K}=K1,K2,K3...Ki的各个数相加之和为S，i=N (0<S<100000, 0<N<100000), 求此数列K。
     * 输入描述:
     * 输入包含两个参数，1）连续正整数数列和S，2）数列里数的个数N。
     * 输出描述:
     * 如果有解输出数列K，如果无解输出-1
     * 示例1
     * 输入 525 6
     * 输出 85 86 87 88 89 90
     * 示例2
     * 输入 3 5
     * 输出- 1
     */
    public static void dcsz() {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        int N = in.nextInt();
        // sum(x x+1 x+2 ... x+n-1) = sum
        //525 = 6 * x + 6 * (6 - 1) / 2
        // n*x + n*(n-1)/2 = sum
        // x= [sum - n*(n-1)/2 ]/n
        //减去尾差
        int sum = S - N * (N - 1) / 2;
        //此时sum如果不是X*N的和就输出-1
        if (sum != 0 && (sum & 1) != 0) {
            System.out.println(-1);
            return;
        }
        //数列的第一位数
        int begin = sum / N;
        for (int i = 0; i < N; i++) {
            System.out.print(begin + i);
            System.out.print(" ");
        }
    }

}
