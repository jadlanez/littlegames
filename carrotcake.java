import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarrotCakeAnimation extends JPanel implements ActionListener {

    private int x = 0;
    private int y = 100;
    private int directionX = 1;
    private int directionY = 1;
    private Timer timer;

    public CarrotCakeAnimation() {
        // Set up the timer to call actionPerformed every 10 milliseconds
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set the background color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the carrot cake (a simple orange rectangle)
        g2d.setColor(new Color(255, 165, 0));
        g2d.fillRect(x, y, 100, 50);

        // Draw the text
        g2d.setFont(new Font("San Francisco", Font.PLAIN, 24)); // Using a generic sans-serif font
        g2d.setColor(Color.BLACK);
        g2d.drawString("I'm proud of you", x, y - 10);

        // Move the carrot cake
        x += directionX;
        y += directionY;

        // Bounce the carrot cake off the edges
        if (x < 0 || x + 100 > getWidth()) {
            directionX = -directionX;
        }
        if (y < 0 || y + 50 > getHeight()) {
            directionY = -directionY;
        }

        // Repaint the component to keep the animation going
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This is called by the timer to update the animation
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Y2K Carrot Cake Animation");
        CarrotCakeAnimation animation = new CarrotCakeAnimation();
        frame.add(animation);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}