package com.ideas.snakeladder.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ideas.snakeladder.Board;
import com.ideas.snakeladder.Ladder;
import com.ideas.snakeladder.Snake;

public class Main {

	public static void main(String[] args) {

		
		
		List<Snake> snakes = new ArrayList<Snake>();
		snakes.add(new Snake(17,7));
		snakes.add(new Snake(54,34));
		snakes.add(new Snake(62,19));
		snakes.add(new Snake(64,60));
		snakes.add(new Snake(87,24));
		snakes.add(new Snake(93,73));
		snakes.add(new Snake(95,75));
		snakes.add(new Snake(99,78));  // I have specified 8 snake as per req. you can remove or add any snake
		
		
		List<Ladder> ladders = new ArrayList<Ladder>();
		ladders.add(new Ladder(4, 14));
		ladders.add(new Ladder(9, 31));
		ladders.add(new Ladder(20, 38));
		ladders.add(new Ladder(28, 84));
		ladders.add(new Ladder(40, 59));
		ladders.add(new Ladder(51, 67));
		ladders.add(new Ladder(63, 81));
		ladders.add(new Ladder(71, 91)); // I have specified 8 ladder as per req. you can remove or add any snake
	
		Board sl = new Board(snakes,ladders);

		System.out.println("Snake & Ladder Game");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("User Options");
		System.out.println("\n1. Start Game \n2. Sinlge Player \n3. Multi Players(only 2) \n4. Exit Game");
		
		System.out.print("Please provide your option : ");

		int i = 1;

		while (i != 0)
		{
			Scanner in = new Scanner(System.in);
			i = in.nextInt();

			switch (i)
			{
			case 1:
				if (sl.userList.size() == 0)
				{
					System.out.println("\nPlease create users and play the game..");
					break;
				}
				else
				{
					sl.playGame();
				}
				break;

			case 2:
				sl.createSingleUser();
				break;

			case 3:
				sl.createMultipleUser();
				break;

			case 4:
				System.exit(0);
			}

			System.out.println();
			System.out.println("User Options");
			System.out.println("\n1. Start Game \n2. Sinlge Player \n3. Multi Players(only 2) \n4. Exit Game");
			
			System.out.print("Please provide your option : ");
		}
	}

}
