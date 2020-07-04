import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: 20200704
 * @description
 * @author: Zhang Baolu
 * @create: 2020-07-04 17:54
 **/
public class TestDemo {

    //将人民币数字表示转换为汉字表示

    //阿拉伯数字0-9对应的中文
    static String[] map = {"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String number = scan.next();
            resolve(number);
        }
        scan.close();
    }

    public static void resolve(String str) {
        String[] strArr = str.split("\\.");
        //整数部分
        int number = Integer.valueOf(str.split("\\.")[0]);
        StringBuffer res = new StringBuffer("人民币");
        int yi = (int) (number / 100000000);
        if (yi != 0) {
            res.append(resolveQian(yi)).append("亿");
            number = number - yi * 100000000;
        }
        int wan = (int) (number / 10000);
        if (wan != 0) {
            res.append(resolveQian(wan)).append("万");
            number = number - wan * 10000;
        }
        //处理千百十个位
        String beforePointString = resolveQian(number);
        if (beforePointString.length() > 1) {
            res.append(beforePointString).append("元");
        }
        //若有小数点，处理小数点后面位数
        //小数部分处理
        if (strArr.length > 1) {
            String afterPointStr = strArr[1];
            res.append(handleNumberAfterPoint(afterPointStr));
        }
        //在resolveQian() 方法里可能会返回 零xxx
        //但在最高为不能有"零"
        String resString = res.toString();
        if (resString.length() > 4 && resString.charAt(3) == '零' && resString.charAt(4) != '元') {
        //最高位的零去掉
            resString = resString.substring(0, 3) + resString.substring(4);
        }
        System.out.println(resString);
    }

    //处理4位数 千百十个位
    public static String resolveQian(double temp) {
        StringBuffer resBuffer = new StringBuffer();
        //千位
        int qian = (int) (temp / 1000);
        if (qian != 0) {
            resBuffer.append(map[qian - 1]).append("仟");
            temp = temp - qian * 1000;
        }
        //百位
        int bai = (int) (temp / 100);
        if (bai != 0) {
            resBuffer.append(map[bai - 1]).append("佰");
            temp = temp - bai * 100;
        }
        //注意:零 只会添加在 百位和十位
        if (qian != 0 && bai == 0) {
            resBuffer.append("零");
        }
        //十位
        int shi = (int) (temp / 10);
        if (shi != 0) {
            if (shi != 1) {
                resBuffer.append(map[shi - 1]);
            }
            resBuffer.append("拾");
            temp = temp - shi * 10;
        }
        //注意：0
        if (bai != 0 && shi == 0) {
            resBuffer.append("零");
        }
        //个位
        int ge = (int) (temp % 10);
        if (ge != 0) {
        //5,0001 这种情况，千百十位均为0
            if (qian == 0 && bai == 0 && shi == 0) {
                resBuffer.append("零");
            }
            resBuffer.append(map[ge - 1]);
        }
        String res = resBuffer.toString();
        return res;
    }

    //处理小数点后面的数
    public static String handleNumberAfterPoint(String str) {
        String res = "";
        if (str.equals("00") || str.equals("0")) {
            res = "整";
        } else {
            if (str.charAt(0) != '0') {
                res += map[Integer.valueOf(str.charAt(0) + "") - 1] + "角";
            }
            if (str.length() > 1 && str.charAt(1) != '0') {
                res += map[Integer.valueOf(str.charAt(1) + " ") - 1] + "分";
            }
        }
        return res;
    }

    //守形数是这样一种整数， 它的平方的低位部分等于它本身。比如25的平方是625，低位部分是25，因此25是一个守形数。 编一 个程序，判断N是否为守形数。
    public static int getLow(int num) {
        int i = 1;
        int mod = 0;
        int ret = 0;
        while(num > 10) {
            mod = (num % 10);
            ret += mod *i;
            num /= 10;
            i *= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int S = N * N;
            if(N == getLow(S)) {
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }


    //实现一个投票统计，设置候选人数，候选人名单，投票人数，投票记录，然后进行投票记录的统
    //计，计算出每位候选人的获票数量。
    public static void main2(String args[]){
        //控制台输入数据
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            //候选人人数
            int n = sc.nextInt();
            String[] s = new String[n];
            //记录候选人
            HashMap<String,Integer> hs = new HashMap<String,Integer>();
            for(int i=0;i<n;i++){
                String temp = sc.next();
                hs.put(temp,0);
                s[i] = temp;
            }
            //投票人数
            int m = sc.nextInt();
            Set<String> keys = hs.keySet();
            int cnt = 0;
            for(int i=0;i<m;i++){
                //投票
                String tick = sc.next();
                if(keys.contains(tick)){
                    hs.put(tick, hs.get(tick)+1);
                }else{
                    cnt++;
                }
            }
            //输出结果
            for(String k:s){
                System.out.println(k+" : "+hs.get(k));
            }
            System.out.println("Invalid : "+cnt);
        }
        sc.close();
    }
}

