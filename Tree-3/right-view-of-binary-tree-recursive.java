class Solution {
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
       ans=new ArrayList<>();
       pre(root,0);
       return ans;
    }
    public void pre(TreeNode root,int level)
    {
        if(root==null)
         return;
        if(level>=ans.size())
           ans.add(root.val);
        pre(root.right,level+1);
        pre(root.left,level+1);
    }
}

