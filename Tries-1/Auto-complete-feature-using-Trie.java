import java.util.Scanner;
public class Trie_Auto_Complete {
    static class TrieNode
    {
        TrieNode[] ch;
        boolean flag;

        public TrieNode() {
            this.flag = false;
            this.ch = new TrieNode[26];
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Strings:");
        int n=sc.nextInt();
        String[] words=new String[n];
        System.out.printf("Enter words");
        for(int i=0;i<n;i++)
         words[i]=sc.next();
        System.out.println("Enter query");
        String query=sc.next();

        TrieNode root=new TrieNode();
        for(int i=0;i<n;i++)
         insert(root,words[i]);

        getAns(root,query);
    }
    public static void insert(TrieNode root,String s)
    {
        TrieNode node=root;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(node.ch[c-'a']==null)
                 node.ch[c-'a']=new TrieNode();
            node=node.ch[c-'a'];
        }
        node.flag=true;
    }
    public static void getAns(TrieNode root,String query)
    {
        TrieNode node=root;
        for(int i=0;i<query.length();i++)
        {
            char c=query.charAt(i);
            if(node.ch[c-'a']==null)
            {
                System.out.println("-1");
                return ;
            }
            node=node.ch[c-'a'];
        }
        printAllAns(node,new StringBuilder(query));
    }
    public static void printAllAns(TrieNode node,StringBuilder s)
    {
        if(node.flag)
            System.out.println(s.toString());
        for(int i=0;i<26;i++)
        {
            if(node.ch[i]!=null)
            {
                s.append((char)(97+i));
                printAllAns(node.ch[i],s);
                s.delete(s.length()-1,s.length());
            }
        }
    }
}

