package org.seaWars.sw;

import java.io.*;
import java.util.HashMap;

public class GameBoard implements Printer {
    private PrintStream printStream;

    /*
     * Create HashMap (information for user if exception)
     */
    private static final HashMap<Integer, String> MESSAGES = new HashMap<>();

    {
        MESSAGES.put(-1, "Вы ввели отрицательное значение");
        MESSAGES.put(-2, "Вы ввели слишком большое число");
        MESSAGES.put(-3, "Вы ввели не цифровое значение");
    }

    public GameBoard(PrintStream stream) {
        this.printStream = stream;
    }

    /*
     * Show on screen information for user
     */
    @Override
    public int printMessage(int g) {
        int guess = g;
        switch (guess) {
            case -1:
                printStream.println(MESSAGES.get(-1));
                break;
            case -2:
                printStream.println(MESSAGES.get(-2));
                break;
            case -3:
                printStream.println(MESSAGES.get(-3));
        }
        return guess;
    }

    /*
     * For get user input
     */
    public String getUserInput() {
        String inputLine = null;
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            printStream.println("IOEception: " + e);
        }
        return inputLine;
    }

    public void start() {
        BattleField ship = new BattleField(System.out); //create new Ship

        boolean isAlive = true; //create boolean to check end game
        while (isAlive == true) {
            printStream.println("Введите число от 0 до 10:");

            String guess = getUserInput(); //take user input
            int intGuess = ship.checkUserInput(guess); //check on exception user input
            printMessage(intGuess); //display information for user

            if (intGuess < 0) {
                continue;
            }

            Boolean result = ship.makeMove(intGuess);

            if (result == null) {
                isAlive = false;
            } else if (result) { //if ship dead assigns false and to terminate a loop
                printStream.println("Popal");
            } else {
                printStream.println("Mimo");
            }
        }
    }
}

