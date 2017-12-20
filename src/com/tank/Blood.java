package com.tank;
import java.awt.*;
public class Blood {
	int x, y, w, h;
	TankClient tc;
	
	int step = 0;
	private boolean life = true;
	
	//指明血块运动的轨迹，由pos中各个点构成
	private int[][] pos = {
		              {350, 300}, {360, 300}, {375, 275}, {400, 200}, {360, 270}, {365, 290}, {340, 280}	
					  };
	
	public Blood() {
		x = pos[0][0];
		y = pos[0][1];
		w = h = 15;
	}
	
	public boolean isLife() {
		return life;
	}
    
	
	public void setLife(boolean life) {
		this.life = life;
	}

	public void draw(Graphics g) {
		if(!life) return;
		
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, w, h);
		g.setColor(c);
		move();
	}
	
	private void move() {
		step ++;
		if(step == pos.length) {
			step = 0;
		}
		x = pos[step][0];
		y = pos[step][1];
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y ,w ,h);
	}
}
