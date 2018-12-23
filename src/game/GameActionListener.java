package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    private GameButton button;

    GameActionListener(GameButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        int row = button.getButtonIndex() / GameBoard.dimension;
        int cell = button.getButtonIndex() % GameBoard.dimension;

        if (board.isTurnable(row, cell)) {
            board.getGame().getCurrentPlayer().updateByPlayersData(button);

            if (board.isFull()) {
                board.getGame().showMessage("Ничья!");
                board.emptyField();
            } else  {
                board.getGame().getCurrentPlayer().updateByAiDate(button);
            }
        } else {
            board.getGame().showMessage("Некорректный ход");
        }

    }
}
