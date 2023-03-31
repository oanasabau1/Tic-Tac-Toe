import java.awt.*;
import javax.swing.*;

public class View {
	Model model;
	JFrame frame;
	JPanel panel, game, settings, messages;
	JButton[] button;
	JButton newGame, exit;
	JLabel text;

	View(Model model) {
		this.model = model;

		frame = new JFrame("Tic Tac Toe");
		frame.setBounds(500, 150, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel(new BorderLayout());
		game = new JPanel(new GridLayout(3, 3));
		button = new JButton[9];
		for (int i = 0; i < 9; i++) {
			button[i] = new JButton();
			button[i].setPreferredSize(new Dimension(150, 150));
			button[i].setText("");
			button[i].setFont(new Font("Brush Script MT", Font.BOLD, 100));
			game.add(button[i]);
		}

		settings = new JPanel(new FlowLayout());
		newGame = new JButton("New Game");
		newGame.setFont(new Font("Verdana", Font.BOLD, 12));
		exit = new JButton("Exit");
		exit.setFont(new Font("Verdana", Font.BOLD, 12));
		settings.add(newGame);
		settings.add(exit);

		messages = new JPanel(new FlowLayout());
		messages.setBackground(new Color(250, 3, 116, 255));
		text = new JLabel("X turns");
		text.setFont(new Font("Verdana", Font.BOLD, 14));
		text.setForeground(Color.WHITE);
		messages.add(text);

		panel.add(game, BorderLayout.CENTER);
		panel.add(settings, BorderLayout.SOUTH);
		panel.add(messages, BorderLayout.NORTH);
		frame.add(panel);

		frame.setVisible(true);
	}
}
