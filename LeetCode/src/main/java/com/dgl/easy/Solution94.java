package com.dgl.easy;

import com.dgl.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @auther DongGenLei
 * @date 2022/3/2 22:57
 */
public class Solution94 {
    // 二叉树的中序遍历
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
