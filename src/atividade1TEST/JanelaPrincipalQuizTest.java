package atividade1TEST;

import org.junit.jupiter.api.Test;

import atividade1.ChamadoraJDialog;
import atividade1.JanelaPrincipalQuiz;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;

public class JanelaPrincipalQuizTest {

    @Test
    public void testJanelaEhCriada() {
        JanelaPrincipalQuiz janela = new JanelaPrincipalQuiz();
        assertNotNull(janela);
        assertTrue(janela instanceof JFrame);
    }

    @Test
    public void testMenuBarExiste() {
        JanelaPrincipalQuiz janela = new JanelaPrincipalQuiz();
        JMenuBar menuBar = janela.getJMenuBar();
        assertNotNull(menuBar);
    }

    @Test
    public void testMenuArquivoExiste() {
        JanelaPrincipalQuiz janela = new JanelaPrincipalQuiz();
        JMenuBar menuBar = janela.getJMenuBar();
        JMenu menuArquivo = menuBar.getMenu(0); // assume que é o primeiro
        assertNotNull(menuArquivo);
        assertEquals("Arquivo", menuArquivo.getText());
    }

    @Test
    public void testAbrirDialogo() {
        JanelaPrincipalQuiz janela = new JanelaPrincipalQuiz();
        assertDoesNotThrow(() -> {
            ChamadoraJDialog dialog = new ChamadoraJDialog(janela);
            dialog.setVisible(false); // evita abrir a interface
        });
    }
}