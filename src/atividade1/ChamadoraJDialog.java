package atividade1;

import javax.swing.*;
import java.awt.event.*;

public class ChamadoraJDialog extends JDialog {

    private JLabel labelPergunta;
    private JRadioButton[] opcoes;
    private ButtonGroup grupoOpcoes;
    private JButton btnAvaliar, btnProxima;
    private int questaoAtual = 0;
    private int acertos = 0;
    private boolean respostaAvaliada = false;

    private JanelaPrincipalQuiz janelaPrincipal;

    public ChamadoraJDialog(JanelaPrincipalQuiz parent) {
        super(parent, "Quiz", true);
        this.janelaPrincipal = parent;

        setSize(500, 400);
        setLayout(null); 
        setLocationRelativeTo(parent);

        initComponents();
        carregarQuestao();
    }

    private void initComponents() {
        labelPergunta = new JLabel();
        labelPergunta.setBounds(30, 20, 440, 30);
        add(labelPergunta);

        grupoOpcoes = new ButtonGroup();
        opcoes = new JRadioButton[5];

        for (int i = 0; i < 5; i++) {
            opcoes[i] = new JRadioButton();
            opcoes[i].setBounds(30, 60 + i * 40, 400, 30);
            grupoOpcoes.add(opcoes[i]);
            add(opcoes[i]);
        }

        btnAvaliar = new JButton("Avaliar Resposta");
        btnAvaliar.setBounds(80, 280, 150, 30);
        add(btnAvaliar);

        btnProxima = new JButton("Próxima Questão");
        btnProxima.setBounds(250, 280, 150, 30);
        add(btnProxima);

        btnAvaliar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                avaliarResposta();
            }
        });

        btnProxima.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                proximaQuestao();
            }
        });
    }

    private void carregarQuestao() {
        if (questaoAtual >= 4) { 
            mostrarResultadoFinal();
            dispose();
            return;
        }

        labelPergunta.setText(janelaPrincipal.getPergunta(questaoAtual));
        String[] alternativas = janelaPrincipal.getAlternativas(questaoAtual);

        grupoOpcoes.clearSelection();
        for (int i = 0; i < 5; i++) {
            opcoes[i].setText(alternativas[i]);
            opcoes[i].setEnabled(true);
        }

        respostaAvaliada = false;
    }

    private void avaliarResposta() {
        if (respostaAvaliada) {
            return; 
        }

        int respostaSelecionada = -1;
        for (int i = 0; i < 5; i++) {
            if (opcoes[i].isSelected()) {
                respostaSelecionada = i;
                break;
            }
        }

        if (respostaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma resposta primeiro!");
            return;
        }

        int respostaCorreta = janelaPrincipal.getRespostaCorreta(questaoAtual);

        Icon icone;
        if (respostaSelecionada == respostaCorreta) {
            acertos++;
            icone = new ImageIcon(getClass().getResource("/atividade1/imgs/ok1.png")); 
            JOptionPane.showMessageDialog(this, "Resposta correta!", "Resultado", JOptionPane.INFORMATION_MESSAGE, icone);
        } else {
            icone = new ImageIcon(getClass().getResource("/atividade1/imgs/clean.png")); 
            JOptionPane.showMessageDialog(this, "Resposta errada!", "Resultado", JOptionPane.ERROR_MESSAGE, icone);
        }

        for (JRadioButton botao : opcoes) {
            botao.setEnabled(false);
        }
        respostaAvaliada = true;
    }

    private void proximaQuestao() {
        if (!respostaAvaliada) {
            JOptionPane.showMessageDialog(this, "Avalie a resposta antes de passar para a próxima pergunta!");
            return;
        }
        questaoAtual++;
        carregarQuestao();
    }

    private void mostrarResultadoFinal() {
        Icon icone = new ImageIcon(getClass().getResource("/atividade1/imgs/informacao.png"));
        JOptionPane.showMessageDialog(this, "Você acertou " + acertos + " de 4 questões!", "Resultado Final", JOptionPane.INFORMATION_MESSAGE, icone);
    }
}
