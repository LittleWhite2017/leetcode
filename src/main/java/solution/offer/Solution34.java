package solution.offer;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class Solution34 {
    List<List<Integer>> result = new ArrayList();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root ==null){
            return result;
        }
        dfs(root,sum);
        return result;
    }

    private void dfs(TreeNode root, int sum ){
        if(root == null){
            return;
        }
        list.add(root.val);
        int target = sum - root.val;
        if(target == 0 && root.left == null && root.right == null){
            // 叶子节点
            result.add(new ArrayList<>(list)); //注意浅拷贝
        }
        dfs(root.left,target);
        dfs(root.right,target);
        list.remove(list.size() -1);
    }
}
