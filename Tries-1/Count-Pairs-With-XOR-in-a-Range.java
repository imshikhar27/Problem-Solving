class Solution {
    class TrieNode
    {
        TrieNode[] ch;
        int freq;
        TrieNode()
        {
            freq=0;
            ch=new TrieNode[2];
        }
    }
    public int countPairs(int[] nums, int low, int high) {
        TrieNode root=new TrieNode();
        insert(root,nums[0]);
        int count=0;
        for(int i=1;i<nums.length;i++)
        {
            count+=getAns(root,nums[i],high,14);
            count-=getAns(root,nums[i],low-1,14);
            insert(root,nums[i]);
        }
        
        return count;
    }
    public void insert(TrieNode root,int num)
    {
        int ind=14;
        while(ind>=0)
        {
            int bit=(num>>ind)&1;
            if(root.ch[bit]==null)
             root.ch[bit]=new TrieNode();
            root=root.ch[bit];
            root.freq++;
            ind--;
        }
    }
    public int getAns(TrieNode root,int num,int high,int bit)
    {
     if(bit==-1)
         return root.freq;
     int bitInHigh=(high>>bit)&1;
     int bitInNum=(num>>bit)&1;
     int ans=0;
     if(bitInHigh==1)
     {
      int bitReq=(1+bitInNum)%2;
      ans+=(root.ch[bitInNum]==null)?0:root.ch[bitInNum].freq;
      if(root.ch[bitReq]!=null)
       ans+=getAns(root.ch[bitReq],num,high,bit-1);
     }
     else
     {
      if(root.ch[bitInNum]!=null)
       ans+=getAns(root.ch[bitInNum],num,high,bit-1);
     }
     return ans;
    }

}
