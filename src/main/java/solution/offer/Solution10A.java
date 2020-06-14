package solution.offer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Solution10A {
    public int fib(int n) {
        if(n ==0 || n == 1){
            return n;
        }
        int[] val = new int[n];
        for(int i =0 ;i < n ;i++){
            if(i ==0 || i == 1){
                val[i] = i;
            }else{
                val[i] = (val[i-1] + val[i-2])% 1000000007;
            }
        }

        return (val[n-1] + val[n-2])%1000000007;
    }
}
