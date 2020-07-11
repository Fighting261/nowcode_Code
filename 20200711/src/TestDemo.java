import java.util.HashMap;
import java.util.Scanner;

/**
 * @ program: 20200711
 * @ Description：
 * @ CreateTime：2020/7/11 18:27
 * @ Author：Mr Zhang
 */
public class TestDemo {

    //输入-行字符串，计算其中A-Z大写字母出现的次数
    public static void main1(String[] args) {

       Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            HashMap<Character,Integer> alph = new HashMap<>();
            for(int i = 0; i < 26; i++) {
                char ch = (char)('A' + i);
                alph.put(ch,0);
            }
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch >= 'A' && ch <= 'Z') {
                    alph.put(ch,alph.get(ch) + 1);
                }
            }
            for(int i=0; i<26; i++)
            {
                char ch = (char)('A' + i);
                System.out.println(ch + ":" + alph.get(ch));
            }
        }
    }

    //写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str = in.nextLine().substring(2);
            System.out.println(Integer.parseInt(str,16));
        }
    }


}
