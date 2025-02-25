import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel implements Runnable {
    double width = 200;
    double height = 200;
    double xInit;
    double yInit;
    double dx;
    double dy;
    Circle circle;

    public DrawPanel() {
        this.setPreferredSize(new Dimension((int) width, (int) height));
        circle = new Circle(10, 10, 10, 10);

        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            xInit = window.getX();
            yInit = window.getY();
        }

        this.startLoop();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(circle);
    }

    @Override
    public void run() {
        while (true) {
            Window window = SwingUtilities.getWindowAncestor(this);

            if (window != null && WinFrame.getIsMoved()) {
                dx = xInit - window.getX();
                dy = yInit - window.getY();
                circle.setPos(circle.x + dx, circle.y + dy);
                System.out.println("X is moved by: " + dx);
                System.out.println("Y is moved by: " + dy);

                xInit = window.getX();
                yInit = window.getY();
                dx = 0;
                dy = 0;
                WinFrame.setIsMoved(false);
            } else if (window != null) {
                xInit = window.getX();
                yInit = window.getY();
            }

            this.repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void startLoop() {
        Thread loop = new Thread(this);
        loop.start();
    }
}
