
import java.util.Scanner;
public class TestDemo{
    //C语言风格使用下划线分隔多个单词，例如“hello_world”；而Java则采用一种叫骆驼命名法的规则：除首个单词以外，所有单词的首字母大写，例如“helloWorld”。
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder sb = new StringBuilder(sc.nextLine());
            for(int i = 0; i < sb.length(); i++){
                if(sb.charAt(i) == '_'){
                    String s = (sb.charAt(i+1)+"").toUpperCase();
                    sb.replace(i,i+2,s);
                }
            }
            System.out.println(sb.toString());
        }
    }

/*  1.对输入的字符串进行加解密，并输出。
    2.加密方法为：当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B;
    字母Z时则替换为a;当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0;其他字符不做变化。
    3.解密方法为加密的逆过程。
    */
//对字符进行加密，加密原理：当前字符的后一个字符并且是大写
//如果是数字则加1就好了，这里要注意如果是小写z,那么对应大写A.
//大写Z对象小写a.
    public static char encryption(char c) {
        if(c >= 'a' && c < 'z')
            return (char)(c + 1 - 32);
        else if(c == 'z')
            return 'A';
        else if(c >= 'A' && c < 'Z')
            return (char)(c + 1 + 32);
        else if(c == 'Z')
            return 'a';
        else if(c >= '0' && c < '9')
            return (char)(c + 1);
        else if(c == '9')
            return '0';
        else
            return c;
    }
    //字符解密过程
    public static char decryption(char c) {
        if(c > 'a' && c <= 'z')
            return (char)(c - 1 - 32);
        else if(c == 'a')
            return 'Z';
        else if(c > 'A' && c <= 'Z')
            return (char)(c - 1 + 32);
        else if(c == 'A')
            return 'z';
        else if(c > '0' && c <= '9')
            return (char)(c - 1);
        else if(c == '0')
            return '9';
        else
            return c;
    }
    //加密，将输入的字符串中的每个字符进行加密。
    public static String enCryption(String s) {
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(encryption(cs[i]));
        }
        return sb.toString();
    }
    //解密
    public static String deCryption(String s) {
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(decryption(cs[i]));
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();//加过密的密码
            String s2 = sc.nextLine();//解密的密码
            System.out.println(enCryption(s1));
            System.out.println(deCryption(s2));
        }
        sc.close();
    }
}
