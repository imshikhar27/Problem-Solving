class Solution {
    int r,ans;
    public int findBottomLeftValue(TreeNode root) {
        ans=0;
        r=-1;
        find(root,0);
        return ans;
    }
    public void find(TreeNode root,int row)
    {
     if(root==null)
      return ;
     if(root.left==null && root.right==null)
     {
        if(r<row)
        {
            ans=root.val;
            r=row;
        }
        return;
     }
     find(root.left,row+1);
     find(root.right,row+1);
    }
}
