import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Diody extends JPanel {

    private Dioda[] tabDioda;

    public Diody() {
        setLayout(new GridLayout(1, 4));
        tabDioda = new Dioda[4];

        tabDioda[0] = new Dioda(Color.RED, 800);
        tabDioda[1] = new Dioda(Color.GREEN, 400);
        tabDioda[2] = new Dioda(Color.GREEN, 400);
        tabDioda[3] = new Dioda(Color.GREEN, 400);

        this.add(tabDioda[0]);
        this.add(tabDioda[1]);
        this.add(tabDioda[2]);
        this.add(tabDioda[3]);
    }

    void setState(int p_index, boolean p_state, boolean p_soundAsDisable) {
        tabDioda[p_index].setState(p_state, p_soundAsDisable);
    }
}
