/**
 * @ program: 20200731
 * @ Description：
 * @ CreateTime：2020/7/31 21:29
 * @ Author：Mr Zhang
 */
public class TestDemo {

/*  对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
    给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
    【解题思路】：
    1. 先记录左上角和右下角坐标(这两个坐标就描述了一个矩形)
    2. 然后先按照顺时针打印这个矩形边上的元素
    3. 缩小矩形(也就是调整左上和右下坐标位置)
    4. 再次顺时针打印. 一直缩小到这个矩形为空即可.*/
    public int[] clockwisePrint(int[][] mat,int n,int m) {
        int[] a =new int[m*n];
        if( mat ==null)
            return a;
        int i =0;
        int j =0;
        int k =0;
        int startX =0;
        int startY =0;
        int endX = n -1;
        int endY = m -1;
        while(startX <= endX && startY <= endY) {
            //如果只剩下一行
            if(startX == endX){
                for(; j <= endY; j++,k++){
                    a[k] = mat[startX][j];
                }
                return a;
            }
            //如果只剩下一列
            if(startY == endY){
                for(; i <= endX; i++,k++){
                    a[k] = mat[i][startY];
                }
                return a;
            }
            //将矩阵上边除右顶点添加到返回的数组中
            for(; j < endY; j++,k++){
                a[k] = mat[i][j];
            }
            //将矩阵右边除边下顶点添加到返回的数组中
            for(; i < endX; i++,k++){
                a[k] = mat[i][j];
            }
            //将矩阵下边除边左顶点添加到返回的数组中
            for(; j > startX; j--,k++){
                a[k] = mat[i][j];
            }
            //将矩阵左边除边上顶点添加到返回的数组中
            for(; i > startY; i--,k++){
                a[k] = mat[i][j];
            }
            i++;
            j++;
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return a;
    }
}
