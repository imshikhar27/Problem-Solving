class Solution {
    int c;
    public int kthSmallest(TreeNode root, int k) {
        c=0;
        return traverse(root,k);
    }
    public int traverse(TreeNode root,int k)
    {
        if(root==null)
         return -1;
        int l=traverse(root.left,k);
        if(l!=-1)
         return l;
        c++;
        if(c==k)
         return root.val;
        int r=traverse(root.right,k);
        return r;
    }
}
