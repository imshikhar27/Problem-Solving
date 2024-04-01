import java.util.*;
public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        if(root==null)
         return null;
       ArrayList<Integer> ls=new ArrayList<>();
       ls.add(root.data);
       left(root.left,ls);
       leaf(root,ls);
       right(root.right,ls);
       return ls;
    }
    public static void left(TreeNode root,List<Integer> ls)
    {
        if(root==null)
         return ;
        if(root.left==null && root.right==null)
         return ;
        ls.add(root.data);
        if(root.left!=null)
         left(root.left,ls);
        else
         left(root.right,ls);
    }
    public static void leaf(TreeNode root,List<Integer> ls)
    {
        if(root==null)
         return ;
        if(root.left==null && root.right==null)
        {
            ls.add(root.data);
            return ;
        }
        leaf(root.left,ls);
        leaf(root.right,ls);
    }
    public static void right(TreeNode root,List<Integer> ls)
    {
        if(root==null)
         return;
        if(root.left==null && root.right==null)
         return ;
        if(root.right!=null)
         right(root.right,ls);
        else
         right(root.left,ls);
        ls.add(root.data);
    }
}
