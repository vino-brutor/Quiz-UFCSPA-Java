package atividade1TEST;

import org.junit.jupiter.api.Test;

import atividade1.ChamadoraJDialog;
import atividade1.JanelaPrincipalQuiz;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;

/**
 * Testes unitários para a classe JanelaPrincipalQuiz.
 * Estes testes garantem que os principais componentes da interface
 * gráfica estão sendo corretamente criados 
 */

public class JanelaPrincipalQuizTest {

	//verifica se a janela eh criada corretamente
    @Test
    public void testJanelaEhCriada() {
        JanelaPrincipalQuiz janela = new JanelaPrincipalQuiz();
        assertNotNull(janela); 
        assertTrue(janela instanceof JFrame); //ve se a janela criada é um JFrame
    }

    //verifica se a barra de menu eh corretamente adicionada
    @Test
    public void testMenuBarExiste() {
        JanelaPrincipalQuiz janela = new JanelaPrincipalQuiz();
        JMenuBar menuBar = janela.getJMenuBar();
        assertNotNull(menuBar);
    }

    //verifica se o primeiro menu da barra de menu de fato é a opcao "arquiv
    @Test
    public void testMenuArquivoExiste() {
        JanelaPrincipalQuiz janela = new JanelaPrincipalQuiz();
        JMenuBar menuBar = janela.getJMenuBar();
        JMenu menuArquivo = menuBar.getMenu(0); // pra pegar o primeiro menu da barra
        assertNotNull(menuArquivo);
        assertEquals("Arquivo", menuArquivo.getText());
    }
    
    //testa se a janela de diálogo abre sem erro
    @Test
    public void testAbrirDialogo() {
        JanelaPrincipalQuiz janela = new JanelaPrincipalQuiz();
        assertDoesNotThrow(() -> {
            ChamadoraJDialog dialog = new ChamadoraJDialog(janela);
            dialog.setVisible(false); // nao precisa exibir graficamente
        });
    }
}