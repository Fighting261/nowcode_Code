import java.util.Scanner;

/**
 * @ program: 20200720
 * @ Description：
 * @ CreateTime：2020/7/20 9:11
 * @ Author：Mr Zhang
 */
public class TestDemo {

    /* 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
       输入: A10;S20;W10;D30;X;A1A;B10A11;;A10;
       输出: 10,-10
    */
    public static void main1(String[] args){
        Scanner sc=new Scanner(System.in);
        //判断是否有下一个录入的元素
        while(sc.hasNext()){
            String str=sc.nextLine();
            //使用;切割录入的字符串数据,返回字符串数组
            String[] A=str.split(";");
            int x=0,y=0;
            for(String string:A){
                //遍历字符串数组获取每一个部分内容,分别判断0索引对应的元素的内容
                //判断从1号位置开始是否有连续的1到2位的数字。(数字是0-9)
                if(string.charAt(0)=='D' && string.substring(1).matches("[0-9]{1,2}"))
                    //将字符串的字符转换为整形数字
                    x+=Integer.parseInt(string.substring(1));
                if(string.charAt(0)=='W' && string.substring(1).matches("[0-9]{1,2}"))
                    y+=Integer.parseInt(string.substring(1));
                if(string.charAt(0)=='S' && string.substring(1).matches("[0-9]{1,2}"))
                    y-=Integer.parseInt(string.substring(1));
                if(string.charAt(0)=='A' && string.substring(1).matches("[0-9]{1,2}"))
                    x-=Integer.parseInt(string.substring(1));
            }
            System.out.println(x+","+y);
        }
    }

/*  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while(array[left] >= array[right]) {
            mid = (left + right)>>1;
            if(right - left == 1) {
                mid = right;
                break;
            }
            if(array[left] == array[right] && array[left] ==array[mid]) {
                int result = array[left + 1];
                for(int i = left + 1; i < right; i++) {
                    if(array[i] < result) {
                        result = array[i];
                    }
                }
                return result;
            }
            if(array[mid] >= array[left]) {
                left = mid;
            }else {
                right = mid;
            }

        }
        return array[mid];
    }

    
}
