package solution.offer;

/**
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] input = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Solution1().findRepeatNumber(input));
    }
    public int findRepeatNumber(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    // public int findRepeatNumber(int[] nums) {
    //     //获取中间Index
    //     if(nums.length == 0 || nums.length == 1){
    //         return -1;
    //     }
    //     // 思路2 二分查找，空间复杂度O(1)
    //     for(int i=1 ;i <nums.length ;i++){
    //         if(isEx(nums,nums[i-1],i,nums.length-1)){
    //             return nums[i-1];
    //         }
    //     }
    //    return -1;
    // }
    public static boolean isEx(int[] nums, int n, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[mid] == n || nums[start] == n || nums[end] == n) {
            return true;
        } else if (mid == start) {
            return false;
        } else {
            return isEx(nums, n, start, mid)
                    || isEx(nums, n, mid, end);
        }
    }

    // 思路1：0-n-1个数，代表如果 任意找到一个值i，如果不存在重复可能性，则满足 sortArray[i] = i
    // int[] sortArray = new int[nums.length];
    // for(int i=0 ;i <nums.length ;i++){
    //     if(sortArray[nums[i]] != 1){
    //         sortArray[nums[i]] = 1;
    //     } else{
    //         return nums[i];
    //     }
    // }
}
