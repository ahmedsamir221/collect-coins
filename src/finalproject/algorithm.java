
package finalproject;
public class algorithm {
    int yy1,yy2,gx,gy;
    int b1[]=new int [13];
        int b2[]=new int [13];
         int x=4;
    
 public  int mem[][][][] =new int[20][20][1<<12][20];
 public   int mem2[][][]=new int [20][1<<12][20];
    void var()
    {
         
      
 for(int i=0;i<20;i++ )
  {
      for(int j=0;j<20;j++)
      {
          for(int k=0;k<1<<12;k++)
          {
              for(int y=0;y<20;y++)
              {
                  mem[i][j][k][y]=-1;
              }
          }
      }
  }
 for(int j=0;j<20;j++)
      {
          for(int k=0;k<1<<12;k++)
          {
              for(int y=0;y<20;y++)
              {
                  mem2[j][k][y]=-1;
              }
          }
      }
    }
void getarray(int a[],int b[],int x,int y)
{
    for(int i=0;i<12;i++)
 {
     b1[i]=0;
     b2[i]=0;
 }
    for(int i=0;i<12;i++)
    {
        b1[i]=a[i];
         b2[i]=b[i];
    }
    yy1=x;
    yy2=y;
    
}
   
   
    algorithm()
    {
        
 
    }
   
   
    int getBit(int num, int idx) {
  return (((num >> idx) & 1) == 1?1:0);	
}

int setBit1(int num, int idx) {
	return num | (1<<idx);
}

int setBit0(int num, int idx) {
	return num & ~(1<<idx);				
}

int flipBit(int num, int idx) {
	return num ^ (1<<idx);
}
int  dp(int i,int k,int u,int s,int coin)
{
    
   if(k==Math.min(3,(6-coins.score1)))return 0;
    if(mem[i][k][u][s]!=-1)
    {
        return mem[i][k][u][s];
    }
      mem[i][k][u][s]=100000;
    for(int w=1;w<=coin;w++)
    {
        int  l=u;
        int h=b1[w];
        int hh=b2[w];
         int hhh=b1[i];
        int hhhh=b2[i];
         if(getBit( l, w)==1&&Math.abs(h-yy1)+Math.abs(hh-yy2)>=s+Math.abs(hhh-h)+Math.abs(hhhh-hh)){
               l=setBit0(l, w);
       mem[i][k][u][s]=Math.min(mem[i][k][u][s],dp(w,k+1,l,s+Math.abs(hhh-h)+Math.abs(hhhh-hh),coin)+Math.abs(hhh-h)+Math.abs(hhhh-hh));
        }

    }
    return  mem[i][k][u][s];
}
void  dp2(int i,int k,int  u,int s,int coin)
{
    if(k==Math.min(3,(6-coins.score1)))return ;
    for(int w=1;w<=coin;w++)
    {
        int  l=u;
        l=setBit0(l, w);
      if(getBit(u,w)==1&&Math.abs(b1[w]-yy1)+Math.abs(b2[w]-yy2)>=s+Math.abs(b1[i]-b1[w])+Math.abs(b2[i]-b2[w])&&dp(i,k,u,s,coin)==dp(w,k+1,l,s+Math.abs(b1[i]-b1[w])+Math.abs(b2[i]-b2[w]),coin)+Math.abs(b1[i]-b1[w])+Math.abs(b2[i]-b2[w]))
       {
         //  cout<<b[w].first<<" "<<b[w].second<<endl
          gx=b1[w];
          gy=b2[w];
          break;
       }
    }
}
int  dp3(int i,int  u,int s,int coins)
{
   
    if(mem2[i][u][s]!=-1)
    {
        return mem2[i][u][s];
    }
   mem2[i][u][s]=0;
    
    for(int w=1;w<=coins;w++)
    {
        int l=u;
        if(getBit(u, w)==1&&Math.abs(b1[w]-yy1)+Math.abs(b2[w]-yy2)>=s+Math.abs(b1[i]-b1[w])+Math.abs(b2[i]-b2[w])){
                l=setBit0(l, w);
        mem2[i][u][s]=Math.max(mem2[i][u][s],dp3(w,l,s+Math.abs(b1[i]-b1[w])+Math.abs(b2[i]-b2[w]),coins)+1);
        }
    }
    return mem2[i][u][s];
}
void  dp4(int i,int u,int s,int coins)
{
     
    for(int w=1;w<=coins;w++)
    {
        int l=u;
         l=setBit0(l, w);
    if(getBit(u,w)==1&&dp3(i,u,s,coins)==dp3(w,l,s+Math.abs(b1[i]-b1[w])+Math.abs(b2[i]-b2[w]),coins)+1&&Math.abs(b1[w]-yy1)+Math.abs(b2[w]-yy2)>=s+Math.abs(b1[i]-b1[w])+Math.abs(b2[i]-b2[w])){
            gx=b1[w];
          gy=b2[w];
          break;
           
        }
    }

}
int xx()
{
    return gx;
}
int yy()
{
    return gy;
}
    
}
