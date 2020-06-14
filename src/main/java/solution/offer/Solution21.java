package solution.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 */
public class Solution21 {
    // 类似快排思想，完成排序
    public int[] exchange(int[] nums) {
        int i=0 ,j=nums.length -1,temp;
        while(i < j){
            // 偶数,找到第一个奇数，i
            while(i<j && (nums[i] & 1 )== 1){
                i++;
            }
            // 偶数,找到倒叙第一个偶数，j
            while(i<j && (nums[j] & 1 )== 0){
                j--;
            }
            // 交换
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
