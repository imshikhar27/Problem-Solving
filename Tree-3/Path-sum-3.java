class Solution {
    int c;
    public int pathSum(TreeNode root, int targetSum) {
        c=0;
        c1(root,targetSum);
        return c;
    }
    public void c1(TreeNode root,int target)
    {
        if(root==null)
         return;
        hasPathSum(root,target);
        c1(root.left,target);
        c1(root.right,target);
    }
    public void hasPathSum(TreeNode root, long targetSum) {
        if(root==null)
         return ;
        targetSum-=root.val;
        if(targetSum==0)
         c++;
        hasPathSum(root.left,targetSum);
        hasPathSum(root.right,targetSum);
    }
}
