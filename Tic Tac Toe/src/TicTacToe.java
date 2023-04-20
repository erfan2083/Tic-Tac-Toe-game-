import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] gameBoard = { {' ', ' ', ' '},
                               {' ', ' ', ' '},
                               {' ', ' ', ' '} };

        while (true){
        printBoard(gameBoard);

        userTurn(gameBoard);
        if(isGameFinish(gameBoard))
            break;

        computerTurn(gameBoard);
        if(isGameFinish(gameBoard))
            break;
        }

    }

    static boolean isGameFinish(char[][] gameBoard) {
        if (hasContestantWon(gameBoard, 'X')) {
            printBoard(gameBoard);
            System.out.println("Player wins!");
            return true;
        }

        if (hasContestantWon(gameBoard, 'O')) {
            printBoard(gameBoard);
            System.out.println("Computer wins!");
            return true;
        }

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(gameBoard);
        System.out.println("The game ended in a tie!");
        return true;
    }

    static boolean hasContestantWon(char[][] gameBoard, char symbol) {
        if ((gameBoard[0][0] == symbol && gameBoard [0][1] == symbol && gameBoard [0][2] == symbol) ||
            (gameBoard[1][0] == symbol && gameBoard [1][1] == symbol && gameBoard [1][2] == symbol) ||
            (gameBoard[2][0] == symbol && gameBoard [2][1] == symbol && gameBoard [2][2] == symbol) ||

            (gameBoard[0][0] == symbol && gameBoard [1][0] == symbol && gameBoard [2][0] == symbol) ||
            (gameBoard[0][1] == symbol && gameBoard [1][1] == symbol && gameBoard [2][1] == symbol) ||
            (gameBoard[0][2] == symbol && gameBoard [1][2] == symbol && gameBoard [2][2] == symbol) ||

            (gameBoard[0][0] == symbol && gameBoard [1][1] == symbol && gameBoard [2][2] == symbol) ||
            (gameBoard[0][2] == symbol && gameBoard [1][1] == symbol && gameBoard [2][0] == symbol) ) {
            return true;
        }
        return false;
    }

    static void computerTurn(char[][] gameBoard) {
        Random rand = new Random();
        int computerChoice;

        while (true) {
            computerChoice = rand.nextInt(9) + 1;
            if (isValidMove(computerChoice, gameBoard))
                break;
        }
        System.out.println("Compute choose " + computerChoice);
        placeMove(computerChoice, gameBoard, 'O');
    }

    static void placeMove(int choice, char[][] gameBoard, char symbol) {
        switch (choice) {
            case 1:
                gameBoard[0][0] = symbol;
                break;

            case 2:
                gameBoard[0][1] = symbol;
                break;

            case 3:
                gameBoard[0][2] = symbol;
                break;

            case 4:
                gameBoard[1][0] = symbol;
                break;

            case 5:
                gameBoard[1][1] = symbol;
                break;

            case 6:
                gameBoard[1][2] = symbol;
                break;

            case 7:
                gameBoard[2][0] = symbol;
                break;

            case 8:
                gameBoard[2][1] = symbol;
                break;

            case 9:
                gameBoard[2][2] = symbol;
                break;
        }
    }

    static boolean isValidMove(int choice, char[][] gameBoard) {
        switch (choice) {
            case 1:
               return (gameBoard[0][0] == ' ');

            case 2:
                return (gameBoard[0][1] == ' ');

            case 3:
                return (gameBoard[0][2] == ' ');

            case 4:
                return (gameBoard[1][0] == ' ');

            case 5:
                return (gameBoard[1][1] == ' ');

            case 6:
                return (gameBoard[1][2] == ' ');

            case 7:
                return (gameBoard[2][0] == ' ');

            case 8:
                return (gameBoard[2][1] == ' ');

            case 9:
                return (gameBoard[2][2] == ' ');

            default:
                return false;
        }
    }

    static void userTurn(char[][] gameBoard) {
        Scanner scan = new Scanner(System.in);
        int userChoice;

        System.out.println("Pick your choice between 1 to 9");
        while (true) {
            userChoice = scan.nextInt();
            if (isValidMove(userChoice, gameBoard))
                break;
            else
                System.out.println("That place is already taken!\nTry another one");
        }

        placeMove(userChoice, gameBoard, 'X');
    }

    static void printBoard(char[][] gameBoard) {
        System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]
                           + "\n-+"                + "-"             + "+-\n"+
                           gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]
                           + "\n-+"                + "-"             + "+-\n"+
                           gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
    }
}