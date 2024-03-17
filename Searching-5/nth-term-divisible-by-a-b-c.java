import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        int n=in.nextInt();
        int g=lcm(a,b),h=lcm(b,c),i=lcm(c,a),j=lcm(a,h);
        int min=Math.min(a,Math.min(b,c));
        int s=min,e=(n>=Integer.MAX_VALUE/min)?Integer.MAX_VALUE:min*n;
        int ans=0;
        while(s<e)
        {
            int m=s+(e-s)/2;
            int count=m/a+m/b+m/c-m/g-m/h-m/i+m/j;
            if(count<n)
             s=m+1;
            else
             e=m;
        }
        System.out.println(e);
    }
    public static int gcd(int a,int b)
    {
     if (a==0)
        return b;
     return gcd(b%a,a);
    }
    public static int lcm(int a,int b)
    {
     return (a/gcd(a,b))*b;
    }
}
