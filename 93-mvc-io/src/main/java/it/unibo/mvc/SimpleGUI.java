package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
    private final Controller controller = new SimpleController();

    /**
     * Creates the graphical iterface from the start.
     */
    public SimpleGUI() {
        final JPanel pano = new JPanel();
        final JPanel appo = new JPanel();
        pano.setLayout(new BorderLayout());
        appo.setLayout(new BorderLayout());
        final JTextField campo = new JTextField("");
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

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent action) {
                try {
                    controller.setString(campo.getText());
                } catch (final IllegalStateException e) {
                    JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    controller.printCurrentString();
                } catch (final IllegalStateException err) {
                    JOptionPane.showMessageDialog(frame, err, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                String ris = "";
                for (final String elem : controller.getHistory()) {
                    ris = ris.concat(elem.concat("\n"));
                }
                area.setText(ris);
            }

        });
    }

    /**
     * Display the frame.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) screen.getWidth() / PROPORTION, (int) screen.getHeight() / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * @param args ignored.
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
