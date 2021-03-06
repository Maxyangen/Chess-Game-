import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.image.BufferedImage;
public class View
{
    private ChessBoard chessboard ;
    private JFrame parent;
    private JButton[][] JB = new JButton[4][8];
    private int i , j , x , y;
  
    public View(){
        chessboard = ChessBoard.getChessBoard();
        JButton();
    }
    public void rest(){
        for(i = 0;i < 4;i++){
                for (j = 0;j < 8;j++){
                    JB[i][j].setIcon(chessboard.getChessImage(i,j));
                }
       }
    }
    public void JButton(){
        parent = new JFrame("jb");
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        

        parent.setSize(900, 300); 
        parent.setLocationRelativeTo(null);  //顯示在中間
        parent.setVisible(true); 
        parent.repaint();
        parent.setResizable(false);
        
        Container cp=parent.getContentPane();
        
        cp.setLayout(new FlowLayout(FlowLayout.LEFT));
        
       ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton jbtemp = (JButton)e.getSource() ;
            for(i = 0;i < 4;i++){
                for (j = 0;j < 8;j++){
                    if (JB[i][j] == jbtemp){
                        if (JB[i][j] == jbtemp){
                            chessboard.touchChess(i,j);
                            break;
                            }   
                        }
                    }
               }
            rest();
           }
        };

        for(i = 0;i < 4;i++){
            for (j = 0;j < 8;j++){
                 JB[i][j] = new JButton(chessboard.getChessImage(i,j));
                 
                }
            }
        for (i = 0  , y = 50; i < 4; i++ ,y+=50){
             for (j = 0 ,x = 30; j <8; j++ ,x+=100){
                 JB[i][j].setBounds( x , y ,100,50); 
                 JB[i][j].setPreferredSize(new Dimension(100,50));
                 JB[i][j].addActionListener(listener);
             }
        }
        for(i = 0;i < 4;i++){
            for (j = 0;j < 8;j++){
                cp.add( JB[i][j] );
               
            } 
        }
        
    }
 

  }
    
   

 
