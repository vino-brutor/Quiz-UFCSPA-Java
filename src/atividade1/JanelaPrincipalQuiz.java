package atividade1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

//janela principal do quiz, representa a janela inicial da aplicaçao
public class JanelaPrincipalQuiz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JanelaPrincipalQuiz frame;

	/**
	 * Inicia a aplicaçao.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JanelaPrincipalQuiz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * construtor da janela principal
	 */
	public JanelaPrincipalQuiz() {
		setTitle("Janela Principal - Questionário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//criacao da barra de menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//menu arquivo
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		//menu que chama o JDialog
		JMenuItem menuItemAbrirArquivo = new JMenuItem("Abrir Diálogo");
		menuItemAbrirArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//instancia a tela de dialogo para chamma as perguntas do quiz 
				ChamadoraJDialog jdialog = new ChamadoraJDialog(frame);
				jdialog.setVisible(true);
				
			}
		});
		mnArquivo.add(menuItemAbrirArquivo);
		
		//painel principal
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

	public String getPergunta(int perguntaNum) {
		switch(perguntaNum) {
		case 0:
			return "Qual a carga horaria do curso de Informatica Biomedica? ";
		case 1: 
			return "Qual o docente da cadeira de Programacao Orientada a objetos? ";
		case 2:
			return "Qual a sigla do centro academico de Informatica biomedica?";
		case 3:
			return "Quantos anos o curso de Informatica Biomedcia completa em 2025?";
		default:
			return "Pergunta invalida";
		}
	}

	public String[] getAlternativas(int alternativasNum) {
		//switch para percorrer por todas as altertativas de cada pergunta e exibir no dialogo
		switch(alternativasNum) {
		case 0:
			return new String[] {"3670 horas", "3000 horas", "4670 horas",  "3350 horas", "3500"};
		case 1:
			return new String[] {"Joao Carlos Gluz", "Luciano Costa Blomberg", "Isabel Cristina Siqueira da Silva", "José Antônio Linch Burmann", "Juliana Silva Herbert"};
		case 2: 
			return new String[] {"CAIB", "CAINFO", "CINFOBIO", "CADINBIO", "CAMD"};
		case 3:
			return new String[] {"20", "5", "10", "4", "8"};
		default:
			return new String[] {"Questao invalida"};
		}
	}

	public int getRespostaCorreta(int questaoParaPegarACorreta) {
		//percorre entre o index de todas as perguntas e eretirna o index da resposta correta
		switch(questaoParaPegarACorreta){
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 4;
			case 3:
				return 2;
			default:
				return -1;
		}
	}
}
