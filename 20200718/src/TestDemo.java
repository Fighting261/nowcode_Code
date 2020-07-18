import java.util.Scanner;

/**
 * @ program: 20200718
 * @ Description：
 * @ CreateTime：2020/7/18 22:15
 * @ Author：Mr Zhang
 */
public class TestDemo {

    //一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int sum = arr[0];
            int max = arr[0];
            for(int i = 1; i < n; i++) {
                if(sum > 0) {
                    sum += arr[i];
                }else {
                    sum = arr[i];
                }
                max = Math.max(sum,max);
            }
            System.out.println(max);
        }
    }
}
