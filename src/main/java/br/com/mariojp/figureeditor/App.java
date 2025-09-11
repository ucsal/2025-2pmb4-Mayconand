package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            JButton button_Blue = new JButton("Azul");
            JButton button_Green = new JButton("Verde");
            JButton button_Red = new JButton("Vermelho");
            JButton button_Yellow = new JButton("Amarelo");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel();

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            button_Green.addActionListener(e -> panel.setColorButon(Color.GREEN));

            button_Red.addActionListener(e -> panel.setColorButon(Color.RED));

            button_Yellow.addActionListener(e -> panel.setColorButon(Color.YELLOW));

            button_Blue.addActionListener(e -> panel.setColorButon(Color.BLUE));


            JPanel painelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
            painelButtons.add(button_Blue);
            painelButtons.add(button_Green);
            painelButtons.add(button_Red);
            painelButtons.add(button_Yellow);

            frame.add(painelButtons, BorderLayout.SOUTH);
            frame.setVisible(true);

        });


    }
}
