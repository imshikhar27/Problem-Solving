class Solution {
    class TrieNode
    {
        boolean flag;
        TrieNode[] ch;
        TrieNode()
        {
            flag=false;
            ch=new TrieNode[26];
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        
        TrieNode root=new TrieNode();
        for(int i=0;i<dictionary.size();i++)
         createTrie(dictionary.get(i),root);

        String[] arr=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
           sb.append(replace(arr[i],root));
        }
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }
    public void createTrie(String st,TrieNode root)
    {
        TrieNode node=root;
       for(int i=0;i<st.length();i++)
       {
        char c=st.charAt(i);
        if(node.ch[c-'a']==null)
         node.ch[c-'a']=new TrieNode();
        node=node.ch[c-'a'];
       }
       node.flag=true;
    }
    public String replace(String st,TrieNode root)
    {
        TrieNode node=root;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<st.length();i++)
        {
         char c=st.charAt(i);
         if(node.ch[c-'a']==null)
          return st+" ";
         ans.append(c);
         node=node.ch[c-'a'];
         if(node.flag)
          break;
        }
        ans.append(" ");
        return ans.toString();
    }
}
