package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;

    private final JFrame frame = new JFrame();

    public SimpleGUI() {
        final JPanel pano = new JPanel();
        final JPanel appo = new JPanel();
        pano.setLayout(new BorderLayout());
        appo.setLayout(new BorderLayout());
        final JTextField campo = new JTextField();
        final JTextArea area = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton show = new JButton("Show history");
        pano.add(campo, BorderLayout.NORTH);
        pano.add(area, BorderLayout.CENTER);
        appo.add(print, BorderLayout.NORTH);
        appo.add(show, BorderLayout.SOUTH);
        pano.add(appo, BorderLayout.SOUTH);
        frame.setContentPane(pano);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) screen.getWidth() / PROPORTION, (int) screen.getHeight() / PROPORTION);
        frame.setVisible(true);
    }

    /**
     * @param args ignored.
     */
    public static void main(String[] args) {
        new SimpleGUI().display();
    }

}
