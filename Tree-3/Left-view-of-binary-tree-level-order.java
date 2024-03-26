import java.util.*;
public class Solution {
    static int curr;
    public static void printLeftView(TreeNode<Integer> root) {
        if(root==null)
         return;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode ad=null;
        while(q.size()!=0)
        {
            int l=q.size();
            System.out.print(q.peek().data+" ");
            for(int i=0;i<l;i++)
            {
                ad=q.poll();
                if(ad.left!=null)
                 q.add(ad.left);
                if(ad.right!=null)
                 q.add(ad.right);
            }
        }
    }
}
