package solution.offer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Solution17 {
    public int[] printNumbers(int n) {
        int num = this.myPow(10,n) -1 ;
        int[] resArray = new int[num];
        for(int i=0;i<num;i++){
            resArray[i] = i + 1;
        }
        return resArray;
    }

    private int myPow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                // 如果B为奇数，这里为最后一次计算， 每次x=x*x
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
