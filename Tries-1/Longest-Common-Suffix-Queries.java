class Solution {
    class TrieNode
    {
        TrieNode[] ch;
        int ind;
        TrieNode()
        {
            ch=new TrieNode[26];
            ind=-1;
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root=new TrieNode();
        for(int i=0;i<wordsContainer.length;i++)
         insert(root,i,wordsContainer[i],wordsContainer);
        
        int[] ans=new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++)
         ans[i]=retrieve(root,wordsQuery[i]);
        return ans;
    }
    public void insert(TrieNode root,int ind,String word,String[] wordsContainer)
    {
        String wrd=(root.ind!=-1)?wordsContainer[root.ind]:"";
        if(wrd.equals("") || wrd.length()>word.length())
            root.ind=ind;
        for(int i=word.length()-1;i>=0;i--)
        {
            char c=word.charAt(i);
            if(root.ch[c-'a']==null)
             root.ch[c-'a']=new TrieNode();
            root=root.ch[c-'a'];
            wrd=(root.ind!=-1)?wordsContainer[root.ind]:"";
            if(wrd.equals("") || wrd.length()>word.length())
                root.ind=ind;
        }
    }
    public int retrieve(TrieNode root,String word)
    {
        for(int i=word.length()-1;i>=0;i--)
        {
            char c=word.charAt(i);
            if(root.ch[c-'a']==null)
             break;
            root=root.ch[c-'a'];
        }
        return root.ind;
    }

}
