package atividade1;

import javax.swing.*;
import java.awt.event.*;

/**
 * JDialog responsável por exibir as perguntas do quiz ao usuário.
 * Apresenta perguntas com múltipla escolha e avalia respostas.
 */
public class ChamadoraJDialog extends JDialog {

	private JLabel labelPergunta;
	private JRadioButton[] opcoes;
	private ButtonGroup grupoOpcoes;
	private JButton btnAvaliar, btnProxima;
	private int questaoAtual = 0;
	private int acertos = 0;
	private boolean respostaAvaliada = false;

	private JanelaPrincipalQuiz janelaPrincipal;

	//Construtor da janela de diálogo do quiz.
	public ChamadoraJDialog(JanelaPrincipalQuiz parent) {
		super(parent, "Quiz", true);
		this.janelaPrincipal = parent;

		setSize(500, 400);
		setLayout(null); 
		setLocationRelativeTo(parent);

		initComponents();
		carregarQuestao();
	}

	//Inicializa os componentes da interface do diálogo.
	private void initComponents() {
		// Título da pergunta
		labelPergunta = new JLabel();
		labelPergunta.setBounds(30, 20, 440, 30);
		add(labelPergunta);

		grupoOpcoes = new ButtonGroup();
		opcoes = new JRadioButton[5];

		// Criando opções de resposta
		for (int i = 0; i < 5; i++) {
			opcoes[i] = new JRadioButton();
			opcoes[i].setBounds(30, 60 + (i * 30), 400, 25);
			grupoOpcoes.add(opcoes[i]);
			add(opcoes[i]);
		}

		// Botão para avaliar a resposta
		btnAvaliar = new JButton("Avaliar");
		btnAvaliar.setBounds(100, 250, 120, 30);
		btnAvaliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avaliarResposta();
			}
		});
		add(btnAvaliar);

		// Botão para ir à próxima pergunta
		btnProxima = new JButton("Próxima");
		btnProxima.setBounds(260, 250, 120, 30);
		btnProxima.setEnabled(false);
		btnProxima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proximaQuestao();
			}
		});
		add(btnProxima);
	}

	//Carrega a pergunta atual na interface.
	private void carregarQuestao() {
		// Exemplo fictício — apenas para fins de interface
		labelPergunta.setText("Pergunta " + (questaoAtual + 1) + ": Qual é a resposta correta?");
		for (int i = 0; i < opcoes.length; i++) {
			opcoes[i].setText("Alternativa " + (char) ('A' + i));
			opcoes[i].setSelected(false);
		}

		grupoOpcoes.clearSelection();
		btnAvaliar.setEnabled(true);
		btnProxima.setEnabled(false);
		respostaAvaliada = false;
	}


	// Avalia se a resposta selecionada está correta.  
	private void avaliarResposta() {
		if (respostaAvaliada) return;

		// Simula que a alternativa A é sempre correta (índice 0)
		if (opcoes[0].isSelected()) {
			acertos++;
			JOptionPane.showMessageDialog(this, "Resposta correta!");
		} else {
			JOptionPane.showMessageDialog(this, "Resposta incorreta!");
		}

		respostaAvaliada = true;
		btnAvaliar.setEnabled(false);
		btnProxima.setEnabled(true);
	}

	
	//Passa para a próxima pergunta ou finaliza o quiz.
	private void proximaQuestao() {
		questaoAtual++;
		if (questaoAtual < 3) {
			carregarQuestao();
		} else {
			JOptionPane.showMessageDialog(this, "Você acertou " + acertos + " de 3 perguntas.");
			dispose();
		}
	}
}