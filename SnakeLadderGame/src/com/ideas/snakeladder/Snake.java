package com.ideas.snakeladder;

public class Snake {

	private int startPoint;
	private int endPoint;

	
	
	public Snake(int startPoint, int endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public boolean equals(Object arg0) {
		
		Snake snake = (Snake) arg0;
		
		if(startPoint == snake.getStartPoint())
			return true;
		
		return false;
	}

}
