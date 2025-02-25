import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class WinFrame extends JFrame{
    final static double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final static double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    static boolean isMoved;
    public WinFrame(){
        this.setSize(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        System.out.println(width +" "+" "+ height);
        ComponentListener windowMovedListener = new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                if (e!= null){
                    isMoved = true;
                }
            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        };
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.addComponentListener(windowMovedListener);
    }
    public void exec_(){
        this.setVisible(true);
        DrawPanel panel = new DrawPanel();
        this.add(panel);
    }
    public static double getScreenWidth(){
        return width;
    }
    public static double getScreenHeight(){
        return height;
    }
    public static boolean getIsMoved(){
        return isMoved;
    }
    public static void setIsMoved(boolean val){
        isMoved = val;
    }
}
