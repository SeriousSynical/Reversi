import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        run();

    }

    public static void run() {

        // Initialize Flags
        boolean flag;
        int counter;
        int winner;
        String score = null;
        String replay = null;


        // Initialize Variables
        int currentPlayer = 1;
        String move = null;


        // Initialize Objects
        Scanner keyboard = new Scanner(System.in);
        Board board;

        do {

            // Initialize Objects
            board = new Board();

            // Prompt Counter
            flag = true;
            do {

                try {

                    System.out.print("Would you like a running score?: ");
                    score = keyboard.nextLine();
                    if (!(score.toLowerCase().charAt(0) == 'y' || score.toLowerCase().charAt(0) == 'n')) {

                        System.out.println("Invalid Input.");

                    } else {

                        flag = false;

                    }

                } catch (Exception e) {

                    System.out.println("Invalid Input.");

                }

            } while (flag);

            // Round
            do {

                if ((currentPlayer == 1 && board.blackMoves() !=0) || (currentPlayer == 2 && board.whiteMoves() != 0)) {

                    // Display Score
                    if (score.toLowerCase().charAt(0) == 'y') {

                        System.out.println("Player 1: " + board.blackCount());
                        System.out.println("Player 2: " + board.whiteCount());

                    }

                    // Display Board
                    counter = 1;
                    System.out.println("   A  B  C  D  E  F  G  H");
                    for (ArrayList<Character> row : board.getBoard()) {

                        System.out.print(counter++);

                        for (char disk : row) {

                            System.out.print("  ");
                            System.out.print(disk);

                        }

                        System.out.println();

                    }


                    // Prompt Move
                    System.out.println();
                    flag = true;
                    do {

                        try {

                            System.out.print("Player " + currentPlayer + " Move: ");
                            move = keyboard.nextLine();
                            if (!((move.toUpperCase().charAt(0) >= 65 && move.toUpperCase().charAt(0) <= 72) && (move.charAt(1) - '0' >= 1 && move.charAt(1) - '0' <= 8) && move.length() == 2)) {

                                System.out.println("Invalid Input");

                            } else if (!(board.isValid(currentPlayer, move.charAt(0) - 65, move.charAt(1) - '1'))) {

                                System.out.println("Move Invalid.");

                            } else {

                                flag = false;

                            }

                        } catch (Exception e) {

                            System.out.println("Invalid Input.");

                        }

                    } while (flag);
                    System.out.println();


                    // Make Move
                    board.makeMove(currentPlayer, move.charAt(0) - 65, move.charAt(1) - '1');

                } else {

                    System.out.println("No valid moves for Player " + currentPlayer + ".");

                }


                // Swap Player
                if (currentPlayer == 1) {

                    currentPlayer = 2;

                } else {

                    currentPlayer = 1;

                }

            } while (!board.gameComplete());


            // Display Board
            counter = 1;
            System.out.println("   A  B  C  D  E  F  G  H");
            for (ArrayList<Character> row : board.getBoard()) {

                System.out.print(counter++);

                for (char disk : row) {

                    System.out.print("  ");
                    System.out.print(disk);

                }

                System.out.println();

            }


            // Display Winner
            if (board.blackCount() > board.whiteCount()) {

                winner = 1;

            } else {

                winner = 2;

            }

            System.out.println("Winner: Player " + winner);


            // Prompt Replay
            flag = true;
            do {

                try {

                    System.out.print("Play Again?: ");
                    replay = keyboard.nextLine();
                    if (!(replay.toLowerCase().charAt(0) == 'y' || replay.toLowerCase().charAt(0) == 'n')) {

                        System.out.println("Invalid Input.");

                    } else {

                        flag = false;

                    }

                } catch (Exception e) {

                    System.out.println("Invalid Input.");

                }

            } while (flag);

        } while (replay.toLowerCase().charAt(0) == 'y');

    }

}