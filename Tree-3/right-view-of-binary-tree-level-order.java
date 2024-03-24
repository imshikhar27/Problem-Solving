class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
         return new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode ad=null;
        while(q.size()!=0)
        {
            int l=q.size();
            for(int i=0;i<l;i++)
            {
                ad=q.poll();
                if(ad.left!=null)
                 q.add(ad.left);
                if(ad.right!=null)
                 q.add(ad.right);
            }
            ls.add(ad.val);
        }
        return ls;
    }
}
