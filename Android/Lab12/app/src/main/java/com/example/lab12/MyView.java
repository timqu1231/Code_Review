package com.example.lab12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    public final int CIRCLE = 0;
    public final int TRIANGLE = 1;
    public final int RECTANGLE = 2;
    public int current_shape = TRIANGLE;
    private Paint myPaint;
    private int myColor;
    private Rect rect;
    private Path path;
    int radius;
    Point a;
    Point b;
    Point c;
    int rectWidth;
    int rectHeight;

    public MyView(Context context, AttributeSet attrs){
        super(context, attrs);
        myPaint = new Paint();
        myPaint.setStyle(Paint.Style.FILL);
        myColor = Color.BLUE;
        myPaint.setColor(myColor);
        rect = new Rect();
        path = new Path();
        rectWidth = 100;
        rectHeight = 100;
        radius = 50;
        a = new Point(350,50);
        b = new Point(350,300);
        c = new Point(550,300);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        myPaint.setColor(myColor);
        switch (current_shape){
            case TRIANGLE:
                drawTriangle(canvas);
                break;
            case CIRCLE:
                drawCircle(canvas);
                break;
            case RECTANGLE:
                drawRectangle(canvas);
                break;
        }
    }

    public void drawTriangle(Canvas canvas){
        a = new Point(a.x,a.y);
        b = new Point(b.x, b.y);
        c = new Point(c.x,c.y);
        path = new Path();
        path.moveTo(a.x,a.y);
        path.lineTo(b.x,b.y);
        path.lineTo(c.x,c.y);
        path.close();
        canvas.drawPath(path, myPaint);
    }

    public Point getPointA() {return a;}
    public Point getPointB() {return b;}
    public Point getPointC() {return c;}

    public void enLargeTriangle(){
        b.y = getPointB().y + 50;
        c.x = getPointC().x + 50;
        c.y = getPointC().y + 50;
        invalidate();
    }

    public void shrinkTriangle(){
        this.b.y = getPointB().y - 50;
        this.c.x = getPointC().x - 50;
        this.c.y = getPointC().y - 50;
        invalidate();
    }

    public void drawCircle(Canvas canvas){
        int x = getWidth();
        int y= getHeight();
        canvas.drawCircle(x/2, y/2, this.radius, myPaint);
    }

    public void enLargeCircle(){
        this.radius = this.radius * 2;
        invalidate();
    }

    public void shrinkCircle(){
        if (this.radius != 50){
            this.radius = this.radius / 2;
        }
        invalidate();
    }

    public void drawRectangle(Canvas canvas){
        rect = new Rect();
        rect.left = 50;
        rect.top = 50;
        rect.right = rect.left + this.rectWidth;
        rect.bottom = rect.top + this.rectHeight;
        canvas.drawRect(rect, myPaint);
    }

    public void enLargeRectangle(){
        this.rectHeight += 50;
        this.rectWidth += 50;
        invalidate();
    }

    public void shrinkRectangle(){
        this.rectHeight -= 50;
        this.rectWidth -= 50;
        invalidate();
    }

    public void setColor(int color){
        myColor = color;
        invalidate();
    }

    public void reset(){
        myColor = Color.BLUE;
        myPaint.setColor(myColor);
        rectWidth = 100;
        rectHeight = 100;
        radius = 50;
        a = new Point(350, 50);
        b = new Point(350, 300);
        c = new Point(550, 300);
        current_shape = TRIANGLE;
        invalidate();
    }

    public void setCurrent_shape(int shape){
        current_shape = shape;
        invalidate();
    }
}
