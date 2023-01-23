public class Model {

	int[][] board = new int[3][3];
	public int counter = 0;

	public void setChoice(int field, Value value) {
		int valoare = 0;
		if (value == Value.X) {  //avem -1 pentru X
			valoare = -1;
		} else if (value == Value.O) { //1 pentru 0
			valoare = 1;
		}
		board[field % 3][field / 3] = valoare;
		counter++;
	}

	public boolean checkBoard() {
		int diagonalaPrincipala = 0;
		int diagonalaSecundara = 0;
		int coloana = 0;
		int linie = 0;

		for (int i = 0; i < 3; i++) {
			diagonalaPrincipala += board[i][i];
			diagonalaSecundara += board[i][2 - i];
		}
		//daca pe o linie, coloana sau una dintre diagonale suma este |3|, atunci jocul s-a incheiat cu succes
		if (Math.abs(diagonalaPrincipala) == 3 || Math.abs(diagonalaSecundara) == 3) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
	        coloana = 0;
	        linie = 0;
	        for (int j = 0; j < 3; j++) {
	            coloana += board[j][i];
	            linie += board[i][j];

	        }
	        if (Math.abs(coloana) == 3 || Math.abs(linie) == 3) {
	            return true;
	        }
	    }
		return false;
	}
	
}