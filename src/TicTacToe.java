import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    static int counter = 0;

    public static void main(String[] args) {

        String temp = "_";
        char bS = temp.charAt(0);

        System.out.println("Welcome. Let's play a Tic Tac Toe.");
        System.out.print("Press enter to continue: ");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        char[][] board = new char[3][3];
        populate(board, bS);

        while (counter < 9) {
            printBoard(board);
            System.out.print("Choose Column: ");
            int column = scan.nextInt();
            System.out.print("Choose Row: ");
            int row = scan.nextInt();
            while (column > 2 || column < 0 || row > 2 || row < 0) {
                System.out.println("Please choose between 0 - 2\n");
                System.out.print("Choose Column: ");
                column = scan.nextInt();
                System.out.print("Choose Row: ");
                row = scan.nextInt();
            }
            if (board[row][column] == 'O' || board[row][column] == 'X') {
                System.out.println("Please choose a different column\n");
                continue;
            } else {
                updateBoard(row, column, board);
                printBoard(board);
                if (checkFinalWin(board)) {
                    break;
                }
            }
            int pcColumn = randomNumber();
            int pcRow = randomNumber();

            while ((board[pcRow][pcColumn] == 'O' || board[pcRow][pcColumn] == 'X') && counter < 9) {
                pcColumn = randomNumber();
                pcRow = randomNumber();
            }
            updateBoardPC(pcRow, pcColumn, board);
            if (checkFinalWin(board)) {
                break;
            }
        }
        System.out.println("Game Over!");
    }

    public static boolean checkFinalWin(char[][] board) {
        boolean check = false;
        if (checkWin(board) == 1 || checkWinDown(board) == 1 || checkDiagonal(board) == 1 || checkDiagonalRev(board) == 1) {
            System.out.println("Player Won!");
            check = true;
        } else if (checkWin(board) == 2 || checkWinDown(board) == 2 || checkDiagonal(board) == 2 || checkDiagonalRev(board) == 2) {
            System.out.println("Computer Won!");
            check = true;
        }
        return check;
    }

    public static int checkWin(char[][] board) {
        int checkWinning = 0;
        for (char[] chars : board) {
            int xCount = 0;
            int oCount = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'X') {
                    xCount++;
                } else if (chars[j] == 'O') {
                    oCount++;
                } else {
                    xCount = 0;
                    oCount = 0;
                }
                if (xCount == 3) {
                    checkWinning = 1;
                } else if (oCount == 3) {
                    checkWinning = 2;
                }
            }
        }
        return checkWinning;
    }
    public static int checkWinDown(char[][] board) {
        int checkWinning = 0;
        for (int i = 0; i < board.length; i++) {
            int xCount = 0;
            int oCount = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == 'X') {
                    xCount++;
                } else if (board[j][i] == 'O') {
                    oCount++;
                } else {
                    xCount = 0;
                    oCount = 0;
                }
                if (xCount == 3) {
                    checkWinning = 1;
                } else if (oCount == 3) {
                    checkWinning = 2;
                }
            }
        }
        return checkWinning;
    }
    public static int checkDiagonal(char[][] board) {
        int checkWinning = 0;
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 'X') {
                xCount++;
            } else if (board[i][i] == 'O') {
                oCount++;
            }
        }
        if (xCount == 3) {
            checkWinning = 1;
        } else if (oCount == 3) {
            checkWinning = 2;
        }
        return checkWinning;
    }
    public static int checkDiagonalRev(char[][] board) {
        int checkWinning = 0;
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][2-i] == 'X') {
                xCount++;
            } else if (board[i][2-i] == 'O') {
                oCount++;
            }
        }
        if (xCount == 3) {
            checkWinning = 1;
        } else if (oCount == 3) {
            checkWinning = 2;
        }
        return checkWinning;
    }
    public static void updateBoard(int row, int column, char[][] board) {
        counter++;
        board[row][column] = 'X';
    }
    public static void updateBoardPC(int pcRow, int pcColumn, char[][] board) {
        counter++;
        if (counter < 9) {
            board[pcRow][pcColumn] = 'O';
            System.out.println("PC Column Choice: " + pcColumn);
            System.out.println("PC Row Choice: " + pcRow);
        }
    }
    public static void populate(char[][] board, char bS){
        for (char[] chars : board) {
            Arrays.fill(chars, bS);
        }
    }
    public static void printBoard(char[][] board) {
        System.out.print("\n");
        String temp = " ";
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("\t" + board[i][j] + temp);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static int randomNumber() {
        return (int) (Math.random()*3);
    }

}
