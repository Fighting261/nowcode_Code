import java.util.Scanner;
import java.math.BigInteger;
/**
 * @program: 20200619
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-19 21:22
 **/
public class TestDemo {

    //另类加法，不适用 + 号计算两个数的和
    public class UnusualAdd {
        public int addAB(int A, int B) {
            if(B == 0) {
                return A;
            }
            if(A == 0) {
                return B;
            }
            int a = A ^ B; //相加但不进位      
            int b = (A & B) << 1; //进位但不相加    
            return addAB(a, b);
        }
    }

    //统计相同分数学生的人数
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int arr[] = new int[N];

            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int score = sc.nextInt();
            int count = 0;
            for(int i = 0; i < N; i++) {
                if(score == arr[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    
    //超长正整数相加
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            BigInteger a = new BigInteger(str1);
            BigInteger b = new BigInteger(str2);
            System.out.println(a.add(b));
        }
    }

}