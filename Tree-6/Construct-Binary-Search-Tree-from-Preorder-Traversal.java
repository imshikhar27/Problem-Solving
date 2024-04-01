class Solution {
    int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        i=0;
        return pre(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode pre(int[] p,int min,int max)
    {
        if(i>=p.length)
         return null;
        if(p[i]<min || p[i]>max)
         return null;
        TreeNode node=new TreeNode();
        node.val=p[i];
        i++;
        node.left=pre(p,min,node.val);
        node.right=pre(p,node.val,max);
        return node;
    }
}
