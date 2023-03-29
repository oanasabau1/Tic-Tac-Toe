import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Controller implements ActionListener {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        addActionListeners();
    }

    public void addActionListeners() {
        for (JButton bton : view.button) {
            bton.addActionListener(this);
        }
        view.newGame.addActionListener(this);
    }

    public boolean addChoice(Integer field, Value value) {
        model.setChoice(field, value);
        if (model.counter >= 5) {
            if (model.checkBoard()) {
                view.winGame();
                view.endGame();
                return true;
            }
            if (model.counter == 9) {
                view.endGame();
                view.match();
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        Value currentPlayer = view.getCurrentPlayerValue();
        if (Arrays.asList(view.button).contains(e.getSource()) && currentPlayer != null) {
            Integer bton = Arrays.asList(view.button).indexOf((JButton) e.getSource());
            ((JButton) e.getSource()).setText(view.getCurrentPlayerString());
            view.pack();
            ((JButton) e.getSource()).setEnabled(false);
            if (!addChoice(bton, currentPlayer)) view.changePlayer();
        } else if (e.getSource().equals(view.newGame)) {
            this.view.dispose();
            this.view = new View(model);
            addActionListeners();
            this.model = new Model();
        }
    }
}