package com.ideas.snakeladder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Board {


	private int boardArray[] = new int[100];
	public Map<String, User> userList = new HashMap<String, User>();
	private int currentUserIndex = 0;
	private boolean multiUser = false;
	private List<Snake> snakes = null;
	private List<Ladder> ladders = null;
	
	public Board(List<Snake> snakes, List<Ladder> ladders) {
		
		this.snakes = snakes;
		this.ladders = ladders;
		
		// generate board
		for (int i = 1; i <= 100; i++) {
			boardArray[i-1]=i;
		}
		
	}
	

	public void displayGameBoard()
	{
		System.out.println();
		for (int i = 99; i >= 0; i--)
		{
			if (i == 99)
			{
				System.out.print("   ");
			}

			System.out.print(boardArray[i]);
			System.out.print("    ");

			if (i != 99 && (i) % 10 == 0)
			{
				int f = i - 10;
				for (int k = f; k < i; k++)
				{
					if (k == f)
					{
						System.out.println();
						System.out.print("    ");
					}
					if (boardArray[k] / 10 == 0)
					{
						System.out.print(" ");
						System.out.print(boardArray[k]);
					}
					else
					{
						System.out.print(boardArray[k]);
					}
					System.out.print("    ");
				}
				i = f;
				System.out.println();
				System.out.print("    ");
			}
		}
	}


	public void createSingleUser()
	{
		userList.clear();
		int id = 1;
		User usr = new User(id);
		userList.put("User" + id, usr);
		System.out.println("\nUser" + id + " created successfully");
	}

	public void createMultipleUser()
	{
		userList.clear();
		multiUser = true;
		for (int i = 0; i < 2; i++)
		{
			int id = i + 1;
			User usr = new User(id);
			userList.put("User" + id, usr);
			System.out.println("\nUser" + id + " created successfully");
		}
	}


	public void playGame(){
		
		int i = 0;
		System.out.println("\nGame Started.....  ");
		do
		{
			String curName = getCurrentUserName();
			System.out.println("1. Roll Dice \n2. Show Positions \n3. Display Board \n4. Stop Game");
			System.out.println("Chance for User..." + curName);
			System.out.print("Please provide your option : ");

			Scanner in = new Scanner(System.in);
			i = in.nextInt();

			switch (i)
			{
			case 1:
				int curPos = this.updateUserPositions(curName);
				if (curPos >= 100)
				{
					System.out.println(curName + " has successfully won the game. \n Game exit");
					return;
				}
				break;

			case 2:
				this.displayUserPositions();
				if (multiUser == true)
					currentUserIndex = (currentUserIndex == 2) ? 1 : 0;
				break;

			case 3:
				this.displayGameBoard();
				if (multiUser == true)
					currentUserIndex = (currentUserIndex == 2) ? 1 : 0;
				break;

			case 4:
				return;
			}
			System.out.println();
		} while (i != 0);
	}

	public int updateUserPositions(String name){
		
		Set<String> keyset = userList.keySet();
		
		if (keyset.contains(name)){
			User ur = userList.get(name);
			ur.setCurrentPosition(checkSLPointersForCurPos(ur.getCurrentPosition()+ Dice.rollDice()));
			System.out.println(name + " current position is " + ur.getCurrentPosition());
			return ur.getCurrentPosition();
		}
		return 0;
	}

	public void displayUserPositions(){
		
		Set<String> keyset = userList.keySet();
		Iterator<String> it = keyset.iterator();
		while (it.hasNext())
		{
			String key = (String) it.next();
			User us = userList.get(key);
			System.out.println(key + "current position is...." + us.getCurrentPosition());
		}
	}

	public String getCurrentUserName(){
		
		if (currentUserIndex == 0)
		{
			currentUserIndex++;
			return "user" + (currentUserIndex);
		}
		else if (currentUserIndex == 1)
		{
			if (multiUser == false)
				return "user" + currentUserIndex;
			else
				currentUserIndex++;
			return "user" + currentUserIndex;
		}
		else
		{
			currentUserIndex--;
			return "user" + (currentUserIndex);
		}
	}

	public int checkSLPointersForCurPos(int curPos){
		
		
		for (Snake snake : snakes) {
			if(curPos== snake.getStartPoint()){
				System.out.println("OOPs!! you have been dropped down by Snake...");
				return snake.getEndPoint();
			}
		}
		
		for (Ladder ladder : ladders) {
			if(curPos == ladder.getStartPoint()){
				System.out.println("Wow!! you have climbed up the ladder...");
				return ladder.getEndPoint();
			}
		}
		
		
		return curPos;
	}
}

