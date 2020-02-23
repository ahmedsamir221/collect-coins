
package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Finalproject extends JFrame{
     Image player1 , player2,background , previous;
     final int w=765;
     final int h=700;
     Font font = new Font("Comic Sans MS",Font.BOLD,30); 
     private Image mainImage;
     private Graphics mainGraphic;
     Rectangle r;
     
     public Rectangle[][] arr = new Rectangle[11][11];
     player p1 = new player(1);
     player p2 = new player (2);
    coins c1=new coins ();
    
        public Finalproject (){
            ImageIcon play1=new ImageIcon("player1.png");
            ImageIcon play2=new ImageIcon("player2.png");
            ImageIcon back1=new ImageIcon("background.png");
            ImageIcon prev = new ImageIcon("previous.png");
            player1 = play1.getImage();
            player2 = play2.getImage();
            background = back1.getImage();
            previous = prev.getImage();
           c1.random();
            //Add Keylistner
             addKeyListener(new AL());
            setTitle("DEATH MATCH");
            setSize(w , h );   
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
            setBackground(Color.black);    
            
            for (int i=0;i<11;++i) {
                for (int j=0;j<11;j++) {
                r = new Rectangle(3+i*50, 146+j*50, 50,50);
                arr[i][j]=r;
               }
            }
        }
        
        public class AL extends KeyAdapter {
            public void keyPressed (KeyEvent e){
                p1.keyPressed(e);
                //p2.keyPressed(e);
            }
            public void keyReleased (KeyEvent e){
               p1.keyReleased(e);
               //p2.keyReleased(e);
            }
     
        }
        
        public void paint(Graphics g) {  
  
            mainImage = createImage(getWidth(),getHeight());
            mainGraphic=mainImage.getGraphics();
            draw(mainGraphic);
            g.drawImage(mainImage,0,0,this);    
        }
        
        public void draw (Graphics g) {
            if (coins.score >=6 || coins.score1>=6){
            if (coins.score>=6){
                g.drawImage(previous,0,0,this);
                g.setFont(font);
                g.setColor(Color.white);
                g.drawString("YOU WIN", 325, 150);
                repaint();
                //System.exit(0);  ;
            }
            if (coins.score1>=6){
              g.drawImage(previous,0,0,this);
              g.setFont(font);g.setColor(Color.white);
              g.drawString("GAME OVER", 325, 150);
              repaint();
              //System.exit(0); ;
            }
            }
            else{
            g.setColor(Color.white); 
            for (int i=0;i<11;++i) {
                for (int j=0;j<11;j++) {
                g.drawRect(arr[i][j].x, arr[i][j].y, arr[i][j].width, arr[i][j].height);
              
               }
            }
            g.drawImage(player1,560,250,this);
            g.drawImage(player2,560,500,this);
            g.drawImage(background,0,25,this);
            c1.draw(g);
            p2.draw(g);
            p1.draw(g);
            repaint();}
        }
    
    
    
    
    public static void main(String[] args) {
     new Finalproject();
      coins c1=new coins ();
       
        
     
    }
    
}
