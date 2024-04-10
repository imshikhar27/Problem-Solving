class Trie {

    class Node
    {
        Node[] ch;
        boolean flag;
        Node()
        {
            ch=new Node[26];
            flag=false;
        }
    }
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node pos=root;
        for(int i=0;i<word.length();i++)
        {
         char c=word.charAt(i);
         if(pos.ch[c-'a']==null)
          pos.ch[c-'a']=new Node();
         pos=pos.ch[c-'a'];
        }
        pos.flag=true;
    }
    
    public boolean search(String word) {
        Node pos=root;
        for(int i=0;i<word.length();i++)
        {
         char c=word.charAt(i);
         if(pos.ch[c-'a']==null)
          return false;
         pos=pos.ch[c-'a'];
        }
        return pos.flag==true;
    }
    
    public boolean startsWith(String prefix) {
        Node pos=root;
        for(int i=0;i<prefix.length();i++)
        {
         char c=prefix.charAt(i);
         if(pos.ch[c-'a']==null)
          return false;
         pos=pos.ch[c-'a'];
        }
        return true;
    }
}
