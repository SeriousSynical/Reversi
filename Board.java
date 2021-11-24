import java.util.ArrayList;

public class Board {

    // Initialize Objects
    private final ArrayList<Character> row1;
    private final ArrayList<Character> row2;
    private final ArrayList<Character> row3;
    private final ArrayList<Character> row4;
    private final ArrayList<Character> row5;
    private final ArrayList<Character> row6;
    private final ArrayList<Character> row7;
    private final ArrayList<Character> row8;
    ArrayList<ArrayList<Character>> board;


    // Construct Board
    public Board() {

        row1 = new ArrayList<>();
        row1.add(' ');
        row1.add(' ');
        row1.add(' ');
        row1.add(' ');
        row1.add(' ');
        row1.add(' ');
        row1.add(' ');
        row1.add(' ');

        row2 = new ArrayList<>();
        row2.add(' ');
        row2.add(' ');
        row2.add(' ');
        row2.add(' ');
        row2.add(' ');
        row2.add(' ');
        row2.add(' ');
        row2.add(' ');

        row3 = new ArrayList<>();
        row3.add(' ');
        row3.add(' ');
        row3.add(' ');
        row3.add(' ');
        row3.add(' ');
        row3.add(' ');
        row3.add(' ');
        row3.add(' ');

        row4 = new ArrayList<>();
        row4.add(' ');
        row4.add(' ');
        row4.add(' ');
        row4.add('░');
        row4.add('█');
        row4.add(' ');
        row4.add(' ');
        row4.add(' ');

        row5 = new ArrayList<>();
        row5.add(' ');
        row5.add(' ');
        row5.add(' ');
        row5.add('█');
        row5.add('░');
        row5.add(' ');
        row5.add(' ');
        row5.add(' ');

        row6 = new ArrayList<>();
        row6.add(' ');
        row6.add(' ');
        row6.add(' ');
        row6.add(' ');
        row6.add(' ');
        row6.add(' ');
        row6.add(' ');
        row6.add(' ');

        row7 = new ArrayList<>();
        row7.add(' ');
        row7.add(' ');
        row7.add(' ');
        row7.add(' ');
        row7.add(' ');
        row7.add(' ');
        row7.add(' ');
        row7.add(' ');

        row8 = new ArrayList<>();
        row8.add(' ');
        row8.add(' ');
        row8.add(' ');
        row8.add(' ');
        row8.add(' ');
        row8.add(' ');
        row8.add(' ');
        row8.add(' ');

        board = new ArrayList<>();
        board.add(row1);
        board.add(row2);
        board.add(row3);
        board.add(row4);
        board.add(row5);
        board.add(row6);
        board.add(row7);
        board.add(row8);

    }


    // Get Values
    public ArrayList<ArrayList<Character>> getBoard() {

        return board;

    }


