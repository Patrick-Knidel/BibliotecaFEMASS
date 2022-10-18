package br.edu.femass.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiInterface {
    private JButton btnBibliotecario;
    private JButton btnAtendente;
    private JPanel jPanel;

    public GuiInterface() {
        btnBibliotecario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiBibliotecario().abrirTelaModal();
            }
        });
        btnAtendente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAtendente().abrirTelaModal();
            }
        });
    }

    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiInterface gui = new GuiInterface();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu biblioteca");
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Integer screenWidth = (int) (screenSize.getWidth() * 0.2);
        final Integer screenHeight = (int) (screenSize.getHeight() * 0.2);
        frame.setSize(screenWidth,screenHeight);
        frame.setLocation(
                screenSize.width/2- frame.getSize().width/2,
                screenSize.height/2-frame.getSize().height/2
        );
        frame.pack();
        frame.setVisible(true);
    }
}
