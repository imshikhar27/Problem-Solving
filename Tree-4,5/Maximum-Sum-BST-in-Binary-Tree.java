class Solution {
    class Triplet
    {
        int min,max,sum;
        Triplet(int min,int max,int sum)
        {
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    int maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        find(root);
        return maxSum;
    }
    public Triplet find(TreeNode root)
    {
        if(root==null)
         return new Triplet(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        if(root.left==null && root.right==null)
        {
         maxSum=Math.max(maxSum,root.val);
         return new Triplet(root.val,root.val,root.val);
        }
        Triplet left=find(root.left);
        Triplet right=find(root.right);
        
        int largeOfLeft=left.max;
        int smallOfRight=right.min;
        if(largeOfLeft<root.val && root.val<smallOfRight)
        {
            int min=(left.min==Integer.MAX_VALUE)?root.val:left.min;
            int max=(right.max==Integer.MIN_VALUE)?root.val:right.max;
            int sum=left.sum+right.sum+root.val;
            maxSum=Math.max(sum,maxSum);
            return new Triplet(min,max,sum);
        }
        return new Triplet(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.sum,right.sum));
    }
}
