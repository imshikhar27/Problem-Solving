import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class TestClass {
    static class TrieNode
    {
        TrieNode[] ch;
        long freq;
        TrieNode(){
            ch=new TrieNode[2];
            freq=0;
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[n];
            for(int j=0;j<n;j++)
             arr[j]=sc.nextInt();
            System.out.println(count(arr,n,k));
        }
    }
    public static long count(int[] arr,int n,int k)
    {
        TrieNode root=new TrieNode();
        int pre=0;
        long c=0;
        insert(root,0);
        for(int i:arr)
        {
         pre^=i;
         c+=search(root,pre,k,20);
         insert(root,pre);
        }
        return c;
    }
    public static void insert(TrieNode root,int x)
    {
        int ind=20;
        while(ind>=0)
        {
            int bit=(x>>ind)&1;
            if(root.ch[bit]==null)
             root.ch[bit]=new TrieNode();
            root=root.ch[bit];
            root.freq++;
            ind--;
        }
    }
    public static long search(TrieNode root,int pre,int k,int bit)
    {
        if(root==null)
         return 0;
        if(bit==-1)
         return 0;
        int preBit=(pre>>bit)&1,kBit=(k>>bit)&1;
        if(preBit==0 && kBit==1)
            return cnt(root,0)+search(root.ch[1],pre,k,bit-1);
        if(preBit==1 && kBit==1)
            return cnt(root,1)+search(root.ch[0],pre,k,bit-1);
        if(preBit==0 && kBit==0)
            return search(root.ch[0],pre,k,bit-1);
        return search(root.ch[1],pre,k,bit-1);
    }
    public static long cnt(TrieNode root,int x)
    {
        return (root.ch[x]==null)?0:root.ch[x].freq;
    } 
}

