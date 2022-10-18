package br.edu.femass.gui;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiProfessor {
    private JPanel jPanel;
    private JList lstProfessores;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JTextField txtDisciplina;
    private JButton btnSalvar;
    private JTextField txtDevolucao;

    public GuiProfessor() {
        lstProfessores.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Professor professor = (Professor) lstProfessores.getSelectedValue();

                if(!(professor==null)){
                    txtNome.setText(professor.getNome());
                    txtEndereco.setText(professor.getEndereco());
                    txtTelefone.setText(professor.getTelefone());
                    txtDisciplina.setText(professor.getDisciplina());
                    txtDevolucao.setText(professor.getPrazoMaximoDevolucao().toString());
                }
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Professor professor = new Professor(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtDisciplina.getText());
                    new DaoProfessor().save(professor);
                    preencherListaProfessores();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void preencherListaProfessores(){
        try {
            lstProfessores.setListData(new DaoProfessor().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void abrirTela(){
        JFrame frame = new JFrame();
        GuiProfessor gui = new GuiProfessor();
        gui.preencherListaProfessores();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cadastro de Professor");
        frame.pack();
        frame.setVisible(true);
    }

    public void abrirTelaModal(){
        JDialog frame = new JDialog(new Frame(), true);
        GuiProfessor gui = new GuiProfessor();
        gui.preencherListaProfessores();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Professor");
        frame.pack();
        frame.setVisible(true);
    }

}
