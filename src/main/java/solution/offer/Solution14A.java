package solution.offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 算法示例 image.png
 *
 * 升级版本，需要考虑整数溢出
 *
 */
public class Solution14A {
    public int cuttingRope(int n) {
        // n <=3时候，不该切割
        if(n <= 3) return n - 1;
        // 否则，a = 长度为3的段数，B为切割后的余数
        // b==0时，3的整数倍，等长切割，3的a次方
        // b==1 余数1，则需要将 最后一个3长度的段分为2+2 3的a-1次方 * 4为结果
        // b==2的时候，3的a次方*2
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
    // 考虑整数溢出版本
//    public int cuttingRope(int n) {
//        // n <=3时候，不该切割
//        // 否则，a = 长度为3的段数，B为切割后的余数
//        // b==0时，3的整数倍，等长切割，3的a次方
//        // b==1 余数1，则需要将 最后一个3长度的段分为2+2 3的a-1次方 * 4为结果
//        // b==2的时候，3的a次方*2
//        // 计算 3 的 a-1次方的值
//        if(n <= 3) return n - 1;
//        int b = n % 3, p = 1000000007;
//        long rem = 1, x = 3;
//        for(int a = n / 3 - 1; a > 0; a /= 2) {
//            if(a % 2 == 1) rem = (rem * x) % p;
//            x = (x * x) % p;
//        }
//        if(b == 0) return (int)(rem * 3 % p);
//        if(b == 1) return (int)(rem * 4 % p);
//        return (int)(rem * 6 % p);
//
//    }
}