    // Make Move
    public void makeMove(int player, int chosenColumn, int chosenRow) {

        boolean flag;
        char playerDisk;
        char opposingDisk;
        int imax;

        // Finding Player
        if (player == 1) {

            playerDisk = '█';
            opposingDisk = '░';

        } else {

            playerDisk = '░';
            opposingDisk = '█';

        }

        // Placing Disk
        if (isValid(player, chosenColumn, chosenRow)) {

            board.get(chosenRow).set(chosenColumn, playerDisk);

        }

        // Swap Up
        if (chosenRow != 0 && board.get(chosenRow - 1).get(chosenColumn).equals(opposingDisk)) {

            flag = true;
            for (int i = 1; i <= chosenRow; i++) {

                if (board.get(chosenRow - i).get(chosenColumn).equals(playerDisk)) {

                    flag = false;
                    break;

                }

            }

            if (!flag) {

                for (int i = 1; i <= chosenRow; i++) {

                    if (board.get(chosenRow - i).get(chosenColumn).equals(playerDisk)) {

                        break;

                    } else {

                        board.get(chosenRow - i).set(chosenColumn, playerDisk);

                    }

                }

            }

        }


        // Swap Up Right
        if (chosenColumn != 7 && chosenRow != 0 && board.get(chosenRow - 1).get(chosenColumn + 1).equals(opposingDisk)) {

            if ((8 - chosenColumn) < chosenRow) {

                imax = (8 - chosenColumn);

            } else {

                imax = chosenRow;

            }

            flag = true;
            for (int i = 1; i < imax; i++) {

                if (board.get(chosenRow - i).get(chosenColumn + i).equals(playerDisk)) {

                    flag = false;
                    break;

                }

            }

            if (!flag) {

                for (int i = 1; i < imax; i++) {

                    if (board.get(chosenRow - i).get(chosenColumn + i).equals(playerDisk)) {

                        break;

                    } else {

                        board.get(chosenRow - i).set(chosenColumn + i, playerDisk);

                    }

                }

            }

        }


        // Swap Right
        if (chosenColumn != 7 && board.get(chosenRow).get(chosenColumn + 1).equals(opposingDisk)) {

            flag = true;
            for (int i = 1; i < (8 - chosenColumn); i++) {

                if (board.get(chosenRow).get(chosenColumn + i).equals(playerDisk)) {

                    flag = false;
                    break;

                }

            }

            if (!flag) {

                for (int i = 1; i < (8 - chosenColumn); i++) {

                    if (board.get(chosenRow).get(chosenColumn + i).equals(playerDisk)) {

                        break;

                    } else {

                        board.get(chosenRow).set(chosenColumn + i, playerDisk);

                    }

                }

            }

        }


        // Swap Down Right
        if (chosenColumn != 7 && chosenRow != 7 && board.get(chosenRow + 1).get(chosenColumn + 1).equals(opposingDisk)) {

            if ((8 - chosenColumn) < (8 - chosenRow)) {

                imax = (8 - chosenColumn);

            } else {

                imax = (8 - chosenRow);

            }

            flag = true;
            for (int i = 1; i < imax; i++) {

                if (board.get(chosenRow + i).get(chosenColumn + i).equals(playerDisk)) {

                    flag = false;
                    break;

                }

            }

            if (!flag) {

                for (int i = 1; i < imax; i++) {

                    if (board.get(chosenRow + i).get(chosenColumn + i).equals(playerDisk)) {

                        break;

                    } else {

                        board.get(chosenRow + i).set(chosenColumn + i, playerDisk);

                    }

                }

            }

        }


        // Swap Down
        if (chosenRow != 7 && board.get(chosenRow + 1).get(chosenColumn).equals(opposingDisk)) {

            flag = true;
            for (int i = 1; i < (8 - chosenRow); i++) {

                if (board.get(chosenRow + i).get(chosenColumn).equals(playerDisk)) {

                    flag = false;
                    break;

                }

            }

            if (!flag) {

                for (int i = 1; i < (8 - chosenRow); i++) {

                    if (board.get(chosenRow + i).get(chosenColumn).equals(playerDisk)) {

                        break;

                    } else {

                        board.get(chosenRow + i).set(chosenColumn, playerDisk);

                    }

                }

            }

        }


        // Swap Down Left
        if (chosenColumn != 0 && chosenRow != 7 && board.get(chosenRow + 1).get(chosenColumn - 1).equals(opposingDisk)) {

            if (chosenColumn < (8 - chosenRow)) {

                imax = chosenColumn;

            } else {

                imax = (8 - chosenRow);

            }

            flag = true;
            for (int i = 1; i < imax; i++) {

                if (board.get(chosenRow + i).get(chosenColumn - i).equals(playerDisk)) {

                    flag = false;
                    break;

                }

            }

            if (!flag) {

                for (int i = 1; i < imax; i++) {

                    if (board.get(chosenRow + i).get(chosenColumn - i).equals(playerDisk)) {

                        break;

                    } else {

                        board.get(chosenRow + i).set(chosenColumn - i, playerDisk);

                    }

                }

            }

        }


        // Swap Left
        if (chosenColumn != 0 && board.get(chosenRow).get(chosenColumn - 1).equals(opposingDisk)) {

            flag = true;
            for (int i = 1; i <= chosenColumn; i++) {

                if (board.get(chosenRow).get(chosenColumn - i).equals(playerDisk)) {

                    flag = false;
                    break;

                }

            }

            if (!flag) {

                for (int i = 1; i <= chosenColumn; i++) {

                    if (board.get(chosenRow).get(chosenColumn - i).equals(playerDisk)) {

                        break;

                    } else {

                        board.get(chosenRow).set(chosenColumn - i, playerDisk);

                    }

                }

            }

        }


        // Swap Up Left
        if (chosenColumn != 0 && chosenRow != 0 && board.get(chosenRow - 1).get(chosenColumn - 1).equals(opposingDisk)) {

            if (chosenColumn < chosenRow) {

                imax = chosenColumn;

            } else {

                imax = chosenRow;

            }

            flag = true;
            for (int i = 1; i < imax; i++) {

                if (board.get(chosenRow - i).get(chosenColumn - i).equals(playerDisk)) {

                    flag = false;
                    break;

                }

            }

            if (!flag) {

                for (int i = 1; i < imax; i++) {

                    if (board.get(chosenRow - i).get(chosenColumn - i).equals(playerDisk)) {

                        break;

                    } else {

                        board.get(chosenRow - i).set(chosenColumn - i, playerDisk);

                    }

                }

            }

        }

    }


