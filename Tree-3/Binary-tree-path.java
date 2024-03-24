class Solution {
    StringBuilder sb;
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        sb=new StringBuilder();
        ans=new ArrayList<>();
        find(root);
        return ans;
    }
    public void find(TreeNode root)
    {
      if(root.left==null && root.right==null)
        {
         ans.add(sb.toString()+Integer.toString(root.val));
         return;
        }
        int num=root.val;
        String s=Integer.toString(num)+"->";
        int currSize=sb.length();
        sb.append(s);
        if(root.left!=null)
         find(root.left);
        if(root.right!=null)
         find(root.right);
        sb.delete(currSize,sb.length());
    }
}
