package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;

    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    /**
     * Constructor of a SimpleGUI, sets all the graphical interface.
     */
    public SimpleGUI() {
        final JPanel pano = new JPanel();
        pano.setLayout(new BorderLayout());
        final JTextArea testo = new JTextArea();
        final JButton save = new JButton("Save");
        pano.add(testo, BorderLayout.CENTER);
        pano.add(save, BorderLayout.SOUTH);
        frame.setContentPane(pano);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.writeString(testo.getText());
            }

        });

    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) screen.getWidth() / PROPORTION, (int) screen.getHeight() / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * @param args ignored.
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }

}
