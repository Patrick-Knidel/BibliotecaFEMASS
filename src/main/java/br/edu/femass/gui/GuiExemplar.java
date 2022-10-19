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

public class GuiExemplar {
    private JPanel jPanel;
    private JTextField txtCodigo;
    private JComboBox cboLivro;
    private JButton btnSalvar;

    public GuiExemplar() {
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Exemplar exemplar = new Exemplar( (Livro) cboLivro.getSelectedItem());
                    new DaoExemplar().save(exemplar);
                    preencherComboLivro();
                    JOptionPane.showMessageDialog(null, "Exemplar cadastrado!");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
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

    public void abrirTelaModal(){
        JDialog frame = new JDialog(new Frame(), true);
        GuiExemplar gui = new GuiExemplar();
        gui.preencherComboLivro();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Exemplar");
        frame.pack();
        frame.setVisible(true);
    }

}
