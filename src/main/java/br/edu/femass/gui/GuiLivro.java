package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiLivro {
    private JPanel jPanel;
    private JList lstLivro;
    private JTextField txtCodigo;
    private JTextField txtTitulo;
    private JComboBox cboAutor;
    private JFormattedTextField txtAno;
    private JButton btnSalvar;
    private JButton btnAutor;

    public GuiLivro() {
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Livro livro = new Livro(txtTitulo.getText(), (Autor) cboAutor.getSelectedItem(), txtAno.getText());
                    new DaoLivro().save(livro);
                    preencherListaLivro();
                    JOptionPane.showMessageDialog(null,"Livro cadastrado!");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        lstLivro.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Livro livro = (Livro) lstLivro.getSelectedValue();

                if(!(livro==null)){
                    txtTitulo.setText(livro.getTitulo());
                    cboAutor.setSelectedItem(livro.getAutor());
                    txtAno.setText(livro.getAno());
                }
            }
        });
        btnAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAutor().abrirTelaModal();
                preencherComboAutor();
            }
        });
    }

    private void preencherListaLivro(){
        try {
            lstLivro.setListData(new DaoLivro().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void preencherComboAutor(){
        cboAutor.removeAllItems();
        try {
            List<Autor> autores = new DaoAutor().getAll();

            for(Autor autor: autores){
                cboAutor.addItem(autor);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiLivro gui = new GuiLivro();
        gui.preencherListaLivro();
        gui.preencherComboAutor();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cadastro de Livros");
        frame.pack();
        frame.setVisible(true);
    }
    public void abrirTelaModal(){
        JDialog frame = new JDialog(new Frame(), true);
        GuiLivro gui = new GuiLivro();
        gui.preencherListaLivro();
        gui.preencherComboAutor();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Livros");
        frame.pack();
        frame.setVisible(true);
    }

}
