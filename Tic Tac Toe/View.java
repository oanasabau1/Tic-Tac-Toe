import java.awt.*;
import javax.swing.*;

class View extends JFrame {
	public Model m;
	public JFrame frame;
	public JPanel panel;
	public JPanel game;
	public JButton[] button;
	public JButton newGame;
	public JLabel indicator;
	public JLabel turns;
	public JPanel settings;
	public JPanel messages;

	public View(Model m) {
		this.m = m;
		this.frame = new JFrame("Tic Tac Toe");
		this.panel = new JPanel(new FlowLayout());
		this.game = new JPanel(new GridLayout(3, 3));
		this.messages = new JPanel(new FlowLayout());
		this.button = new JButton[9];
		this.settings = new JPanel(new FlowLayout());
		this.indicator = new JLabel("X");
		this.turns = new JLabel("turns");
		this.newGame = new JButton("New Game");
		this.newGame.setEnabled(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 600));
		panel.add(game, BorderLayout.CENTER);
		settings.add(newGame);
		frame.add(settings);
		messages.setBackground(new Color(255, 0, 255));
		frame.add(panel, BorderLayout.NORTH);
		frame.add(messages, BorderLayout.SOUTH);
		messages.add(indicator);
		messages.add(turns);

		for (int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button[i].setPreferredSize(new Dimension(150, 150));
			button[i].setText("");
			button[i].setFont(new Font("Brush Script MT", Font.BOLD, 100));
			game.add(button[i]);
		}
		frame.setVisible(true);
	}

	public void changePlayer() {
		String newPlayer = reverseValue(getCurrentPlayerString());
		this.indicator.setText(newPlayer);
	}

	public void winGame() {
		this.turns.setText("");
		this.indicator.setText(getCurrentPlayerString() + " won!");
		for (JButton bton : this.button) {
			bton.setEnabled(false);
		}
		endGame();
	}

	public String reverseValue(String value) {
		if ("X".equals(value)) {
			return "O";
		} else if ("O".equals(value)) {
			return "X";
		}
		return null;
	}

	public Value reverseValue(Value value) { // schimbarea jucatorilor
		if (value == Value.X) {
			return Value.O;
		} else if (value == Value.O) {
			return Value.X;
		}
		return null;
	}

	public Value getCurrentPlayerValue() {
		if ("X".equals(this.indicator.getText())) {
			return Value.X;
		} else if ("O".equals(this.indicator.getText())) {
			return Value.O;
		}
		return null;
	}

	public String getCurrentPlayerString() {
		if ("X".equals(this.indicator.getText())) {
			return "X";
		} else if ("O".equals(this.indicator.getText())) {
			return "O";
		}
		return null;
	}

	void match() {
		this.turns.setText("It's a tie!");
		this.indicator.setText("");
	}

	void endGame() {
		this.newGame.setEnabled(true);
	}

}