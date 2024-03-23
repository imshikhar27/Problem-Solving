class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       if(root==null)
        return new LinkedList<>();
        return level(root,new LinkedList<>());
    }
    public List<List<Integer>> level(TreeNode root,List<List<Integer>> out)
    {
     List<Integer> in=new LinkedList<>();
     Queue<TreeNode> q=new LinkedList<>();
     q.add(root);
     TreeNode add=null;
     int l=1; //q.size()
     while(l!=0)
     {
      for(int i=0;i<l;i++)
      {
        add=q.remove();
         in.add(add.val);
        if(add.left!=null)
         q.add(add.left);
        if(add.right!=null)
         q.add(add.right);
      }
      out.add(new LinkedList<>(in));
      in.clear();
      l=q.size();
     }
     return out;
    }
}
