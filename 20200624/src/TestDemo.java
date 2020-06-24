import java.util.Scanner;

/**
 * @program: 20200624
 * @description
 * @author: Zhang Baolu
 * @create: 2020-06-24 12:25
 **/
public class TestDemo {

    //找出数组中出现次数大于一半的数字
    public int getValue(int[] gifts, int n) {
        // write code here
        int num = gifts[0];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (num == gifts[i]) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                num = gifts[i];
            }
        }
        if (count > 0) {
            return num;
        }
        return 0;
    }

    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Partition {
        public ListNode partition(ListNode pHead, int x) {
            // write code here
            ListNode bs = null;
            ListNode be = null;
            ListNode as = null;
            ListNode ae = null;
            ListNode cur = pHead;
            while (cur != null) {
                if (cur.val < x) {
                    if (bs == null) {
                        bs = cur;
                        be = cur;
                    } else {
                        be.next = cur;
                        be = be.next;
                    }
                } else {
                    if (as == null) {
                        as = cur;
                        ae = cur;
                    } else {
                        ae.next = cur;
                        ae = ae.next;
                    }
                }
                cur = cur.next;
            }
            if (bs == null) {
                return as;
            }
            be.next = as;
            if (ae != null) {
                ae.next = null;
            }
            return bs;
        }
    }

    //有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
    public static int getTotalCount(int monthCount) {
        if (monthCount == 1 || monthCount == 2) {
            return 1;
        }
        return getTotalCount(monthCount - 1) + getTotalCount(monthCount - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int monthCount = sc.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
    }

    //破译密码
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c < 'F') {
                    System.out.print((char) ((int) c + 21));
                } else if (c > 'E' && c <= 'Z') {
                    System.out.print((char) ((int) c - 5));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
