import java.util.Stack;

/**
 * @ program: 20200801
 * @ Description：
 * @ CreateTime：2020/8/1 21:54
 * @ Author：Mr Zhang
 */
public class TestDemo {

/*  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所
    有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但
    4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    解题思路：
    要判定第二个序列是否可能是该栈的弹出序列，就要使用指定的入栈顺序模拟出来对应的弹栈序列，我们设入栈顺序
    序列式pushV,可能出栈序列popv的第一个元素，一定是最后入栈，最先弹栈的,而我们的入栈顺序是一定的也就决
    定了，我们必须一直入栈，直到碰到popv的第一个元素，然后开始弹栈最后在循环这个过程，如果符合要求，最后
    栈结构一定是空的*/

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 ||
                pushA.length != popA.length){
            return false;
        }
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;
        for( ; i < pushA.length; i++){
            //如果该条件不满足，就要一直入栈
            //如果该条件满足，就要一直出栈
            //pushV代表对应的入栈逻辑，popV代表对应的出栈逻辑
            //两个元素相等，代表入栈逻辑结束，出栈逻辑开始，想想为什么?
            st.push(pushA[i]);
            while(!st.empty() && st.peek() == popA[j]){//入栈逻辑结束，开始出栈逻辑
                st.pop();
                j++;
            }
        }
        return st.empty();
    }

}
