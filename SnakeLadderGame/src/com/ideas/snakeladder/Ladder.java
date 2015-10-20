package com.ideas.snakeladder;

public class Ladder {

	private int startPoint;
	private int endPoint;

	
	
	public Ladder(int startPoint, int endPoint) {
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
		
		Ladder ladder = (Ladder) arg0;
		
		if(startPoint==ladder.getStartPoint())
			return true;
		return false;
		
	}

}
