import java.util.Scanner;

/**
 * @program: 20200629
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-29 17:59
 **/
public class TestDemo {

/*      北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。公式如下：
        实际成绩 绩点
        90——100 4.0
        85——89 3.7
        82——84 3.3
        78——81 3.0
        75——77 2.7
        72——74 2.3
        68——71 2.0
        64——67 1.5
        60——63 1.0
        60以下  0
        1．一门课程的学分绩点=该课绩点*该课学分
        2．总评绩点=所有学科绩点之和/所有课程学分之和
        现要求你编写程序求出某人A的总评绩点（GPA）。
        */

    public static double getGPA(int score){
        if (score>=90) return 4.0;
        else if (score>=85) return 3.7;
        else if (score>=82) return 3.3;
        else if (score>=78) return 3.0;
        else if (score>=75) return 2.7;
        else if (score>=72) return 2.3;
        else if (score>=68) return 2.0;
        else if (score>=64) return 1.5;
        else if (score>=60) return 1.0;
        else return 0.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();     //课程数n
            int[] credit = new int[n];   //学分
            int[] score = new int[n];   //成绩
            int credits = 0;   //总学分
            for(int i = 0; i < n; i++) {
                credit[i] = sc.nextInt();
                credits += credit[i];
            }
            for(int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
            }

            double GPA = 0;
            for(int i = 0; i < n; i++) {
                GPA += getGPA(score[i])*credit[i];
            }
            System.out.printf("%.2f",GPA / credits);
            System.out.println();
        }
    }
}
