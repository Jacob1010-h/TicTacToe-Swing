package tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JPanel tictactoePanel;
    private JButton topMid;
    private JButton midMid;
    private JButton bottomMid;
    private JButton rightMid;
    private JButton leftMid;
    private JButton rightTop;
    private JButton rightBottom;
    private JButton leftTop;
    private JButton leftBottom;
    private JLabel ticTacToeLabel;

    public View() {
        setContentPane(tictactoePanel);
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        String turn = "X";

        topMid.addActionListener(e -> {
            XorOCheck(topMid);
        });
        midMid.addActionListener(e -> {
            XorOCheck(midMid);
        });
        bottomMid.addActionListener(e -> {
            XorOCheck(bottomMid);
        });
        rightMid.addActionListener(e -> {
            XorOCheck(rightMid);
        });
        leftMid.addActionListener(e -> {
            XorOCheck(leftMid);
        });
        rightTop.addActionListener(e -> {
            XorOCheck(rightTop);
        });
        rightBottom.addActionListener(e -> {
            XorOCheck(rightBottom);
        });
        leftTop.addActionListener(e -> {
            XorOCheck(leftTop);
        });
        leftBottom.addActionListener(e -> {
            XorOCheck(leftBottom);
        });

    }

    public void XorOCheck(JButton button) {
        switch (turn) {
            case "X" -> {
                button.setText("X");
                turn = "O";
            }
            case "O" -> {
                button.setText("O");
                turn = "X";
            }
        }
    }
}
