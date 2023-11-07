/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dashboard;

import javax.swing.*;
import java.awt.*;

public class TextFieldWithIcon extends JPanel {

    public TextFieldWithIcon() {
        setLayout(new BorderLayout());

        JTextField textField = new JTextField(20);
        ImageIcon icon = new ImageIcon("C:\\Users\\AngelS\\Downloads\\tarjeta.png"); // Ruta de tu imagen
        JLabel iconLabel = new JLabel(icon);
        add(textField, BorderLayout.CENTER);
        add(iconLabel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JTextField con icono");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new TextFieldWithIcon();
            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
