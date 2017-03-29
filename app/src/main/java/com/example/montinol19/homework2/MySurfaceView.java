package com.example.montinol19.homework2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import static android.graphics.Color.blue;
import static android.graphics.Color.green;
import static android.graphics.Color.red;

/**
 * Created by Dylan on 3/25/2017.
 */

public class MySurfaceView extends SurfaceView implements View.OnTouchListener
{

    public CustomCircle sun;
    public CustomRect tower;
    private int height;
    private int width;
    public int numberElement;

    public MySurfaceView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);

        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        this.setOnTouchListener(this);

        sun 	= new CustomCircle("sun", Color.YELLOW, 20*width/21 , 2*height/16,300);
        tower 	= new CustomRect("tower", Color.DKGRAY,2*width/11,height/6,width/3,height);

    }

    @Override
    public void onDraw(Canvas canvas)
    {
        Paint sky = new Paint();
        sky.setColor(Color.BLUE);
        canvas.drawRect(0,0,width,height,sky);
        sun.drawMe(canvas);
        tower.drawMe(canvas);



        if(numberElement == 1)
        {
            sun.drawHighlight(canvas);
        }
        else if(numberElement == 2)
        {
            tower.drawHighlight(canvas);
        }


    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if(event.getActionMasked() == MotionEvent.ACTION_DOWN)
        {

            if (sun.containsPoint((int)event.getX(), (int)event.getY()))
            {
                numberElement = 1;
                MainActivity.redSeek.setProgress(red(sun.getColor()));
                MainActivity.redValue.setText("" + red(sun.getColor()));
                MainActivity.greenSeek.setProgress(green(sun.getColor()));
                MainActivity.greenValue.setText("" + green(sun.getColor()));
                MainActivity.blueSeek.setProgress(blue(sun.getColor()));
                MainActivity.blueValue.setText("" + blue(sun.getColor()));
                MainActivity.element.setText(sun.getName());
                invalidate();

            } else if (tower.containsPoint((int)event.getX(),(int)event.getY()))
            {
                numberElement = 2;
                MainActivity.redSeek.setProgress(red(tower.getColor()));
                MainActivity.redValue.setText("" + red(tower.getColor()));
                MainActivity.greenSeek.setProgress(green(tower.getColor()));
                MainActivity.greenValue.setText("" + green(tower.getColor()));
                MainActivity.blueSeek.setProgress(blue(tower.getColor()));
                MainActivity.blueValue.setText("" + blue(tower.getColor()));
                MainActivity.element.setText(tower.getName());
                invalidate();

            }
        }
        return true;
    }

}