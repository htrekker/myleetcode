package com.pasilo.leetcode;

public class LeetCode98 {
	public Integer temp = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        boolean flag = isValidBST(root.left);
        if(!flag || temp != null && root.val <= temp) return false;
        temp = root.val;
        return isValidBST(root.right);
    }
    
    
    public static void main(String[] args) {

    }
}
