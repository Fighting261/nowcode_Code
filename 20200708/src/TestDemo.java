/**
 * @program: 20200708
 * @description
 * @author: Zhang Baolu
 * @create: 2020-07-08 22:20
 **/
public class TestDemo {

/*  有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，
    请将结果Mod 1000000007给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。*/
    public int countWays(int n) {
        // write code here
        if(n < 1) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(n == 3) {
            return 4;
        }
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        for(int i = 3; i < n; i++) {
            arr[i] = ((arr[i-1] + arr[i-2])%1000000007 + arr[i-3]%1000000007)%1000000007;
        }
        return arr[n-1];
    }
}
