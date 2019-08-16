package com.example.sookmyung.myapplication1.history_total;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;


import com.example.sookmyung.myapplication1.Pair;
import java.util.Vector;

import com.example.sookmyung.myapplication1.history_total.History_choice;


public class MyView_history_back extends View {
    Paint paint = new Paint();
    Path path = new Path();

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);


        for (int i = 0; i < History_choice.scretch_back_history.size(); i++) {
            Pair pair = new Pair(0, 0, 0, 0);
            pair = History_choice.scretch_back_history.elementAt(i);
            canvas.drawLine((int) pair.getSource_x(), (int) pair.getSource_y(), (int) pair.getDestination_x(), (int) pair.getDestination_y(), paint);
        }

    }

    public MyView_history_back(Context context, AttributeSet attr)
        {
            super(context, attr);
        }
    }


