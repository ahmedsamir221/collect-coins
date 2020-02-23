package finalproject;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public  class coins extends JFrame {
    
    Random r1 = new Random();
    Image Coin;
    int f;
    static int score = 0;
   public static int score1 = 0;
    public final int ycor []={0,160,210,260,310,360,410,460,510,560,610,660};
    public final int xcor []={0,15,65,115,165,215,265,315,365,415,465,515};
    static int xx[]=new int [11];      
    static int yy[]=new int [11];
    Image player1 , player2 , background;
    static  boolean freqarr[][]= new boolean[100][100]; 
    //public final int xrand []={r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1};
    //public  final int yrand []={r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1};
    public final int xrand []={r1.nextInt(3)+9,r1.nextInt(4)+8,r1.nextInt(5)+7,r1.nextInt(6)+6,r1.nextInt(7)+5,r1.nextInt(8)+4,r1.nextInt(9)+3,r1.nextInt(10)+2,r1.nextInt(11)+1,r1.nextInt(11)+1,r1.nextInt(11)+1};
    public  final int yrand []={1,2,3,4,5,6,7,8,9,10,11};
    Font font = new Font("Comic Sans MS",Font.BOLD,30); 
   public coins(){
        ImageIcon c = new ImageIcon ("3.png");
        Coin = c.getImage();
        
    }
    
   public  void random()
                       {
                      for(int i=0;i<12;i++)
        {
                for(int j=0;j<12;j++)
                {
                       freqarr[i][j]=false;
                }
        
        }
                           
                for (int i=0;i<11;++i){ // to hold 10 random number 
                   xx[i]= xrand[i];
                    yy[i]=yrand[i];  
                  
                }
                for (int i=0;i<11;++i){ 
                  freqarr[xx[i]][yy[i]]=true;
                 
                }
                
                       }
    
   
    public void draw (Graphics g){
             /* for ( f=1;f<12;f++){ // to array has a cordinate of all rectangel 
                    xcor[f]=15+(f-1)*50;
                    ycor[f]=160+(f-1)*50;
                }*/
                
                for (int i=0;i<11;++i){
                    if ( player.x0==xx[i]&&player.y0==yy[i]||player.x1==xx[i]&&player.y1==yy[i])// to check player on coin
                    {
                         freqarr[xx[i]][yy[i]]=false;
                         
                         
                    }
                    if(freqarr[xx[i]][yy[i]]== true){// to check if hidden or no
                        
                        g.drawImage(Coin,xcor[xx[i]],ycor[yy[i]], this);
                    }
                    else continue;
                    
                } 
                //g.drawString("cor "+player.x+" "+player.y, 50, 50);
                g.setFont(font);
                g.drawString("Player  : "+score, 560, 200);
                g.drawString("Computer : "+score1, 560, 450);
                
               
    }

     public int [] xgetarray()
     {
         
return xcor;
     }
      public int [] ygetarray()
     {
         
return ycor;
     }
      public int [] ygetRand()
     {
         
return yy;
     }
      public int [] xgetRand()
     {
         
return xx;
     }
      public boolean [][]frqarr()
      {
          return freqarr;
      }
}