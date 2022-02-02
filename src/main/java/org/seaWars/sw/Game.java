package org.seaWars.sw;

/*
 * Represents main loop to control game's behaviour.
 */
public class Game {
    public static void main(String[] args) {
        var gameBoard = new GameBoard(System.out);
        gameBoard.start();
    }
}

