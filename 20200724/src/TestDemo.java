import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @ program: 20200724
 * @ Description：
 * @ CreateTime：2020/7/24 16:19
 * @ Author：Mr Zhang
 */
public class TestDemo {

    /*  一个电话的九宫格，一个数字对应一些字母，因此在国外企业喜欢把电话号码设计成与自己公司名字相对应。例如公司的Help Desk号码是4357，
        因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。同理，TUT-GLOP就代表888-4567、310-GINO代 表310-4466。NowCoder刚进
        入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请你帮他转换成数字形式的号码，并去除重复的部分
        */
    public static void main1(String[] args) {
        // symbol 和 number 对应下标的字符是有对应关系的.
        String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "222333444555666777788899991234567890";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                str = str.replace("-", "");
                String result = "";
                for (int j = 0; j < 7; j++) {
                    result += number.charAt(symbol.indexOf(str.charAt(j) + ""));
                }
                result = result.substring(0, 3) + "-" + result.substring(3, 7);
                if (!arrayList.contains(result))
                    arrayList.add(result);
            }
            Collections.sort(arrayList);
            for (int j = 0; j < arrayList.size(); j++) {
                System.out.println(arrayList.get(j));
            }
            System.out.println();
        }
    }

/*  对字符串中的所有单词进行倒排。
    说明：
        1、构成单词的字符只有26个大写或小写英文字母；
        2、非构成单词的字符均视为单词间隔符；
        3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
        4、每个单词最长20个字母；
        */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            // 使用正则表达式作为分割符.
            String[] strArray = str.split("[^a-zA-Z]+");
            for (int i = strArray.length - 1; i >= 2; i--) {
                System.out.print(strArray[i] + ' ');
            }
            if (strArray[0].length() == 0) {
                System.out.println(strArray[1]);
            } else {
                System.out.println(strArray[1] + ' ' + strArray[0]);
            }
        }
    }
}
