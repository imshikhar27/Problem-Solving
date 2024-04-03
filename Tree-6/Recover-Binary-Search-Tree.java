class Solution {
    TreeNode prev;
    TreeNode[] voilate;
    int k; 
    public void recoverTree(TreeNode root) {
        prev=null;
        voilate=new TreeNode[2];
        k=0;
        recover(root);
        int temp=voilate[0].val;
        voilate[0].val=voilate[1].val;
        voilate[1].val=temp;
    }
    public void recover(TreeNode root)
    {
     if(root==null)
      return;
     recover(root.left);
     if(prev!=null)
     {
        if(prev.val>root.val)
        {
         if(k==0)
          voilate[k++]=prev;
         if(k==1)
          voilate[k]=root;
        }
     }
     prev=root;
     recover(root.right);
    }
}
