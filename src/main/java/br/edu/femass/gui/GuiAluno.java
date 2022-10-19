package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiAluno {
    private JList lstAlunos;
    private JPanel jPanel;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JTextField txtTelefone;
    private JTextField txtMatricula;
    private JTextField txtDevolucao;
    private JButton btnSalvar;
    private JTextField txtCodigo;

    public GuiAluno() {
        lstAlunos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Aluno aluno = (Aluno) lstAlunos.getSelectedValue();

                if(!(aluno==null)){
                    txtNome.setText(aluno.getNome());
                    txtEndereco.setText(aluno.getEndereco());
                    txtTelefone.setText(aluno.getTelefone());
                    txtMatricula.setText(aluno.getMatricula());
                    txtDevolucao.setText(aluno.getPrazoMaximoDevolucao().toString());
                }
            }
        });
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Aluno aluno = new Aluno(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), txtMatricula.getText());
                    new DaoAluno().save(aluno);
                    preencherListaAlunos();
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void preencherListaAlunos(){
        try {
            lstAlunos.setListData(new DaoAluno().getAll().toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void abrirTelaModal(){
        JDialog frame = new JDialog(new Frame(), true);
        GuiAluno gui = new GuiAluno();
        gui.preencherListaAlunos();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Cadastro de Aluno");
        frame.pack();
        frame.setVisible(true);
    }
}
