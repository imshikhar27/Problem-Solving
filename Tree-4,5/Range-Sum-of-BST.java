class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
         return 0;
        int ans=0;
        if(root.val>=low)
         ans+=rangeSumBST(root.left,low,high);
        if(root.val<=high)
         ans+=rangeSumBST(root.right,low,high);
        if(low<=root.val && root.val<=high)
         ans+=root.val;
        return ans;
    }
}
