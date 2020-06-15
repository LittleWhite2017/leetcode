package solution.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 后序遍历定义： [ 左子树 | 右子树 | 根节点 ] ，即遍历顺序为 “左、右、根” 。
 * 二叉搜索树定义： 左子树中所有节点的值 < 根节点的值；右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树
 *
 */
public class Solution33 {
    // 方法一：递归分治
    //
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
       //  当 i≥j ，说明此子树节点数量≤1 ，无需判别正确性，因此直接返回 true ；
        if(i >= j) return true;
        int p = i;
        // 左子树节点均小于根节点
        while(postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        // 右子树节点均小于根节点，找到第一个小于等于根节点的右子树节点
        while(postorder[p] > postorder[j]){
            p++;
        }
        // 若P==j 代表 左子树小于根节点 右子树都大于根节点
        // 判断子树是否符合要求
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
//    // 单调用栈方法
//    Deque<Integer> stack = new LinkedList<>();
//    // 表示上一个根节点的元素，这里可以把postorder的最后一个元素root看成无穷大节点的左孩子
//    int pervElem = Integer.MAX_VALUE;
//    // 逆向遍历，就是翻转的先序遍历
//        for (int i = postorder.length - 1;i>=0;i--){
//        // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
//        if (postorder[i] > pervElem){
//            return false;
//        }
//        while (!stack.isEmpty() && postorder[i] < stack.peek()){
//            // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
//            // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
//            pervElem = stack.pop();
//        }
//        // 这个新元素入栈
//        stack.push(postorder[i]);
//    }
//    return true;
}
