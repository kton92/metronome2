import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Metronom extends JFrame {

    private SpinnerNumberModel spinnerModel;
    private JSpinner spinner;

    private JCheckBox checkBox;

    private JRadioButton rButton1;
    private JRadioButton rButton2;
    private JRadioButton rButton3;
    private JRadioButton rButton4;
    private ButtonGroup buttonGroup;

    private Diody diodyPanel;

    private Silnik silnik;

    public Metronom() {
        init();
    }

    private void init() {
        this.setTitle("Metronom");
        setLocation(100, 100);

        Dimension dim = new Dimension(400, 200);
        this.setSize(dim);
        this.setMinimumSize(dim);
        this.setMaximumSize(dim);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(4, 1);
        this.setLayout(layout);

        spinnerModel = new SpinnerNumberModel(120, 60, 200, 1);
        spinner = new JSpinner(spinnerModel);

        JPanel panel1 = new JPanel();
        panel1.add(spinner);
        this.add(panel1);

        checkBox = new JCheckBox("ON/OFF");
        JPanel panel2 = new JPanel();
        panel2.add(checkBox);
        this.add(panel2);

        checkBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println(checkBox.isSelected());
                if (checkBox.isSelected()) {
                    spinner.setEnabled(false);
                    rButton1.setEnabled(false);
                    rButton2.setEnabled(false);
                    rButton3.setEnabled(false);
                    rButton4.setEnabled(false);

                    int tempo = (int) spinner.getValue();
                    int metrum = getMetrum();
                    silnik = new Silnik(tempo, metrum, diodyPanel);
                    new Thread(silnik).start();
                } else {
                    spinner.setEnabled(true);
                    rButton1.setEnabled(true);
                    rButton2.setEnabled(true);
                    rButton3.setEnabled(true);
                    rButton4.setEnabled(true);
                    silnik.stop();
                }
            }
        });

        rButton1 = new JRadioButton("1/4");
        rButton2 = new JRadioButton("2/4");
        rButton3 = new JRadioButton("3/4");
        rButton4 = new JRadioButton("4/4");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rButton1);
        buttonGroup.add(rButton2);
        buttonGroup.add(rButton3);
        buttonGroup.add(rButton4);
        rButton4.setSelected(true);

        JPanel panel3 = new JPanel();

        panel3.add(rButton1);
        panel3.add(rButton2);
        panel3.add(rButton3);
        panel3.add(rButton4);
        this.add(panel3);

        diodyPanel = new Diody();
        diodyPanel.setSize(new Dimension(100, 100));

        this.add(diodyPanel);

        pack();
    }

    private int getMetrum() {

        if (rButton1.isSelected()) {
            return 1;
        } else if (rButton2.isSelected()) {
            return 2;
        } else if (rButton3.isSelected()) {
            return 3;
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {
        Metronom metronom = new Metronom();
        metronom.setVisible(true);
    }
}
