public class Solution {
    static int curr;
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
        curr=0;
        pre(root,0);
    }
    public static void pre(TreeNode<Integer> root,int level)
    {
        if(root==null)
         return;
        if(level>=curr)
        {
           System.out.print(root.data+" ");
           curr++;
        }
        pre(root.left,level+1);
        pre(root.right,level+1);
    }
}

