import java.util.*;
class Main
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();
    int M=sc.nextInt();
    int K=sc.nextInt();
    int[] A=new int[N];
    for(int i=0;i<N;i++)
     A[i]=sc.nextInt();
    int[] B=new int[M];
    for(int i=0;i<M;i++)
     B[i]=sc.nextInt();
    System.out.println(getAns(A,B,N,M,K));
  }
  public static int getAns(int[] A,int[] B,int N,int M,long K)
  {
    long At=0,Bt=0;
    long[] C=new long[M+1];
    int cend=0;
    for(cend=1;cend<M+1;cend++)
    {
      Bt+=B[cend-1];
      if(Bt>1000000000)
       break;
      C[cend]=Bt;
    }
    if(cend==M+1)
     cend--;
    int ans=get(C,cend,K);
    for(int i=0;i<N;i++)
    {
      K-=A[i];
      if(K<0)
       break;
      ans=Math.max(ans,(i+1)+get(C,cend,K));
    }
    return ans;
  }
  public static int get(long[] C,int cend,long t)
  {
    int cs=0;
    while(cs<=cend)
    {
      int m=cs+(cend-cs)/2;
      if(C[m]==t)
       return m;
      if(C[m]<t)
       cs=m+1;
      else
       cend=m-1;
    }
    return cend;
  }
}
