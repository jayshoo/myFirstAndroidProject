package com.jshu.mfap;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;

import java.util.ArrayList;
import java.util.List;

public class JView extends View {
	private Canvas canvas;
	private Bitmap bitmap;
	private List<Actor> actors;
	
	public JView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		actors = new ArrayList<Actor>();
		
		Actor a = new Actor();
		a.setColor(Color.RED);
		a.setPos(10, 10);
		actors.add(a);
		
		Actor b = new Actor();
		b.setColor(Color.BLUE);
		b.setPos(50, 50);
		actors.add(b);
	}
	
	protected void onSizeChanged(int w, int h, int oldw, int oldh) 
	{
		if (bitmap != null)
		{
			bitmap.recycle();
		}
		canvas = new Canvas();
		bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		canvas.setBitmap(bitmap);
	}
	
	public void destroy()
	{
		if (bitmap != null)
		{
			bitmap.recycle();
		}
	}
	
	public void onDraw(Canvas c)
	{
		Paint bg = new Paint();
		bg.setColor(Color.WHITE);
		canvas.drawPaint(bg);
		
		for (Actor a : actors)
		{
			a.draw(canvas);
		}
		
		c.drawBitmap(bitmap,
				new Rect(0,0,bitmap.getWidth(),bitmap.getHeight()),
				new Rect(0,0,bitmap.getWidth(),bitmap.getHeight()),
				null);
	}
	
	public boolean onTouchEvent(MotionEvent e)
	{
		float x = e.getX();
		float y = e.getY();
		
		for (Actor a : actors)
		{
			a.setPos(x, y);
		}
		
		this.invalidate();
		
		return true;
	}
}
