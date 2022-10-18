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

public class GuiAtendente {
    private JPanel jPanel;
    private JComboBox cboProfessor;
    private JButton btnCadastrarProfessor;
    private JComboBox cboAluno;
    private JButton btnCadastrarAluno;
    private JButton btnEmprestimo;
    private JComboBox cboExemplar;
    private JButton btnDevolver;
    private JComboBox cboEmprestimo;

    public GuiAtendente() {
        btnCadastrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiProfessor().abrirTelaModal();
                preencherComboProfessor();
            }
        });
        btnCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiAluno().abrirTelaModal();
                preencherComboAluno();
            }
        });

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preencherComboExemplar();
                JOptionPane.showMessageDialog(null, "Devolvido com sucesso!");
            }
        });
        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiEmprestimo().abrirTelaModal();
            }
        });
    }

    public void preencherComboProfessor(){
        cboProfessor.removeAllItems();
        try {
            List<Professor> professores = new DaoProfessor().getAll();

            for(Professor professor: professores){
                cboProfessor.addItem(professor);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void preencherComboAluno(){
        cboAluno.removeAllItems();
        try {
            List<Aluno> alunos = new DaoAluno().getAll();

            for(Aluno aluno: alunos){
                cboAluno.addItem(aluno);
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
        GuiAtendente gui = new GuiAtendente();
        gui.preencherComboProfessor();
        gui.preencherComboAluno();
        gui.preencherComboExemplar();
        frame.setContentPane(gui.jPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Interface atendente");
        frame.pack();
        frame.setVisible(true);
    }
}
