import java.util.Scanner;

/**
 * @program: 20200623
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-23 10:36
 **/
public class TestDemo {

    //操作给定的二叉树，将其变换为源二叉树的镜像。
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public void Mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    //输入一个string型基因序列，和int型子串的长度 找出GC比例最高的子串,如果有多个输出第一个的子串
    public static double GetRatio(String str) {
        double ratio = 0;
        double count = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'G' || ch == 'C') {
                count++;
            }
        }
        ratio = count / str.length();
        return ratio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dna = sc.nextLine();
        int length = sc.nextInt();
        String maxStr = "";
        double maxRatio = 0;
        for(int i = 0; i < dna.length()-length + 1; i++) {
            String str = dna.substring(i,i + length);
            if(GetRatio(str) > maxRatio) {
                maxStr = str;
                maxRatio = GetRatio(str);
            }
        }
        System.out.println(maxStr);
    }


}
