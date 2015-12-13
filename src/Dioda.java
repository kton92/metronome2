import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Dioda extends JPanel {

    private Color offColor = new Color(150, 150, 150); // szary
    private Color onColor;
    private int frequency;

    private boolean state;

    public Dioda(Color p_color, int p_frequency) {
        onColor = p_color;
        frequency = p_frequency;
        state = false;
    }

    private Graphics2D g2d;

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g2d = (Graphics2D) g.create();

        if (state == true) {
            // on
            g2d.setPaint(onColor);
        } else {
            // off
            g2d.setPaint(offColor);
        }

        g2d.fillOval(28, 0, 30, 30);
        g2d.dispose();

    }

    void setState(boolean p_state, boolean p_soundAsDisable) {
        state = p_state;
        repaint();
        if (state == true) {
            beep();
        } else {
            if (p_soundAsDisable == true) {
                beep();
            }
        }
    }

    private void beep() {
        try {
            Sound.beep(frequency, 200);
        } catch (Exception e) {
            System.out.println("Nie mog� odegra� d�wi�ku " + frequency + "Hz");
            e.printStackTrace();
        }
    }
}
