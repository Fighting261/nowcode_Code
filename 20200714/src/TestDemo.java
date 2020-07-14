/**
 * @ program: 20200714
 * @ Description：
 * @ CreateTime：2020/7/14 15:31
 * @ Author：Mr Zhang
 */
import java.util.*;
public class TestDemo {

    //Broken Keyboard
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0;i<a.length();i++){
            char ch = a.charAt(i);//分割源字符串
            if(!b.contains(String.valueOf(ch))){
                if(ch >= 'a' && ch<='z'){  //如果是字母就变成大写
                    char x = Character.toUpperCase(ch);
                    set.add(x);
                }else {
                    set.add(ch);
                }
            }
        }
        for(Character character: set){
            System.out.print(character);
        }
    }


}
