class Solution{
    static class TrieNode
    {
        TrieNode[] ch;
        boolean flag;
        TrieNode()
        {
            ch=new TrieNode[26];
            flag=false;
        }
    }
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        TrieNode root=new TrieNode();
        for(String s1:contact)
         insert(root,s1);
        
        StringBuilder q=new StringBuilder();
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            q.append(s.charAt(i));
            ArrayList<String> temp=new ArrayList<>();
            search(root,q,temp);
            temp.sort(new Comparator<String>(){
                public int compare(String a,String b)
                {
                    return a.compareTo(b);
                }
            });
            ans.add(temp);
        }
        return ans;
    }
    static void insert(TrieNode root,String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(root.ch[c-'a']==null)
             root.ch[c-'a']=new TrieNode();
            root=root.ch[c-'a'];
        }
        root.flag=true;
    }
    public static void search(TrieNode root,StringBuilder q,ArrayList<String> temp)
    {
        for(int i=0;i<q.length();i++)
        {
            char c=q.charAt(i);
            if(root.ch[c-'a']==null)
            {
                temp.add("0");
                return ;
            }
            root=root.ch[c-'a'];
        }
        insertInList(root,q,temp);
    }
    public static void insertInList(TrieNode root,StringBuilder q,ArrayList<String> temp)
    {
        if(root.flag==true)
         temp.add(q.toString());
         
        for(int i=0;i<26;i++)
        {
            if(root.ch[i]!=null)
            {
                q.append((char)('a'+i));
                insertInList(root.ch[i],q,temp);
                q.delete(q.length()-1,q.length());
            }
        }
    }
}
