/**
 * @program: 20200621
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-21 16:54
 **/
import java.util.Scanner;

public class TestDemo {

    /*小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。对于小易所处的当前位置x，他
    只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多
    100,000次。贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。
    小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。*/
    public static void main1(String[] args){
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()) {
                long x = sc.nextInt();
                int count = 0;
                while(x!=0 && count<=300000){
                    x = (2*x+1)%1000000007;
                    count++;
                }
                count = (count+2)/3;
                System.out.println(count >100000 ? -1 : count);
            }
        }
 
/*    一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下：我每天给你10 万元，你第一天给我1 分钱，
    第二天2 分钱，第三天4 分钱……这样交换 30 天后，百万富翁交出了多少钱？陌生人交出了多少钱？（注意一个是万元，一个是分）*/
    public static void main2(String[] args) {
        int x = 10;
        int y = 1;
        int sum =0;
        for(int i = 0; i < 30; i++) {
            sum +=y;
            y *= 2;
        }
        System.out.print(30*x + " " + sum);
    }


}

