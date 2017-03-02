/*
@Copyright:LintCode
@Author:   zhou21
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-ii
@Language: Java
@Datetime: 17-02-03 00:10
*/

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
    
    
    ArrayList<ParentTreeNode> pathA = getpath2node(A);
    ArrayList<ParentTreeNode> pathB = getpath2node(B);
    
    int indexA = pathA.size() - 1;
    int indexB = pathB.size() - 1;
    
    ParentTreeNode lca = null;
    while (indexA >= 0 && indexB >= 0) {
        if (pathA.get(indexA) != pathB.get(indexB)) {
            break;
        }
        lca = pathB.get(indexB);
        indexA--;
        indexB--;
        
    }
        return lca;                                        
    }
    
    private ArrayList<ParentTreeNode> getpath2node(ParentTreeNode root) {
        ArrayList<ParentTreeNode> path = new ArrayList<ParentTreeNode>();
        while (root != null) {
            path.add(root);
            root = root.parent;
        }
        return path;
    }
}
