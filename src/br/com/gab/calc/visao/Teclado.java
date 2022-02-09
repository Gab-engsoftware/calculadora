package br.com.gab.calc.visao;

import br.com.gab.calc.modelo.Memoria;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teclado extends JPanel implements ActionListener{
    private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
    private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
    private final Color COR_LARANJA = new Color(242, 163, 60);

    public Teclado() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(layout);

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        // Linha 01
        c.gridwidth = 2;
        adcionarBotao("AC", COR_CINZA_ESCURO, c, 0, 0);
        c.gridwidth = 1;
        adcionarBotao("±", COR_CINZA_ESCURO, c, 2, 0);
        adcionarBotao("/", COR_LARANJA, c, 3, 0);

        // Linha 02
        adcionarBotao("7", COR_CINZA_CLARO, c, 0, 1);
        adcionarBotao("8", COR_CINZA_CLARO, c, 1, 1);
        adcionarBotao("9", COR_CINZA_CLARO, c, 2, 1);
        adcionarBotao("*", COR_LARANJA, c, 3, 1);

        // Linha 03
        adcionarBotao("4", COR_CINZA_CLARO, c, 0, 2);
        adcionarBotao("5", COR_CINZA_CLARO, c, 1, 2);
        adcionarBotao("6", COR_CINZA_CLARO, c, 2, 2);
        adcionarBotao("-", COR_LARANJA, c, 3, 2);

        // Linha 04
        adcionarBotao("1", COR_CINZA_CLARO, c, 0, 3);
        adcionarBotao("2", COR_CINZA_CLARO, c, 1, 3);
        adcionarBotao("3", COR_CINZA_CLARO, c, 2, 3);
        adcionarBotao("+", COR_LARANJA, c, 3, 3);

        // Linha 05
        c.gridwidth = 2;
        adcionarBotao("0", COR_CINZA_CLARO, c, 0, 4);
        c.gridwidth = 1;
        adcionarBotao(",", COR_CINZA_CLARO, c, 2, 4);
        adcionarBotao("=", COR_LARANJA, c, 3, 4);


    }

    private void adcionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        Botao botao = new Botao(texto, cor);
        botao.addActionListener(this);
        add(botao, c);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton botao = (JButton) e.getSource();
            Memoria.getInstance().processarComando(botao.getText());
        }
    }
}
