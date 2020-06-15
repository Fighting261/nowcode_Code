import java.util.Scanner;

/**
 * @program: 20200615
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-15 12:41
 **/
public class TestDemo {

    /*  输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
        输入
        10 a
        输出
        aaaaaaaaaa
        a        a
        a        a
        a        a
        aaaaaaaaaa
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String c = sc.next();
            int r = (n + 1)/2;
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0 || i == r-1) {
                        System.out.print(c);
                    }else if(j == 0 || j == n-1){
                        System.out.print(c);
                    }else {
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        }
    }


}