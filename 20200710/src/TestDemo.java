/**
 * @ program: 20200710
 * @ Description：
 * @ CreateTime：2020/7/10 21:32
 * @ Author：Mr Zhang
 */

import java.util.Scanner;

//输入球的中心点和球上某一点的坐标，计算球的半径和体积
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int z0 = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();
            double r = Math.sqrt(Math.pow(x0-x1,2)+Math.pow(y0-y1,2)+Math.pow(z0-z1,2));
            double v = 4/3.0*Math.acos(-1)*r*r*r;

            System.out.printf("%.3f",r);
            System.out.print(" ");
            System.out.printf("%.3f",v);
            System.out.println();
        }
    }
}