    // Check Board Status
    public int blackCount() {

        int counter = 0;

        // Count Valid Moves
        for (ArrayList<Character> row : board) {

            for (char disk : row) {

                if (disk == '█') {

                    counter++;

                }

            }

        }

        return counter;

    }

    public int blackMoves() {

        int counter = 0;
        int columnCounter;
        int rowCounter = 0;

        // Count Valid Moves
        for (ArrayList<Character> row : board) {

            columnCounter = 0;

            for (char tile : row) {

                if (tile == ' ') {

                    if (isValid(1, columnCounter, rowCounter)) {

                        counter++;

                    }

                }

                columnCounter++;

            }

            rowCounter++;

        }

        return counter;

    }

    public int whiteCount() {

        int counter = 0;

        for (ArrayList<Character> row : board) {

            for (char disk : row) {

                if (disk == '░') {

                    counter++;

                }

            }

        }

        return counter;

    }

    public int whiteMoves() {

        int counter = 0;
        int columnCounter;
        int rowCounter = 0;

        for (ArrayList<Character> row : board) {

            columnCounter = 0;

            for (char tile : row) {

                if (tile == ' ') {

                    if (isValid(2, columnCounter, rowCounter)) {

                        counter++;

                    }

                }

                columnCounter++;

            }

            rowCounter++;

        }

        return counter;

    }

