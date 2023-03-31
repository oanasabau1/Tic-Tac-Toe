public class Model {
    private int[][] board;
    private boolean playerTurn;

    Model() {
        board = new int[3][3];
        playerTurn = true; //we set the X player to be true, and the O player to be false
    }

    public void makeMove(int row, int col) {
        if (playerTurn) {
            board[row][col] = 1;  // 1 is corresponding to the player X
        } else {
            board[row][col] = -1;  // -1 is corresponding to the player X
        }
        playerTurn = !playerTurn;
    }

    public boolean checkBoard() {
        int principalDiag = 0;
        int secondaryDiag = 0;
        int col, row;
        for (int i = 0; i < 3; i++) {
            principalDiag += board[i][i];
            secondaryDiag += board[i][2 - i];
        }
        if (Math.abs(principalDiag) == 3 || Math.abs(secondaryDiag) == 3) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            col = 0;
            row = 0;
            for (int j = 0; j < 3; j++) {
                col += board[j][i];
                row += board[i][j];
            }
            if (Math.abs(col) == 3 || Math.abs(row) == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        board = new int[3][3];
        playerTurn = true;
    }

    public int[][] getBoard() {
        return board;
    }

    public String getCurrentPlayer() {
        return playerTurn ? "X" : "O";
    }

    public String getOpponentPlayer() {  //for the winner
        return playerTurn ? "O" : "X";
    }
}
