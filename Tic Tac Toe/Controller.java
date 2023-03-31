import java.awt.event.*;
import javax.swing.*;

public class Controller implements ActionListener {
    Model model;
    View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Register listeners
        for (int i = 0; i < 9; i++) {
            view.button[i].addActionListener(this);
        }
        view.newGame.addActionListener(this);
        view.exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.newGame) {
            model.resetBoard();
            view.newGame.setText("New game");
            for (int i = 0; i < 9; i++) {
                view.button[i].setEnabled(true);
            }
            updateView();
        } else if (e.getSource() == view.exit) {
            System.exit(0);
        } else {
            JButton button = (JButton) e.getSource();
            int index = -1;
            for (int i = 0; i < 9; i++) {
                if (button == view.button[i]) {
                    index = i;
                    view.button[i].setEnabled(false); //the move can be made just once
                    break;
                }
            }
            if (index != -1) {  //if a button was clicked
                // Convert button index to row and column indices
                int row = index / 3;
                int col = index % 3;
                model.makeMove(row, col);
                updateView();
            }
        }
    }

    public void updateView() {  //this method updates the view by marking the board with X or O and determines the game's continuation by showing the player's turn or the winner
        int[][] board = model.getBoard();
        for (int i = 0; i < 9; i++) {
            int row = i / 3;
            int col = i % 3;
            if (board[row][col] == 1) {
                view.button[i].setText("X");
            } else if (board[row][col] == -1) {
                view.button[i].setText("O");
            } else {
                view.button[i].setText("");
            }
        }
        if (model.checkBoard()) {
            String winner = model.getOpponentPlayer();
            view.text.setText(winner + " wins!");
            view.newGame.setText("Restart");
            disableButtons();
        } else if (model.isBoardFull()) {
            view.text.setText("It's a tie!");
            view.newGame.setText("Restart");
            disableButtons();
        } else {
            view.text.setText(model.getCurrentPlayer() + " turns");
        }
    }

    public void disableButtons() {  //method to disable all the buttons after one player wins or it's a tie
        for (int i = 0; i < 9; i++) {
            view.button[i].setEnabled(false);
        }
    }
}
