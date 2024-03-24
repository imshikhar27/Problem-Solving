class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb1=new StringBuilder();
        find(root,sb1,startValue);
        StringBuilder sb2=new StringBuilder();
        find(root,sb2,destValue);
        int i=0;
        while(i<sb1.length() && i<sb2.length() && sb1.charAt(i)==sb2.charAt(i))
         i++;
        int depth=sb1.length()-i;
        StringBuilder ans=new StringBuilder();
        for(int j=0;j<depth;j++)
         ans.append("U");
        sb2.delete(0,i);
        return ans.toString()+sb2.toString();
    }
    public boolean find(TreeNode root,StringBuilder sb,int x)
    {
      if(root==null)
       return false;
      if(root.val==x)
       return true;
      sb.append("L");
      boolean l=find(root.left,sb,x);
      if(l)
       return true;
      sb.delete(sb.length()-1,sb.length());
      sb.append("R");
      boolean r=find(root.right,sb,x);
      if(r) 
       return true;
      sb.delete(sb.length()-1,sb.length());
      return false;
    }  
}
