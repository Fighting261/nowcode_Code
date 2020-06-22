/**
 * @program: 20200622
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-22 12:13
 **/
import java.util.Scanner;

public class TestDemo {

    /*现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，请设计一个高效算法，对于p中的每一个较短字符串，
    判断其是否为s的子串。给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，每个元素代表p中
    的对应字符串是否为s的子串。保证p中的串长度小于等于8，且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
    测试样例：["a","b","c","d"],4,"abc"
    返回：[true,true,true,false]
    */
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] bool = new boolean[n];
        for(int i = 0; i < n; i++) {
            bool[i] = s.contains(p[i]);
        }
        return bool;
    }

    //洗牌问题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();//数组组数
        while (groups-- > 0) {
            int n = sc.nextInt();//数字个数的一半
            int k = sc.nextInt();//洗牌次数
            int[] res = new int[2 * n];//数据总个数
            for (int i = 0; i < 2 * n; i++) { //遍历数据数组
                int tmp = i + 1;//此处修正内层循环更加temp计算位置
                for (int j = 0; j < k; j++) {
                    if (tmp <= n) {
                        tmp = 2 * tmp - 1;
                    } else {
                        tmp = 2 * (tmp - n);
                    }
                }
                res[tmp - 1] = sc.nextInt();//数组中temp-1的位置的数据，即就是洗牌后的结果
            }
             //输出
            if (res.length > 0) {
                System.out.print(res[0]);
            }
            for (int i = 1; i < 2 * n; i++) {
                System.out.print(" " + res[i]);
            }
            System.out.println();
        }
    }
}

