/**
 * @ program: 20200722
 * @ Description：
 * @ CreateTime：2020/7/22 9:05
 * @ Author：Mr Zhang
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDemo {

    //nowcoder有两盒(A、 B)兵球，有红双喜的、有亚力亚的...现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，该怎么办呢?
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            char[] ch1 = sc.next().toCharArray();
            char[] ch2 = sc.next().toCharArray();
            HashMap<Character,Integer> map1 = new HashMap<>();
            HashMap<Character,Integer> map2 = new HashMap<>();
            for (char ch : ch1) {
                if(map1.containsKey(ch)) {
                    map1.put(ch,map1.get(ch) + 1);
                }else {
                    map1.put(ch,1);
                }
            }
            for (char ch : ch2) {
                if(map2.containsKey(ch)) {
                    map2.put(ch,map2.get(ch) + 1);
                }else {
                    map2.put(ch,1);
                }
            }
            if(isIncludeB(map1,map2) && isBiggerB(map1,map2)) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }
    }

    private static boolean isIncludeB(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {

        for (char ch : map2.keySet()) {
            if (!map1.containsKey(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBiggerB(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2) {
        for(char ch : map2.keySet()) {
            if(map1.get(ch) < map2.get(ch)) {
                return false;
            }
        }
        return true;
    }

    //采用map进行“剪枝”后的斐波那契数列
    private Map<Integer, Integer> filter = new HashMap<>();
    public int Fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        // filter = new HashMap<>();
        int pre = 0;
        if(filter.containsKey(n-1)){
            pre = filter.get(n-1);
        }
        else{
            pre = Fibonacci(n-1);
            filter.put(n-1, pre);
        }
        int ppre = 0;
        if(filter.containsKey(n-2)){
            ppre = filter.get(n-2);
        }
        else{
            ppre = Fibonacci(n-2);
            filter.put(n-2, ppre);
        }
        return pre + ppre;
    }

}
