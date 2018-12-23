package game;

import javax.swing.*;

public class GameButton extends JButton {
    private int buttonIndex;
    private GameBoard board;

    public GameButton(int buttonIndex, GameBoard currentGameBoard) {
        this.buttonIndex = buttonIndex;
        this.board = currentGameBoard;

        setSize(GameBoard.cellSize - 5, GameBoard.cellSize - 5);
        addActionListener(new GameActionListener(this));
    }

    public GameBoard getBoard() {
        return board;
    }

    public int getButtonIndex() {
        return buttonIndex;
    }
}
