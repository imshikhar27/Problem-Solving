class Solution {
    class Node
    {
        Node[] ch;
        Node()
        {
            ch=new Node[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        Node root=new Node();
        int max=-1;
        for(int i:nums)
         max=Math.max(max,i);
        int n=(int)(Math.log(max)/Math.log(2))+1;
        for(int i:nums)
         insert(root,i,n-1);
        return check(root,root,n-1);
    }
    public void insert(Node root,int num,int n)
    {
        Node pos=root;
        while(n>0)
        {
            int bit=num&(1<<n);
            if(pos.ch[bit]==null)
             pos.ch[bit]=new Node();
            pos=pos.ch[bit];
            n--;
        }
    }
    public int check(Node root1,Node root2,int n)
    {
     if(n<0)
      return 0;
     int ans1=0,ans2=0;
     if( root1.ch[0]!=null && root2.ch[1]!=null)
        ans1=1<<n|check(root1.ch[0],root2.ch[1],n-1);
     if(root1.ch[1]!=null && root2.ch[0]!=null)
        ans2=1<<n|check(root1.ch[1],root2.ch[0],n-1);


     if(ans1==0 && ans2==0)
     { 
       if(root1.ch[0]!=null && root2.ch[0]!=null)
        ans1=check(root1.ch[0],root2.ch[0],n-1);
       if(root1.ch[1]!=null && root2.ch[1]!=null)
        ans2=check(root1.ch[1],root2.ch[1],n-1);
       return Math.max(ans1,ans2);
     }
        return Math.max(ans1,ans2);
    }
    
}
