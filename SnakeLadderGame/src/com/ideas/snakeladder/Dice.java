package com.ideas.snakeladder;

import java.util.Random;

public class Dice {

	public static int rollDice(){
		
            Random random = new Random();
            int randomNo = random.nextInt(5) + 1;
            System.out.println("\nGenerated dice value "+randomNo);
            return randomNo;
    }
	
}
