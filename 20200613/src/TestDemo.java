import java.util.Scanner;

/**
 * @program: 20200613
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-13 10:22
 **/
public class TestDemo {

    //个位数统计
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int[] arr = new int[10];
        for(int i = 0; i < N.length(); i++) {
            arr[N.charAt(i) - '0']++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                System.out.println(i + ":" + arr[i]);
            }
        }
    }

    //无缓存交换
    public class Exchange {
        public int[] exchangeAB(int[] AB) {
            // write code here
            AB[0] = AB[0] ^ AB[1];
            AB[1] = AB[0] ^ AB[1];
            AB[0] = AB[0] ^ AB[1];
            return AB;
        }
    }


}
