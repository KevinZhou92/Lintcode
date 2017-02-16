/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/binary-tree-serialization
@Language: Java
@Datetime: 17-02-16 22:33
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            if (node == null) {
                continue;
            }
            nodes.add(node.left);
            nodes.add(node.right);
        } 
        
        while (nodes.get(nodes.size() - 1) == null) {
            nodes.remove(nodes.size() - 1);
        } 
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(nodes.get(0).val);
        for (int i = 1; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            if (node != null) {
                sb.append(",");
                sb.append(nodes.get(i).val);
            }else {
                sb.append(",#");
            }
        }
        
        sb.append("}");
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        } 
        String[] vals = data.substring(1, data.length() - 1).split(",");
        
        ArrayList<TreeNode> nodes = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        nodes.add(root);
        boolean isLeft = true;
        
        int index = 0;
        for (int i = 1; i < vals.length; i++) {
            TreeNode node = nodes.get(index);
            if (!vals[i].equals("#")) {
                if (isLeft) {
                    node.left =  new TreeNode(Integer.parseInt(vals[i]));
                    nodes.add(node.left);
                }else {
                    node.right =  new TreeNode(Integer.parseInt(vals[i]));
                    nodes.add(node.right);
                }
            } else {
                if (isLeft) {
                    node.left = null;
                }
                else node.right = null;
            } 
            
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
                
        }
        
        return root;
    }
}
