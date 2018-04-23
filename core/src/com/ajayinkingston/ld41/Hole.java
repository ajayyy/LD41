package com.ajayinkingston.ld41;

import com.badlogic.gdx.math.Vector2;

//a whole in the wall
public class Hole {
	
	float start, end;
	
	boolean evil;
	
	//0 left, 1 right, 2 up, 3 down
	int side;
	
	public Hole(float start, float end, int side, boolean evil) {
		this.start = start;
		this.end = end;
		this.side = side;
		this.evil = evil;
	}

}
