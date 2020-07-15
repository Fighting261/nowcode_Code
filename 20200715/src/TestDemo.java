import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ program: 20200715
 * @ Description：
 * @ CreateTime：2020/7/15 9:55
 * @ Author：Mr Zhang
 */
public class TestDemo {


/*    有一个由很多木棒构成的集合，每个木棒有对应的长度，请问能否用集合中的这些木棒以某个顺序首尾相连构成一个面积大于 0 的简单多边形且所有木棒都要用上，
    简单多边形即不会自交的多边形。初始集合是空的，有两种操作，要么给集合添加一个长度为 L 的木棒，要么删去集合中已经有的某个木棒。每次操作结束后你都需
    要告知是否能用集合中的这些木棒构成一个简单多边形。
*/
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();//操作次数
            int sum = 0;
            int max = 0;
            List<Integer>list  = new ArrayList<>() ;
            while(n-- > 0) {
                int i = sc.nextInt();//操作动作
                int L = sc.nextInt();//长度
                if(i == 1) {
                    list.add(L);
                    sum += L;
                }else {
                    list.remove(list.indexOf(L));
                    sum -= L;
                }
                Collections.sort(list);
                if(list.size() > 0) {
                    max = list.get(list.size() - 1);
                }
                if(sum - max > max) {
                    System.out.println("Yes");
                }else {
                    System.out.println("No");
                }
            }
        }
    }


/*  已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
    假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机
    会都放弃，收益为0。 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
*/
    public static int calculateMax(int[] prices) {
        int firstBuy = Integer.MAX_VALUE; // 第一次买入最好的价格，越低越好
        int firstSell = 0; // 第一次卖出后的最高收益，越高越好
        int secondBuy = Integer.MIN_VALUE; // 第二次买入时还剩余的最高收益，越高越好
        int secondSell = 0; // 第二次卖出时总的最高收益，越高越好
        for (int price : prices) {  //3,8,5,1,7,8
            // 当前价格下第一次买入的价格
            firstBuy = Math.min(firstBuy, price);  //1
            // 当前价格 - 买入价格 就是当前价格下第一次买卖的收益
                    firstSell = Math.max(firstSell, price - firstBuy);  //7
            // 第一次卖出的收益 - 当前价格，即当前价格下，第二次买入后还剩余收益
            secondBuy = Math.max(secondBuy, firstSell - price);  // 4
            // 剩余收益 + 当前价格，即当前价格下，第二次买卖的收益
            secondSell = Math.max(secondSell, secondBuy + price);  //12
        }
        return secondSell;  //12
    }

    //进制转换
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            long num = 0;
            for (int i = 2; i < line.length(); i++) {
                num *= 16;
                char ch = line.charAt(i);
                int n = 0;
                if (ch >= 'A' && ch <= 'F') {
                    n = ch - 'A' + 10;
                } else if (ch >= 'a' && ch <= 'f') {
                    n = ch - 'a' + 10;
                } else {
                    n = ch - '0';
                }
                num += n;
            }
            System.out.println(num);
        }
    }
}
