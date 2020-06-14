package solution.offer;

import struct.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        // 空树对称
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left,TreeNode right){
        // 左右均为Null
        if(null == left && null == right){
            return true;
        }
        // 左右一个Null
        if(null == left || null == right){
            return false;
        }
        // 左右均不为null
        return left.val == right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left) ;
    }
}
