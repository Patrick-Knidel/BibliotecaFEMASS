package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Professor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiEmprestimo {
    private JPanel jPanel;
    private JComboBox cboLeitor;
    private JComboBox cboExemplar;
    private JButton btnSalvar;

    public GuiEmprestimo() {
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preencherComboExemplar();
                preencherComboLeitor();
                JOptionPane.showMessageDialog(null, "Emprestado com sucesso!");
            }
        });
    }

    public void preencherComboLeitor(){
        cboLeitor.removeAllItems();
        try {
            List<Professor> professores = new DaoProfessor().getAll();

            for(Professor professor: professores){
                cboLeitor.addItem(professor);
            }

            List<Aluno> alunos = new DaoAluno().getAll();

            for(Aluno aluno: alunos){
                cboLeitor.addItem(aluno);
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
        GuiEmprestimo gui = new GuiEmprestimo();
        gui.preencherComboLeitor();
        gui.preencherComboExemplar();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Emprestimo");
        frame.pack();
        frame.setVisible(true);
    }
}
