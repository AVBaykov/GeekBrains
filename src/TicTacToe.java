import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    /*
    блок настроек игры
    */

    private static char[][] map;             //матрица игры
    private static final int SIZE = 3;             //размерность игры

    private static final char DOT_EMPTY = '♦';    // пустой символ - свободное поле
    private static final char DOT_X = 'X';        // крестик
    private static final char DOT_O = 'O';        // нолик

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static final boolean SILLY_MODE = false;

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();     // ход человека
            if (isEndGame(DOT_X)) {
                break;
            }

            computerTurn();  // ход компьютера
            if (isEndGame(DOT_O)) {
                break;
            }
        }

        System.out.println("Игра закончена");
    }


    /**
     * Метод подготовки игрового поля
     */
    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    /**
     * Метод подготовки игрового поля
     */
    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * Ход человека
     */
    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты ячейки через пробел");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[x][y] = DOT_X;
    }

    /**
     * Ход компьютера
     */
    private static void computerTurn() {
        int x = -1;
        int y = -1;

        if (SILLY_MODE) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        } else {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {

                }
            }
        }

        System.out.printf("Компьютер выбрал ячейку %d %d\n", x, y);
        map[x][y] = DOT_O;

    }

    /**
     * Метод валидации запрашиваемой ячейки на корректность
     *
     * @param x - координата по горизонтали
     * @param y - координата по вертикали
     * @return boolean - признак валидности
     */
    private static boolean isCellValid(int x, int y) {
        //проверка координаты
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }

        //проверка заполненности ячейки
        return map[x][y] == DOT_EMPTY;
    }

    /**
     * Метод проверки игры на завершение
     *
     * @param playerSymbol - символ, которым играет текущий игрок
     * @return boolean - признак завершение игры
     */
    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();

        //проверяем необходимость следующего хода
        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        if (isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    /**
     * Проверка на 100%-ю заполненность поля
     *
     * @return boolean - признак оптимальности
     */
    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    result = false;
                }
            }
        }
        return result;
    }

    private static boolean checkWin(char playerSymbol) {
        boolean result = false;

        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)) {
            result = true;
        }

        return result;
    }

}
