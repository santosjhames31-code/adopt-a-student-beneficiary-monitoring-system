package Java.javaswing.Frame;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Main{
    public static void main(String[] args) {
        
        //FRAME
        JFrame frame = new JFrame();
        frame.setTitle("Jhames");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //ICON LOGO
        ImageIcon image = new ImageIcon("Java/javaswing/Frame/logo.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color());

        frame.setVisible(true);
    }
}