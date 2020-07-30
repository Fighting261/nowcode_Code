import java.util.Set;

/**
 * @ program: 20200730
 * @ Description：动态规划（1）
 * 动态规划具备了以下三个特点
 * 1. 把原来的问题分解成了几个相似的子问题。
 * 2. 所有的子问题都只需要解决一次。
 * 3. 储存子问题的解。
 * 动态规划的本质，是对问题状态的定义和状态转移方程的定义(状态以及状态之间的递推关系)
 * 动态规划问题一般从以下四个角度考虑：
 * 1. 状态定义
 * 2. 状态间的转移方程定义
 * 3. 状态的初始化
 * 4. 返回结果
 * 状态定义的要求：定义的状态一定要形成递推关系。
 * 一句话概括：三特点四要素两本质
 * 适用场景：最大值/最小值, 可不可行, 是不是，方案个数
 * @ CreateTime：2020/7/30 16:24
 * @ Author：Mr Zhang
 */
public class TestDemo {

    /*  斐波那契数列
        状态：F(n)
        状态递推：F(n)=F(n-1)+F(n-2)
        初始值：F(1)=F(2)=1
        返回结果：F(N)
    */
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int ret = 0;
        for (int i = 3; i <= n; i++) {
            ret = first + second;
            first = second;
            second = ret;
        }
        return ret;
    }

/*  给定一个字符串和一个词典dict，确定s是否可以根据词典中的词分成一个或多个单词。
    比如，给定s = "leetcode"，dict = ["leet", "code"]
    返回true，因为"leetcode"可以被分成"leet code"

    子状态：前1，2，3，...,n个字符能否根据词典中的词被成功分词
    F(i): 前i个字符能否根据词典中的词被成功分词
    F(i): true{j <i && F(j) && substr[j+1,i]能在词典中找到} OR false
    在j小于i中，只要能找到一个F(j)为true，并且从j+1到i之间的字符能在词典
    中找到，则F(i)为true
    初始值：F(0) = true
    返回结果：F(n) */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 0; i < canBreak.length; i++) {
            for(int j = 0; j < i; j++) {
                if(canBreak[j] && dict.contains(s.substring(j,i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }


}
