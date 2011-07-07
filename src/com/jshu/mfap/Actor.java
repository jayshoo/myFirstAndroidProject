package com.jshu.mfap;

import android.graphics.*;

public class Actor implements IDrawable {
	private int color;
	private float x, y;
	
	public Actor()
	{
		this.color = Color.RED;
	}
	
	public void draw(Canvas c)
	{
		Paint paint = new Paint();
		paint.setColor(this.color);
		c.drawRect(x,y,x+30,y+30,paint);
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public void setPos(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
}
