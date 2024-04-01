class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static class Triplet
    {
        int min,max,size;
        Triplet(int min,int max,int size)
        {
            this.min=min;
            this.max=max;
            this.size=size;
        }
    }
    static int largestBst(Node root)
    {
        // Write your code here
        Triplet ans=find(root);
        return ans.size;
    }
    public static Triplet find(Node root)
    {
        if(root==null)
         return new Triplet(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        if(root.left==null && root.right==null)
         return new Triplet(root.data,root.data,1);
        Triplet left=find(root.left);
        Triplet right=find(root.right);
        
        int largeOfLeft=left.max;
        int smallOfRight=right.min;
        if(largeOfLeft<root.data && root.data<smallOfRight)
        {
            int min=(left.min==Integer.MAX_VALUE)?root.data:left.min;
            int max=(right.max==Integer.MIN_VALUE)?root.data:right.max;
            int size=left.size+right.size+1;
            return new Triplet(min,max,size);
        }
        return new Triplet(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.size,right.size));
    }
    
}
