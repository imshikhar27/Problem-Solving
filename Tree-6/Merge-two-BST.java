class Solution
{
    public List<Integer> merge(Node root1,Node root2)
    {
        ArrayList<Integer> ls=new ArrayList<>();
        int k1=1,k2=1;
        Stack<Node> s1=new Stack<>();
        s1.push(root1);
        Stack<Node> s2=new Stack<>();
        s2.push(root2);
        while(!s1.isEmpty() && !s2.isEmpty())
        {
            while(s1.peek().left!=null && k1==1)
             s1.push(s1.peek().left);
            while(s2.peek().left!=null && k2==1)
             s2.push(s2.peek().left);
             
            k1=0;
            k2=0;
            Node top1,top2,ntop=null;
            Stack<Node> ns;
            do
            {
                top1=s1.peek();
                top2=s2.peek();
                if(top1.data<=top2.data)
                {
                    ls.add(top1.data);
                    ntop=top1;
                    ns=s1;
                    s1.pop();
                }
                else
                {
                   ls.add(top2.data);
                   ns=s2;
                   s2.pop();
                   ntop=top2;   
                }
            }while(!ns.isEmpty() && ntop.right==null);
            if(ntop.right!=null)
            {
                if(ns==s1)
                 k1=1;
                else
                 k2=1;
                ns.push(ntop.right);
            }
        }
        Stack<Node> ns;
        if(!s1.isEmpty())
         ns=s1;
        else
         ns=s2;
        while(!ns.isEmpty())
        {
            Node top;
            do
            {
                top=ns.pop();
                ls.add(top.data);
            }while(!ns.isEmpty() && top.right==null);
            if(top.right!=null)
             ns.push(top.right);
            while(!ns.isEmpty() && ns.peek().left!=null)
             ns.push(ns.peek().left);
        }
        return ls;
    }
}

