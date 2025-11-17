package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 3;

    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser() {
        final JPanel pano = new JPanel();
        final JPanel superiore = new JPanel();
        pano.setLayout(new BorderLayout());
        superiore.setLayout(new BorderLayout());
        final JTextArea testo = new JTextArea();
        final JTextField campo = new JTextField();
        campo.setEditable(false);
        campo.setText(controller.getPath().toString());
        final JButton save = new JButton("Save");
        final JButton browse = new JButton("Browse...");
        pano.add(testo, BorderLayout.CENTER);
        pano.add(save, BorderLayout.SOUTH);
        superiore.add(campo, BorderLayout.CENTER);
        superiore.add(browse, BorderLayout.LINE_END);
        pano.add(superiore, BorderLayout.NORTH);
        frame.setContentPane(pano);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.writeString(testo.getText());
            }
            
        });

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) screen.getWidth() / PROPORTION, (int) screen.getHeight() / PROPORTION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser();
    }

}
