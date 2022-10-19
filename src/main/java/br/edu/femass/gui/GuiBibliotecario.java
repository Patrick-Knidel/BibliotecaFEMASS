package br.edu.femass.gui;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiBibliotecario {
    private JPanel jPanel;
    private JComboBox cboLivro;
    private JButton btnCadastrarLivro;
    private JComboBox cboExemplar;
    private JButton btnCadastrarExemplar;
    private JButton btnLeitorAtrasado;

    public GuiBibliotecario() {
        btnCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLivro().abrirTelaModal();
                preencherComboLivro();
            }
        });

        btnCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiExemplar().abrirTelaModal();
                preencherComboExemplar();
            }
        });
        btnLeitorAtrasado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Estamos trabalhando para implementar esta funcionalidade!...");
            }
        });
    }

    public void preencherComboLivro(){
        cboLivro.removeAllItems();
        try {
            List<Livro> livros = new DaoLivro().getAll();

            for(Livro livro: livros){
                cboLivro.addItem(livro);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void preencherComboExemplar(){
        cboExemplar.removeAllItems();
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();

            for(Exemplar exemplar: exemplares){
                cboExemplar.addItem(exemplar);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTelaModal(){
        JDialog frame = new JDialog(new Frame(), true);
        GuiBibliotecario gui = new GuiBibliotecario();
        gui.preencherComboLivro();
        gui.preencherComboExemplar();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Interface bibliotecário");
        frame.pack();
        frame.setVisible(true);
    }
}
