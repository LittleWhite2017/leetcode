package solution.offer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 */
public class Solution16 {
    public double myPow(double x, int n) {
        if(n ==0 ){
            return 1;
        }
        double res = 1.0;
        long b = n;
        if(n < 0){
            x =1 /x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) {
                // 如果B为奇数，这里为最后一次计算， 每次x=x*x
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
