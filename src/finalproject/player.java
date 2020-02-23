package finalproject;

import static finalproject.coins.xx;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

    public class player extends JFrame  {
        int s=0,Xdiraction,Ydiraction,up,down,left,right,xcom,ycom,xuser,yuser,ff,gg,diraction=0;
          int l,y,u,d;
       algorithm  Algorithm=new algorithm();
          int c1[]=new int[100];
      int c2[]=new int[100];
        // boolean a[][]=new boolean[12][12];
        
        
         int count=0;
         int flagarr[]=new int [11];
         int flagarr1[]=new int [11];
         static int x0= 1;
         static int x1= 1;
         boolean flag= true;
         static int y0 =1;
         static int y1 =2;
        Image ball , ball1; 
        int id ;
        coins c10= new coins();
       
      //  Finalproject ob = new Finalproject();
        public player (int id ){
           ImageIcon i = new ImageIcon ("1.png");
           ball = i.getImage();
           ImageIcon i1 = new ImageIcon ("2.png");
           ball1 = i1.getImage();
           
           this.id = id;
        }   
      boolean ch=false;
            public void keyPressed (KeyEvent e){  
                    
                     
                int keyCode = e.getKeyCode();
                count++;
                if (count>1) return; 
                if (keyCode == e.VK_LEFT) { 
                    if (x0<=1) 
                    {x0=1;}
                    else if(x1!=x0-1||y1!=y0)
                    {
                        x0--;
                     ch=true;                 
                    }
                    
                   
                }
                if (keyCode == e.VK_RIGHT) {
                    if (x0>=11) x0=11;
                      else if(x1!=x0+1||y1!=y0)
                      {x0++;
                      ch=true;
                      }
                   
                      
                                   
                }
                if (keyCode == e.VK_UP) {
                    if (y0<=1) y0=1;
                    else if(y1!=y0-1||x0!=x1)
                    {y0--;
                    ch=true;
                    }
                  
                   
                }
                if (keyCode == e.VK_DOWN) {
                    if (y0>=11) y0=11;
                    else if(y0+1!=y1||x1!=x0)
                    {y0++;
                    ch=true;
                    }
                  
                
                }
                    
                for (int i=0;i<11;++i){    
                  if ( x0==coins.xx[i]&&y0==coins.yy[i] && flagarr[i]==0 )// to check player on coin
                    {
                         coins.score++;
                         flagarr[i]=1;// to increment the score only one time
                    }
            }   
            
            }
                     
            
                    
            public void keyReleased (KeyEvent e){
                
                   count = 0;
  ///////////////////////////////////////////////////////////////////
  if(ch)
  {
      ch=false;
    Algorithm.var();
     c1[0]=y1;
     
     c2[0]=x1;
     
     xcom=c1[0];
     ycom=c2[0];
     xuser=y0;
     yuser=x0;
     
     
     int r=1;
     for(int i=1;i<12;i++){
         for(int q=1;q<12;q++)
         {
             if(coins.freqarr[i][q]==true)
             {
                
                 c2[r]=i;
                 c1[r]=q;
               
                 r++;
                 
             }
         }}
      Algorithm.getarray(c1,c2 ,xuser,yuser);
     
   if( Algorithm.dp(0,0,(1<<r)-2,0,r-1)<900)
     {
        Algorithm.dp2(0, 0,(1<<r)-2 ,0, r-1);
     }
     else
     {
         Algorithm.dp3(0, (1<<r)-2, 0, r-1);
         Algorithm.dp4(0, (1<<r)-2, 0, r-1);
     }
   Xdiraction=Algorithm.xx();
   Ydiraction= Algorithm.yy();
  up=Math.abs((Xdiraction)-(xcom-1))+Math.abs(Ydiraction-ycom);
     down=Math.abs((Xdiraction)-(xcom+1))+Math.abs(Ydiraction-ycom);
       left=Math.abs((Xdiraction)-xcom)+Math.abs((Ydiraction)-(ycom-1));
       right=Math.abs((Xdiraction)-(xcom))+Math.abs((Ydiraction)-(ycom+1));
       y=Math.abs((xuser)-(xcom))+Math.abs((yuser)-(ycom+1));
       l=Math.abs((xuser)-xcom)+Math.abs((yuser)-(ycom-1));
       u=Math.abs((xuser)-(xcom-1))+Math.abs(yuser-ycom);
       d=Math.abs((xuser)-(xcom+1))+Math.abs(yuser-ycom);
       if(up<=down&&up<=left&&up<=right)
       {
           if(up==right)
           {
               ff=u;
               gg=y;
               if(ff<=gg)
                   diraction=1;
               else
               {
                 
                   diraction=3;
               }
                   
           }
           else if(up==left)
           {
               ff=u;
               gg=l;
               if(ff<=gg)
                   diraction=1;
               else
                   diraction=4;
               
           }
           else  diraction=1;
       }
       else  if(right<=up&&right<=left&&right<=down)
       {
           if(right==up)
           {
               ff=y;
               gg=u;
               if(ff<=gg)
               diraction=3;
                 
               
               else
                   diraction=1;
                   
           }
           else if(down==right)
           {
                ff=y;
               gg=d;
               if(ff<=gg)
               {
                   diraction=3;
               }
               
               else
                   diraction=2;
               
           }
           else 
           {diraction=3;
              
           }
           
       }
       else  if(left<=up&&left<=down&&left<=right)
       {
           if(left==up)
           {
               ff=l;
               gg=u;
               if(ff<=gg)
                   diraction=4;
               else
                   diraction=1;
                   
           }
           else if(down==left)
           {
                ff=l;
               gg=d;
               if(ff<=gg)
                   diraction=4;
               else
                   diraction=2;
               
           }
           else  diraction=4;
       }
       else  if(down<=up&&down<=left&&down<=right)
       {
           if(down==right)
           {
               ff=d;
               gg=y;
               if(ff<=gg)
                   diraction=2;
               else
               {diraction=3;
              
               }
               
                   
           }
           else if(down==left)
           {
                ff=d;
               gg=l;
               if(ff<=gg)
                   diraction=2;
               else
                   diraction=4;
               
           }
           else  diraction=2;
       }
                            /*************************************************/
                             System.out.println(Xdiraction+" "+Ydiraction);
                            System.out.println(diraction);
                            
                            int keyCode = diraction;
                  //                  count++;
                //if (count>1) return; 
                if (keyCode == 4) { 
                    if (x1<=1) x1=1;
                      else x1--;
                }
                if (keyCode == 3) {
                    if (x1>=11) x1=11;
                      else   x1++;             
                }
                if (keyCode == 1) {
                    if (y1<=1) y1=1;
                     else y1--;
                   
                }
                if (keyCode == 2) {
                    if (y1>=11) y1=11;
                    else y1++;
                
                }
                for (int i=0;i<11;++i){    
                  if ( x1==coins.xx[i]&&y1==coins.yy[i] && flagarr[i]==0 )// to check player on coin
                    {
                         coins.score1++;
                         flagarr[i]=1;
                    }
            }  
                }
                     
                
            }  
   
  ///////////////////////////////////////////////////////////////////
            
            
    
            public void draw (Graphics g){
          
            switch(id){
                default : System.out.println("a valid player");break;
                case 1 :
                g.drawImage(ball,c10.xgetarray()[x0],c10.ygetarray()[y0],this);
                break;
                case 2 :
                g.drawImage(ball1,c10.xgetarray()[x1],c10.ygetarray()[y1],this);
                break;
             //  g.drawString("cor "+x+" "+y,50 , 80);
               
            }
            }
            
    }
