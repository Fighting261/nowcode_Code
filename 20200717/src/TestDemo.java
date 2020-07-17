import java.util.Scanner;

/**
 * @ program: 20200717
 * @ Description：
 * @ CreateTime：2020/7/17 9:46
 * @ Author：Mr Zhang
 */
public class TestDemo {

    //给定-个字符串，问是否能通过添加一个字母将其变为回文串。
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            boolean flag = true;
            int left = 0;
            int right = arr.length - 2;
            while (left <= right) {
                if (arr[left] != arr[right]) {
                    flag = false;
                    break;
                }
                left++;
                right--;
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    //有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
    public int[] arrayPrint(int[][] arr, int n) {
        int[] array = new int[n * n];
        int length = 0;
        for (int j = n - 1; j >= 0; j--) {//上三角部分
            int k = j;
            for (int i = 0; i < n - j; i++) {
                array[length] = arr[i][k];
                k++;
                length++;
            }
        }

        for (int j = 1; j < n; j++) {//下三角部分
            int k = j;
            for (int i = 0; i < n - j; i++) {
                array[length] = arr[k][i];
                k++;
                length++;
            }
        }

        return array;
    }

}




