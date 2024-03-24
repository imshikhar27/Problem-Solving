public class Solution {
    ArrayList<Integer> ans;
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ans=new ArrayList<>();
        find(A,B);
        return ans;
    }
    public boolean find(TreeNode A,int B)
    {
        if(A==null)
         return false;
        ans.add(A.val);
        boolean a=A.val==B||find(A.left,B)||find(A.right,B);
        if(a)
         return true;
        ans.remove(ans.size()-1);
        return false; 
    }
}

