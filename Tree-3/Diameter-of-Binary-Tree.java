class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        find(root);
        return max;
    }
    public int find(TreeNode root)
    {
        if(root==null)
         return 0;
        int l=find(root.left);
        int r=find(root.right);
        max=Math.max(max,l+r);
        return 1+Math.max(l,r);
    }
}
