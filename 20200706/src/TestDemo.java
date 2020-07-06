import java.util.Scanner;

/**
 * @program: 20200706
 * @description
 * @author: Zhang Baolu
 * @create: 2020-07-06 12:25
 **/
public class TestDemo {

    //给定一句英语， 要求你编写程序，将句中所有单词的顺序颠倒输出。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            String[] result = new String[s.length];
            for(int i = 0; i < result.length; i++) {
                result[i] = s[s.length - i - 1];
                if(i != result.length - 1) {
                    System.out.print(result[i] + " ");
                }else {
                    System.out.println(result[i]);
                }
            }
        }
    }

    //奇偶校验
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            jiQiaoYan(str.toCharArray());//将输入的字符串统一转换为字符数组
        }
    }
    public static void jiQiaoYan(char[] s) {
        int[] result = new int[8];
        for (int i = 0; i < s.length; i++) {
            int n = 0x01;
            int j = 7;
            int sum = 0;
            while (j > 0) { //需要进行7次与运算，得出1的个数 及 二进制形式
                result[j] = (s[i] & n) == 0 ? 0 : 1; //与运算
                if (result[j] == 1) sum++; //个数
                n = n << 1;
                j--;
            }
            if ((sum & 1) == 0) result[0] = 1; //进行校验
            for (int k = 0; k < result.length; k++) {
                System.out.print(result[k]);
            }
            result[0] = 0;
            System.out.println();
        }
    }
}
