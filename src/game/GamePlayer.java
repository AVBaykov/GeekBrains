package game;

import java.util.Random;

public class GamePlayer {
    private char playerSign;
    private boolean realPlayer;


    public GamePlayer(char playerSign, boolean realPlayer) {
        this.playerSign = playerSign;
        this.realPlayer = realPlayer;
    }

    public boolean isRealPlayer() {
        return realPlayer;
    }

    public char getPlayerSign() {
        return playerSign;
    }

    void updateByPlayersData(GameButton button) {
        int row = button.getButtonIndex() / GameBoard.dimension;
        int cell = button.getButtonIndex() % GameBoard.dimension;

        button.getBoard().updateGameField(row, cell);

        button.setText(Character.toString(button.getBoard().getGame().getCurrentPlayer().getPlayerSign()));

        if (button.getBoard().checkWin()) {
            button.getBoard().getGame().showMessage("Вы выиграли");
            button.getBoard().emptyField();
        } else {
            button.getBoard().getGame().passTurn();
        }
    }

    void updateByAiDate(GameButton button) {
        int maxScoreRow = -1;
        int maxScoreCell = -1;
        int maxScore = 0;
        char[][] map = button.getBoard().getGameField();
        int row = -1;
        int cell = -1;
        int dimension = GameBoard.dimension;
        Random random = new Random();
        char playerSign = button.getBoard().getGame().getCurrentPlayer().playerSign;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int fieldScore = 0;

                if (map[i][j] == GameBoard.nullSymbol) {

                    if (i - 1 >= 0 && j - 1 >= 0 && map[i - 1][j - 1] == playerSign) {
                        fieldScore++;
                    }

                    if (i - 1 >= 0 && map[i - 1][j] == playerSign) {
                        fieldScore++;
                    }

                    if (i - 1 >= 0 && j + 1 < dimension && map[i - 1][j + 1] == playerSign) {
                        fieldScore++;
                    }

                    if (j + 1 < dimension && map[i][j + 1] == playerSign) {
                        fieldScore++;
                    }

                    if (i + 1 < dimension && j + 1 < dimension && map[i + 1][j + 1] == playerSign) {
                        fieldScore++;
                    }

                    if (i + 1 < dimension && map[i + 1][j] == playerSign) {
                        fieldScore++;
                    }

                    if (i + 1 < dimension && j - 1 >= 0 && map[i + 1][j - 1] == playerSign) {
                        fieldScore++;
                    }

                    if (j - 1 >= 0 && map[i][j - 1] == playerSign) {
                        fieldScore++;
                    }
                }
                if (fieldScore > maxScore) {
                    maxScore = fieldScore;
                    maxScoreRow = j;
                    maxScoreCell = i;
                }
            }

            if (maxScoreRow == -1) {
                do {
                    row = random.nextInt(dimension);
                    cell = random.nextInt(dimension);
                } while (!button.getBoard().isTurnable(row, cell));
            }

            if (maxScoreRow != -1) {
                row = maxScoreRow;
                cell = maxScoreCell;
            }

            button.getBoard().updateGameField(row, cell);

            int cellIndex = dimension * row + cell;
            button.getBoard().getButton(cellIndex).setText(Character.toString(playerSign));

            if (button.getBoard().checkWin()) {
                button.getBoard().getGame().showMessage("Компьютер выиграл!");
                button.getBoard().emptyField();
            } else {
                button.getBoard().getGame().passTurn();
            }
        }
    }
}
