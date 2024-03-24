class Solution {
    List<List<Integer>> out;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        out=new ArrayList<>();
        hasPathSum(root,targetSum,new ArrayList<>());
        return  out;
    }
    public void hasPathSum(TreeNode root, int targetSum,List<Integer> l) {
        if(root==null)
         return ;
        targetSum-=root.val;
        l.add(root.val);
        if(targetSum==0 && root.left==null && root.right==null)
        {
         out.add(new ArrayList<>(l));
        } 
        hasPathSum(root.left,targetSum,l);
        hasPathSum(root.right,targetSum,l);
        l.remove(l.size()-1);
    }
