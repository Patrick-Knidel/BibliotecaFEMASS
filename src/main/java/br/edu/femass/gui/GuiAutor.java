package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAutor {
    private JPanel jPanel;
    private JList lstAutores;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtNacionalidade;
    private JButton btnSalvar;

    public GuiAutor() {
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Autor autor = new Autor(txtNome.getText(), txtSobrenome.getText(), txtNacionalidade.getText());
                    new DaoAutor().save(autor);
                    preencherListaAutores();
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        lstAutores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Autor autor = (Autor) lstAutores.getSelectedValue();

                 if(!(autor==null)) {
                    txtNome.setText(autor.getNome());
                    txtSobrenome.setText(autor.getSobreNome());
                    txtNacionalidade.setText(autor.getNacionalidade());
                }
            }
        });
    }

    private void preencherListaAutores(){
        try {
            lstAutores.setListData(new DaoAutor().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiAutor gui = new GuiAutor();
        gui.preencherListaAutores();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cadastro de Autor");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal(){
        JDialog frame = new JDialog(new Frame(), true);
        GuiAutor gui = new GuiAutor();
        gui.preencherListaAutores();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Autor");
        frame.pack();
        frame.setVisible(true);
    }
}
