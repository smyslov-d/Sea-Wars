package org.seaWars.sw;

import java.io.PrintStream;
import java.util.HashMap;

/*
 * Contains ship location and methods to check user input
 */
public class BattleField  {
    int[] locationCells; //declare integer array which put ship
    int numOfHits = 0; //declare variable to check amount hits
    int numOfMoves = 0; //create variable number check count guesses

    private PrintStream stream;

    public BattleField(PrintStream stream) {
        this.stream = stream;
        int randomNum = (int) (Math.random() * 5); //generate random number for first cell
        locationCells = new int[]{randomNum, randomNum + 1, randomNum + 2}; //use random for forming array cells.setLocationCells(locations); //pass ship location cells
    }

    /*
     * Check user input on exception
     */
    public int checkUserInput(String g) {
        int guess = 0;
        try {
            guess = Integer.parseInt(g);
            if (guess < 0) {
                guess = -1;
            }
            if (guess > 10) {
                guess = -2;
            }
        } catch (java.lang.NumberFormatException e) {
            guess = -3;
        }
        return guess;
    }

    /*
     * Check user input
     */
    public Boolean makeMove(int move) {
        numOfMoves++; //increment amount attempt
        Boolean result = false; //create variable for save result "Мимо"

        for (int cell : locationCells) { //repeat that with every array cell
            if (move == cell) { //compare user code with this array cell
                result = true; // Popal
                numOfHits++; //increment amount hits
                break; //exit loop
            }
        }

        if (numOfHits == locationCells.length) { //exit loop and compare hits, if their 3 then change result
            result = null; // "Потопил"
            stream.println("Потопил");
            stream.println("Вам потребовалось " + numOfMoves + " попыток"); //show on screen amount attempt
        }

        return result; //return result in call method
    }
}
