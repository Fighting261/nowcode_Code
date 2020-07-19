import java.util.Scanner;

/**
 * @ program: 20200719
 * @ Description：
 * @ CreateTime：2020/7/19 16:47
 * @ Author：Mr Zhang
 */
public class TestDemo {

    //输入某年某月某日，判断这一天是这一年的第几天？
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int outDay = iConverDateToDay(year,month,day);
            System.out.println(outDay);
        }
    }

    public static int iConverDateToDay(int year,int month,int day) {
        int sum = 0;
        int[] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            Day[1] = 29 ;
        }
        if(year < 0 || month < 0 || month >12 || day < 0 || day > Day[month-1]) {
            return -1;
        }
        for(int i = 0; i < month-1; i++) {
            sum += Day[i];
        }
        return sum + day;
    }
    
}
