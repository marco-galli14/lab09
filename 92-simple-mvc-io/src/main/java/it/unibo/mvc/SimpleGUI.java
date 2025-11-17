package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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

    public SimpleGUI() {
        final JPanel pano = new JPanel();
        frame.setLayout(new BorderLayout());
        final JTextArea testo = new JTextArea();
        final JButton save = new JButton("Save");
        frame.setContentPane(pano);
        pano.add(testo);
        pano.add(save, BorderLayout.SOUTH);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.writeString(testo.getText());
            }
            
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }

}
