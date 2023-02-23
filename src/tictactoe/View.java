package tictactoe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private String turn = "X";
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

        topMid.addActionListener(e -> {
            XorOCheck(topMid);
            closeIfWinner();
        });
        midMid.addActionListener(e -> {
            XorOCheck(midMid);
            closeIfWinner();
        });
        bottomMid.addActionListener(e -> {
            XorOCheck(bottomMid);
            closeIfWinner();
        });
        rightMid.addActionListener(e -> {
            XorOCheck(rightMid);
            closeIfWinner();
        });
        leftMid.addActionListener(e -> {
            XorOCheck(leftMid);
            closeIfWinner();
        });
        rightTop.addActionListener(e -> {
            XorOCheck(rightTop);
            closeIfWinner();
        });
        rightBottom.addActionListener(e -> {
            XorOCheck(rightBottom);
            closeIfWinner();
        });
        leftTop.addActionListener(e -> {
            XorOCheck(leftTop);
            closeIfWinner();
        });
        leftBottom.addActionListener(e -> {
            XorOCheck(leftBottom);
            closeIfWinner();
        });

    }

    public void closeIfWinner() {
        if (!isWinner() && isFull()) {
            JOptionPane.showMessageDialog(null, "Draw");
            dispose();
        }else if (isWinner()) {
            JOptionPane.showMessageDialog(null, "Winner is " + (turn.equals("X") ? "O" : "X"));
            dispose();
        }
    }

    public boolean isFull() {
        for (JButton button : new JButton[]{topMid, midMid, bottomMid, rightMid, leftMid, rightTop, rightBottom, leftTop, leftBottom}) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void XorOCheck(JButton button) {
        if (!button.getText().isEmpty()) {
            return;
        }
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

    public boolean isWinner(){
        if (    topMid.getText().equals(midMid.getText()) &&
                midMid.getText().equals(bottomMid.getText()) &&
                !topMid.getText().isEmpty())
            return true;

        if (    rightTop.getText().equals(rightMid.getText()) &&
                rightMid.getText().equals(rightBottom.getText()) &&
                !rightTop.getText().isEmpty())
            return true;

        if (    leftTop.getText().equals(leftMid.getText()) &&
                leftMid.getText().equals(leftBottom.getText()) &&
                !leftTop.getText().isEmpty())
            return true;

        if (    leftTop.getText().equals(midMid.getText()) &&
                midMid.getText().equals(rightBottom.getText()) &&
                !leftTop.getText().isEmpty())
            return true;

        if (    rightTop.getText().equals(midMid.getText()) &&
                midMid.getText().equals(leftBottom.getText()) &&
                !rightTop.getText().isEmpty())
            return true;

        if (    leftTop.getText().equals(topMid.getText()) &&
                topMid.getText().equals(rightTop.getText()) &&
                !leftTop.getText().isEmpty())
            return true;

        if (    leftMid.getText().equals(midMid.getText()) &&
                midMid.getText().equals(rightMid.getText()) &&
                !leftMid.getText().isEmpty())
            return true;

        if (    leftBottom.getText().equals(bottomMid.getText()) &&
                bottomMid.getText().equals(rightBottom.getText()) &&
                !leftBottom.getText().isEmpty())
            return true;

        return false;
    }
}
