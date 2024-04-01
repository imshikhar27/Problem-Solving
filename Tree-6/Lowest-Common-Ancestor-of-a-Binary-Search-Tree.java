class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
         return null;
        if(root==p||root==q)
         return root;
        if( (p.val<root.val && root.val<q.val) || (p.val>root.val && root.val>q.val))
         return root;
        if(root.val>p.val)
         return lowestCommonAncestor(root.left,p,q);
        return lowestCommonAncestor(root.right,p,q);
    }
}
