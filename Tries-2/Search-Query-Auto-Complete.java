class AutoCompleteSystem{
    class TrieNode
    {
        TrieNode[] ch;
        int freq;
        TrieNode()
        {
            ch=new TrieNode[256];
            freq=0;
        }
    }
    class Pair implements Comparable<Pair>
    {
        String sen;
        int freq;
        Pair(String s,int f)
        {
            this.sen=s;
            this.freq=f;
        }
        public int compareTo(Pair p)
        {
            if(this.freq<p.freq)
             return -1;
            if(this.freq==p.freq)
                return -((this.sen).compareTo(p.sen));
            return 1;
        }
    }
    TrieNode root;
    PriorityQueue<Pair> q;
    StringBuilder sb;
    public AutoCompleteSystem(String sentences[], int times[]){
      q=new PriorityQueue<>();
      sb=new StringBuilder();
      root=new TrieNode();
      for(int i=0;i<sentences.length;i++)
       insert(root,sentences[i],times[i]);
    }
    public void insert(TrieNode root,String sen,int times)
    {
       for(int i=0;i<sen.length();i++)
       {
           char c=sen.charAt(i);
           if(root.ch[(int)c]==null)
            root.ch[(int)c]=new TrieNode();
           root=root.ch[(int)c];
       }
       root.freq+=times;
    }
    ArrayList<String> input(char c){
        ArrayList<String> ans=new ArrayList<>();
        if(c=='#')
        {
            insert(root,sb.toString(),1);
            sb.delete(0,sb.length());
        }
        else
        {
            sb.append(c);
            search(root,sb);
            while(q.size()!=0)
             ans.add(0,q.remove().sen);
        }
        return ans;
    }
    public void search(TrieNode root,StringBuilder s)
    {
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(root.ch[(int)c]==null)
             return;
            root=root.ch[(int)c];
        }
        insertInQueue(root,s);
    }
    public void insertInQueue(TrieNode root,StringBuilder s)
    {
        if(root.freq!=0)
         q.add(new Pair(s.toString(),root.freq));
        if(q.size()>3)
         q.remove();
        for(int i=0;i<256;i++)
        {
            if(root.ch[i]!=null)
            {
                s.append((char)(i));
                insertInQueue(root.ch[i],s);
                s.delete(s.length()-1,s.length());
            }
        }
    }
}
