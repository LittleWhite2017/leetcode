package solution.offer;

import struct.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *        /  \
 *      15   7
 */
public class SolutionRebuildTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = new SolutionRebuildTree().buildTree(preorder,inorder);
        System.out.println(treeNode);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length ==0 || inorder.length == 0){
            return null;
        }
        return reBuildTreeNode(preorder,0,preorder.length -1 ,inorder,0,inorder.length -1);
    }

    private TreeNode reBuildTreeNode(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if (preStart > preEnd || inStart > inEnd) { //停止递归的条件
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for(int i = inStart ;i <= inEnd;i++){
            if(inorder[i] == preorder[preStart]){
                int length = i - inStart;
                root.left = reBuildTreeNode(preorder,preStart + 1,preStart + length,inorder,inStart,i-1);
                root.right = reBuildTreeNode(preorder,preStart + length+1,preEnd,inorder,i+1,inEnd);
                break;
            }
        }

        return root;
    }
}
