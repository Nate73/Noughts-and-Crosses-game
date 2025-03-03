import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // creates the noughts and crosses table
    String[][] table = new String[3][3];
    int Xs = 5;
    while (Xs > 0){
        Xs = 5;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Math.random() <= 0.5 && Xs != 0){
                   table[i][j] = "X";
                   Xs -= 1;
                } else {
                   table[i][j] = "O";
                }
            }
        }
    }

    // prints table
    System.out.println("  a b c");

    for (int i = 0; i < 3; i++) {
        switch (i) {
                case 0 -> System.out.print("d ");
                case 1 -> System.out.print("e ");
                case 2 -> System.out.print("f ");
                default -> {
            }
        }
        for (int j = 0; j < 3; j++) {
                 System.out.print(table[i][j]);
                 System.out.print(" ");
        }
        System.out.println(" ");
    }

    // moves the noughts and crosses around the table until solved
    while(solved(table) == false){
        System.out.print("Enter move: ");
        String move = scanner.nextLine();
        String[] temp = new String[3];
        System.out.print("\033[2J");

        // columns
        if (move.contains("a") == true && move.contains("8") == true){
            // a move up //
            for (int i = 0; i < 3; i++) {
                temp[i] = table[i][0];
            }
            for (int i = 0; i < 2; i++) {
                table[i][0] = temp[i+1];
            }
            table[2][0] = temp[0];
        } else if (move.contains("a") == true && move.contains("2") == true){
            // a move down //
            for (int i = 0; i < 3; i++) {
                temp[i] = table[i][0];
            }
            for (int i = 1; i < 3; i++) {
                table[i][0] = temp[i-1];
            }
            table[0][0] = temp[2];
        } else if (move.contains("b") == true && move.contains("8") == true){
            // b move up //
            for (int i = 0; i < 3; i++) {
                temp[i] = table[i][1];
            }
            for (int i = 0; i < 2; i++) {
                table[i][1] = temp[i+1];
            }
            table[2][1] = temp[0];
        } else if (move.contains("b") == true && move.contains("2") == true){
            // b move down //
            for (int i = 0; i < 3; i++) {
                temp[i] = table[i][1];
            }
            for (int i = 1; i < 3; i++) {
                table[i][1] = temp[i-1];
            }
            table[0][1] = temp[2];
        } else if (move.contains("c") == true && move.contains("8") == true){
            // c move up //
            for (int i = 0; i < 3; i++) {
                temp[i] = table[i][2];
            }
            for (int i = 0; i < 2; i++) {
                table[i][2] = temp[i+1];
            }
            table[2][2] = temp[0];
        } else if (move.contains("c") == true && move.contains("2") == true){
            // c move down //
            for (int i = 0; i < 3; i++) {
                temp[i] = table[i][2];
            }
            for (int i = 1; i < 3; i++) {
                table[i][2] = temp[i-1];
            }
            table[0][2] = temp[2];
        }

        // rows
        if (move.contains("d") == true && move.contains("4") == true){
            // d move left //
            System.arraycopy(table[0], 0, temp, 0, 3);
            for (int i = 0; i < 2; i++) {
                table[0][i] = temp[i+1];
            }
            table[0][2] = temp[0];
        } else if (move.contains("d") == true && move.contains("6") == true){
            // d move right //
            System.arraycopy(table[0], 0, temp, 0, 3);
            for (int i = 1; i < 3; i++) {
                table[0][i] = temp[i-1];
            }
            table[0][0] = temp[2];
        } else if (move.contains("e") == true && move.contains("4") == true){
            // e move left //
            System.arraycopy(table[1], 0, temp, 0, 3);
            for (int i = 0; i < 2; i++) {
                table[1][i] = temp[i+1];
            }
            table[1][2] = temp[0];
        } else if (move.contains("e") == true && move.contains("6") == true){
            // e move right //
            System.arraycopy(table[1], 0, temp, 0, 3);
            for (int i = 1; i < 3; i++) {
                table[1][i] = temp[i-1];
            }
            table[1][0] = temp[2];
        } else if (move.contains("f") == true && move.contains("4") == true){
            // f move left //
            System.arraycopy(table[2], 0, temp, 0, 3);
            for (int i = 0; i < 2; i++) {
                table[2][i] = temp[i+1];
            }
            table[2][2] = temp[0];
        } else if (move.contains("f") == true && move.contains("6") == true){
            // f move right //
            System.arraycopy(table[2], 0, temp, 0, 3);
            for (int i = 1; i < 3; i++) {
                table[2][i] = temp[i-1];
            }
            table[2][0] = temp[2];
        }

        System.out.println("  a b c");

        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0 -> System.out.print("d ");
                case 1 -> System.out.print("e ");
                case 2 -> System.out.print("f ");
                default -> {
                }
            }
            for (int j = 0; j < 3; j++) {
                 System.out.print(table[i][j]);
                 System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    System.out.println("Solved!");
  }

  // checks to see in the table is solved
  public static boolean solved(String[][] array){
    boolean solved = true;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (j % 2 == 0 && i % 2 == 0){
                if (array[i][j].equals("X") == false){
                    solved = false;
                    break;
                }
            } else if (j % 2 == 0 && i % 2 == 1){
                if (array[i][j].equals("O") == false){
                    solved = false;
                    break;
                }
            } else if (j % 2 == 1 && i % 2 == 1){
                if (array[i][j].equals("X") == false){
                    solved = false;
                    break;
                }
            } else if (j % 2 == 1 && i % 2 == 0){
                if (array[i][j].equals("O") == false){
                    solved = false;
                    break;
                }
            }
        }
    }

    return solved;
  }
}