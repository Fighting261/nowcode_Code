import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: 20200702
 * @description
 * @author: Zhang Baolu
 * @create: 2020-07-02 12:27
 **/
public class TestDemo {

    /*      小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断
        一下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
        为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，
        因为包含了全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String have = sc.nextLine();//商人输入
        String need = sc.nextLine();//用户输入

        //商人的珠子
        Map<Character, Integer> h = new HashMap<>();
        for (char c : have.toCharArray()) {
            if (h.containsKey(c)) {
                h.put(c, h.get(c) + 1);
            } else {
                h.put(c, 1);
            }
        }

        //用户的珠子
        Map<Character, Integer> n = new HashMap<>();
        for (char c : need.toCharArray()) {
            if (n.containsKey(c)) {
                n.put(c, n.get(c) + 1);
            } else {
                n.put(c, 1);
            }
        }

        boolean flag = true;
        int lack = 0;
        for (Map.Entry<Character, Integer> en : n.entrySet()) {
            char k = en.getKey();
            int v = en.getValue();
            if (h.containsKey(k) && h.get(k) < v) {
                flag = false;
                lack += v - h.get(k);
            } else if (!h.containsKey(k)) {
                flag = false;
                lack += v;
            }
        }

        if (flag) {
            System.out.println("Yes " + (have.length() - need.length()));
        } else {
            System.out.println("No " + lack);
        }
    }

    /*实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
    给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。*/
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public boolean isBalance(TreeNode root) {
            // write code here
            if (root == null) {
                return true;
            }

            int leftHeight = getTreeHeight(root.left);
            int rightHeight = getTreeHeight(root.right);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }
            return isBalance(root.left) && isBalance(root.right);
        }

        public static int getTreeHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
        }
    }

    //对于给定的正整数n，计算其+进制形式下所有位置数字之和，并计算其平方的各位数字之和。
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = m * m;
        System.out.print(add(m));
        System.out.print(" " + add(n));
    }

    public static int add(int x) {
        int num = 0;
        while(x != 0) {
            num += x%10;
            x /=10;
        }
        return num;
    }
}
