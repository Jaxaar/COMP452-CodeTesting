import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * UI screen for when the computer is guessing a number
 *
 * Displays the computer's guesses and processes human's answers
 * Tracks the computer's guesses
 *
 * TODO: refactor this class
 */
public class ComputerGuessesPanel extends JPanel {

    private final ComputerGuessingGame guessingGame;

    public ComputerGuessesPanel(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback) {
        guessingGame = new ComputerGuessingGame();

        initComponents(cardsPanel, gameFinishedCallback);
    }

    private void initComponents(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel guessMessageLabel = createLabel("I guess ___.");
        add(guessMessageLabel);

        add(Box.createRigidArea(new Dimension(0, 40)));

        JLabel promptLabel = createLabel("Your number is...");
        add(promptLabel);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton lowerBtn = createButton("Lower", () -> handleLowerGuess(guessMessageLabel));
        add(lowerBtn);

        JButton correctBtn = createButton("Equal", () -> handleCorrectGuess(cardsPanel, gameFinishedCallback));
        add(correctBtn);

        JButton higherBtn = createButton("Higher", () -> handleHigherGuess(guessMessageLabel));
        add(higherBtn);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                resetGame();
                updateGuessMessage(guessMessageLabel);
            }
        });
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JButton createButton(String text, Runnable action) {
        JButton button = new JButton(text);
        button.addActionListener(e -> action.run());
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    private void handleLowerGuess(JLabel guessMessageLabel) {
        guessingGame.makeLowerGuess();
        updateGuessMessage(guessMessageLabel);
    }

    private void handleCorrectGuess(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback) {
        GameResult result = guessingGame.finishGame();
        gameFinishedCallback.accept(result);
        showGameOverScreen(cardsPanel);
    }

    private void handleHigherGuess(JLabel guessMessageLabel) {
        guessingGame.makeHigherGuess();
        updateGuessMessage(guessMessageLabel);
    }

    private void updateGuessMessage(JLabel guessMessageLabel) {
        guessMessageLabel.setText("I guess " + guessingGame.getLastGuess() + ".");
    }

    private void showGameOverScreen(JPanel cardsPanel) {
        CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
        cardLayout.show(cardsPanel, ScreenID.GAME_OVER.name());
    }

    private void resetGame() {
        guessingGame.resetGame();
    }
}
