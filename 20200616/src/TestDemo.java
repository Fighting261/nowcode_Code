import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: 20200616
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-16 10:46
 **/
public class TestDemo {

    //给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
    //给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        while(sc.hasNext()) {
            for(int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            for(int j = 1; j < 10; j++) {
                if(arr[j] != 0) {
                    System.out.print(j);
                    arr[j]--;
                    break;
                }
            }
            while(arr[0]!=0){
                System.out.print(0);
                arr[0]--;
            }
            for(int k = 0; k < 10; k++) {
                while(arr[k] != 0) {
                    System.out.print(k);
                    arr[k]--;
                }
            }
        }
    }

/*    验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
      例如：
            1^3=1
            2^3=3+5
            3^3=7+9+11
            4^3=13+15+17+19
*/
    public static void main2 (String[] args) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int first = n * n - n + 1;
            for(int i = 0; i < n; i++) {
                if(i != n-1){
                    System.out.print((first+ 2*i) + "+");
                }else {
                    System.out.println((first+ 2*i));
                }
            }
        }
    }

    //给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
    // 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            B[i] = 1;
            int tmp = A[i];
            for(int j = 0; j < A.length; j++) {
                if(j == i) {
                    A[j] = 1;
                }
                B[i] *= A[j];
            }
            A[i] = tmp;
        }
        return B;
    }

    public static void main3(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(Arrays.toString(multiply(A)));
    }

/*    在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，
      使用递归的方法生成N位的格雷码。给定一个整数n，请返回n位的格雷码，顺序为从0开始。
*/
public class GrayCode {
    public String[] getGray(int n) {
        String[] resStrs = null;
        if(n == 1){
            resStrs = new String[]{"0","1"};
        }else{
            String[] strs = getGray(n-1);
            resStrs = new String[2*strs.length];
            for(int i=0; i<strs.length; i++){
                resStrs[i] = "0"+strs[i];
                resStrs[resStrs.length-1-i] = "1"+strs[i];
            }
        }
        return resStrs;
    }
}
}

