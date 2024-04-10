class Solution {
    class TrieNode
    {
        TrieNode[] ch;
        short count;
        TrieNode()
        {
            ch=new TrieNode[26];
            count=0;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        TrieNode root=new TrieNode();
        for(String s:words)
         insert(root,s);
        int[] ans=new int[words.length];
        for(int i=0;i<words.length;i++)
        {
            ans[i]=getAns(words[i],root);
        }
        return ans;
    }
    public void insert(TrieNode root,String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(root.ch[c-'a']==null)
             root.ch[c-'a']=new TrieNode();
            root=root.ch[c-'a'];
            root.count++;
        }
    }
    public int getAns(String s,TrieNode root)
    {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            root=root.ch[c-'a'];
            ans+=root.count;
        }
        return ans;
    }
}
