/* PLACE YOUR NAME HERE
   Dr. Steinberg
   COP3503 Spring 2025
   Programming Assignment 1
*/

import java.util.Random; 

public class GameDriver
{
    public static void main(String [] args) throws Exception
    {
		int fails = 0;
		int passes = 0;
        //different seeds for each random object
        Random[] randoms = new Random[100];
        for (int i = 0; i < 100; i++) {
            randoms[i] = new Random(i + 1);
        }

        System.out.println("Testing to See if Player 1 will always win with the 100 random seeds.");

        Game[] games = new Game[100];
        for (int i = 0; i < 100; i++) {
            games[i] = new Game(randoms[i]);
        }

        for (int i = 0; i < 100; i++) {
            if (games[i].play() == 1) {
                System.out.println("Game " + (i + 1) + " Pass!");
				passes++;
            } else {
                System.out.println("Game " + (i + 1) + " Fail!");
				fails++;
            }
        }
		System.out.println("Passes: " + passes);
		System.out.println("Fails: " + fails);
    }
}