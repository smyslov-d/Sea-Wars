package org.seaWars.sw;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCase {
    public static int[] ship;
    public static BattleField b;
    int one = ship[0];
    int two = ship[1];
    int three = ship[2];
    int seven = 7;

    @BeforeClass
    public static void stopRandom() {
        b = new BattleField(System.out);
        ship = b.locationCells;
    }

    /*
     *  Пользователь ввел не верные координаты хода
     */
    @Test
    public void missed() {
        boolean result = b.makeMove(seven);
        Assert.assertEquals(false, result);
    }

    /*
     *  Пользователь ввел верные координаты хода
     */
    @Test
    public void success() {
        Boolean result = b.makeMove(one);
        Assert.assertEquals(true, result);
    }

    /*
     *  Пользователь потопил корабль
     */
    @Test
    public void win() {
        Boolean result = b.makeMove(two);
        result = b.makeMove(three);
        Assert.assertEquals(null, result);
    }

    /*
     *  Пользователь ввел буквы
     */
    @Test
    public void exceptStr() {

        String userGuess = "a";
        int g = b.checkUserInput(userGuess);
        Assert.assertEquals(-3, g);
    }

    /*
     *  Выводим на экран сообщение (пользователь ввел буквы)
     */
    @Test
    public void displayStr() {
        GameBoard game = new GameBoard(System.out);
        String userGuess = "a";
        int g = b.checkUserInput(userGuess);
        int g2 = game.printMessage(g);
        Assert.assertEquals(-3, g2);
    }

    /*
     *  Пользователь ввел слишком большое число
     */
    @Test
    public void exceptBigInt() {
        String userGuess = "71856";
        int g = b.checkUserInput(userGuess);
        Assert.assertEquals(-2, g);
    }

    /*
     *  Выводим на экран сообщение (слишком большое число)
     */
    @Test
    public void displayBigInt() {
        GameBoard game = new GameBoard(System.out);
        String userGuess = "71856";
        int g = b.checkUserInput(userGuess);
        int g2 = game.printMessage(g);
        Assert.assertEquals(-2, g2);
    }

    /*
     *  Пользователь ввел отрицаетельное значение
     */
    @Test
    public void exceptNegativInt() {
        String userGuess = "-1";
        int g = b.checkUserInput(userGuess);
        Assert.assertEquals(-1, g);
    }

    /*
     *  Выводим на экран сообщение (отрицаетельное значение)
     */
    @Test
    public void displayNegativInt() {
        GameBoard game = new GameBoard(System.out);
        String userGuess = "-1";
        int g = b.checkUserInput(userGuess);
        int g2 = game.printMessage(g);
        Assert.assertEquals(-1, g2);
    }

    /*
     *  Тест метода который принимает ввод с консоли
     */
//    @Test
//    public void input() {
//        GameBoard game = new GameBoard(System.out);
//        BufferedReader is = new BufferedReader(new InputStreamReader(System.in)) {
//            private boolean finished = false;
//
//            @Override
//            public int read() {
//                int result = finished ? -1 : '1';
//                finished = true;
//                return result;
//            }
//        };
//
//
//        String result = game.getUserInput();
//        Assert.assertEquals("1", result);
//    }
}

//    GameBoard game = new GameHelper(new InputStream() {
//        private boolean finished = false;
//
//        @Override
//        public int read() throws IOException {
//            int result = finished ? -1 : '1';
//            finished = true;
//            return result;
//        }
//    });