    public boolean isValid(int player, int chosenColumn, int chosenRow) {

        boolean isValid = false;

        int imax;
        char playerDisk;
        char opposingDisk;

        if (player == 1) {

            playerDisk = '█';
            opposingDisk = '░';

        } else {

            playerDisk = '░';
            opposingDisk = '█';

        }

        if (board.get(chosenRow).get(chosenColumn) == ' ' && (player == 1 || player == 2)) {

            // Check Left
            if (chosenColumn != 0 && board.get(chosenRow).get(chosenColumn - 1).equals(opposingDisk)) {

                for (int i = 2; i <= chosenColumn; i++) {

                    if (board.get(chosenRow).get(chosenColumn - i).equals(playerDisk)) {

                        isValid = true;
                        break;

                    } else if (board.get(chosenRow).get(chosenColumn - i).equals(' ')) {

                        break;

                    }

                }

            }


            // Check Right
            if (chosenColumn != 7 && board.get(chosenRow).get(chosenColumn + 1).equals(opposingDisk)) {

                for (int i = 2; i < (8 - chosenColumn); i++) {

                    if (board.get(chosenRow).get(chosenColumn + i).equals(playerDisk)) {

                        isValid = true;
                        break;

                    } else if (board.get(chosenRow).get(chosenColumn + i).equals(' ')) {

                        break;

                    }

                }

            }


            // Check Up
            if (chosenRow != 0 && board.get(chosenRow - 1).get(chosenColumn).equals(opposingDisk)) {

                for (int i = 2; i <= chosenRow; i++) {

                    if (board.get(chosenRow - i).get(chosenColumn).equals(playerDisk)) {

                        isValid = true;
                        break;

                    } else if (board.get(chosenRow - i).get(chosenColumn).equals(' ')) {

                        break;

                    }

                }

            }


            // Check Down
            if (chosenRow != 7 && board.get(chosenRow + 1).get(chosenColumn).equals(opposingDisk)) {

                for (int i = 2; i < (8 - chosenRow); i++) {

                    if (board.get(chosenRow + i).get(chosenColumn).equals(playerDisk)) {

                        isValid = true;
                        break;

                    } else if (board.get(chosenRow + i).get(chosenColumn).equals(' ')) {

                        break;

                    }

                }

            }

            // Check Up Left
            if (chosenColumn != 0 && chosenRow != 0 && board.get(chosenRow - 1).get(chosenColumn - 1).equals(opposingDisk)) {

                if (chosenColumn < chosenRow) {

                    imax = chosenColumn;

                } else {

                    imax = chosenRow;

                }

                for (int i = 2; i < imax; i++) {

                    if (board.get(chosenRow - i).get(chosenColumn - i).equals(playerDisk)) {

                        isValid = true;
                        break;

                    } else if (board.get(chosenRow - i).get(chosenColumn - i).equals(' ')) {

                        break;

                    }

                }

            }

            // Check Up Right
            if (chosenColumn != 7 && chosenRow != 0 && board.get(chosenRow - 1).get(chosenColumn + 1).equals(opposingDisk)) {

                if ((8 - chosenColumn) < chosenRow) {

                    imax = (8 - chosenColumn);

                } else {

                    imax = chosenRow;

                }

                for (int i = 2; i < imax; i++) {

                    if (board.get(chosenRow - i).get(chosenColumn + i).equals(playerDisk)) {

                        isValid = true;
                        break;

                    } else if (board.get(chosenRow - i).get(chosenColumn + i).equals(' ')) {

                        break;

                    }

                }

            }


            // Check Down Left
            if (chosenColumn != 0 && chosenRow != 7 && board.get(chosenRow + 1).get(chosenColumn - 1).equals(opposingDisk)) {

                if (chosenColumn < (8 - chosenRow)) {

                    imax = chosenColumn;

                } else {

                    imax = (8 - chosenRow);

                }

                for (int i = 2; i < imax; i++) {

                    if (board.get(chosenRow + i).get(chosenColumn - i).equals(playerDisk)) {

                        isValid = true;
                        break;

                    } else if (board.get(chosenRow + i).get(chosenColumn - i).equals(' ')) {

                        break;

                    }

                }

            }

            // Check Down Right
            if (chosenColumn != 7 && chosenRow != 7 && board.get(chosenRow + 1).get(chosenColumn + 1).equals(opposingDisk)) {

                if ((8 - chosenColumn) < (8 - chosenRow)) {

                    imax = (8 - chosenColumn);

                } else {

                    imax = (8 - chosenRow);

                }

                for (int i = 2; i <= imax; i++) {

                    if (board.get(chosenRow + i).get(chosenColumn + i).equals(playerDisk)) {

                        isValid = true;
                        break;

                    } else if (board.get(chosenRow + i).get(chosenColumn + i).equals(' ')) {

                        break;

                    }

                }

            }

        }

        return isValid;

    }

    public boolean gameComplete() {

        boolean gameComplete = true;
        int columnCounter;
        int rowCounter = 0;

        if (!(whiteCount() == 0 || blackCount() == 0)) {

            for (ArrayList<Character> row : board) {

                columnCounter = 0;

                for (char tile : row) {

                    if (tile == ' ') {

                        if ((isValid(1, columnCounter, rowCounter) || isValid(2, columnCounter, rowCounter))) {

                            gameComplete = false;

                        }

                    }

                    columnCounter++;

                }

                rowCounter++;

            }

        }

        return gameComplete;

    }

}