import java.util.*;

/**
 * @program: 20200705
 * @description
 * @author: Zhang Baolu
 * @create: 2020-07-05 11:59
 **/
public class TestDemo {

    //年会抽奖
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            double p = count(n) / fac(n);
            System.out.println(String.format("%.2f", p*100) + "%");
        }
    }
    //计算分母
    public  static double fac(int n){
        if(n==0||n==1){
            return 1;
        }
        return n*fac(n-1);
    }
    //计算分子
    public static double count(int n) {
        if(n == 1) {
            return 0;
        }else if(n == 2) {
            return 1;
        }
        return (n - 1)* (count(n - 1) + count(n - 2));
    }

    //数字和为sum的方法数
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();// 数组长度为n表示n个数字
        int sum = scanner.nextInt();// 部分元素求和sum
        int[] value = new int[n];//初始化数组
        long[] dp = new long[sum + 1];//动态规划数组
        dp[0] = 1;//index=0的初始化值
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
            for (int j = sum; j >= 0; j--) {
                if (j >= value[i]) {
                    dp[j] += dp[j - value[i]];
                }
            }
        }
        System.out.println(dp[sum]);
    }

    /*密码验证合格程序
    1.长度超过8位
    2.包括大小写字母.数字.其它符号,以上四种至少三种
    3.不能有相同长度大于等于2的子串重复*/
    // 1.长度超过8位
    public static boolean checkLength(String password){
        if (password==null || password.length()<=8)
            return false;
        return true;
    }
    // 2.包括大小写字母.数字.其它符号,以上四种至少三种
    public static boolean checkCharKinds(String password){
        int Digit=0 , lowercase=0,uppercase=0,others=0;
        char[] ch = password.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i]>='0'&&ch[i]<='9') {
                Digit=1;
                continue;
            }
            else if (ch[i]>='a'&&ch[i]<='z') {
                lowercase=1;
                continue;
            }
            else if (ch[i]>='A'&&ch[i]<='Z') {
                uppercase=1;
                continue;
            }else {
                others=1;
                continue;
            }
        }
        int total = Digit+lowercase+uppercase+others;
        return total>=3 ? true : false;
    }
    // 3.不能有相同长度超2的子串重复
    public static boolean checkCharRepeat(String password){
        for(int i=0 ;i<password.length()-2 ;i++){
//子串校验
//a.从下标i开始，每次截取2个字符的字符串
//b.从下标i+1开始截取剩余字符构成字符串，判断是否包含a中截取的字符串
//包含说明出现重复，不包含说明没有重复
            String substr1 =password.substring(i, i+3);
            if (password.substring(i+1).contains(substr1))
                return false;
        }
        return true;
    }
    public static void main2(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String psw = cin.nextLine();
            if (checkLength(psw)&&checkCharKinds(psw)&&checkCharRepeat(psw))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
    }

}
