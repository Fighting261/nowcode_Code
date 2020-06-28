import java.util.Scanner;

/**
 * @program: 20200628
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-28 12:19
 **/
public class TestDemo {

/*  数字分类：
    给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
    A1 = 能被5整除的数字中所有偶数的和；
    A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
    A3 = 被5除后余2的数字的个数；
    A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
    A5 = 被5除后余4的数字中最大数字。*/
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        int A1 = 0,A2 = 0,A3 = 0,A4 = 0,A5 = 0,flag = 1,count = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] % 10 == 0) {
                A1 += arr[i];
            }
            if(arr[i] % 5 == 1) {
                A2 += flag * arr[i];
                flag = -flag;
            }
            if(arr[i] % 5 == 2) {
                A3++;
            }
            if(arr[i] % 5 == 3) {
                A4 += arr[i];
                count++;
            }
            if(arr[i] % 5 == 4) {
                if(arr[i] > A5) {
                    A5 = arr[i];
                }
            }
        }
        if(A1!=0){
            System.out.print(A1+" ");
        }else{
            System.out.print('N'+" ");
        }
        if(A2!=0){
            System.out.print(A2+" ");
        }else{
            System.out.print('N'+" ");
        }
        if(A3!=0){
            System.out.print(A3+" ");
        }else{
            System.out.print('N'+" ");
        }
        if(A4!=0){
            System.out.print(A4/count+"."+(int)((A4%count*100/count+5)/10)+" ");
        }else{
            System.out.print("N"+" ");
        }
        if(A5!=0){
            System.out.print(A5);
        }else{
            System.out.print("N");
        }
    }

    //小易的升级之路
    public static int myMax(int a,int b) {
        int ret = 0;
        while(b != 0) {
            ret = a % b;
            a = b;
            b = ret;
        }
        return a;
    }

    //最高分是多少
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++) {
                if(a >= arr[i]) {
                    a += arr[i];
                }else {
                    a += myMax(arr[i],a);
                }
            }
            System.out.println(a);
        }
    }


    public static int max(int[] arr,int a,int b) {
        int max = 0;
        for(int i = a; i <= b; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] arr = new int[N + 1];
            arr[0] = 0;
            for(int i = 1; i <= N; i++) {
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i < M; i++) {
                char ch = sc.next().charAt(0);
                int A = sc.nextInt();
                int B = sc.nextInt();
                A=Math.min(A,B);
                B=Math.max(A,B);
                if(ch == 'Q') {
                    System.out.println(max(arr,A,B));
                }
                if(ch == 'U') {
                    arr[A] = B;
                }
            }
        }
    }
}
