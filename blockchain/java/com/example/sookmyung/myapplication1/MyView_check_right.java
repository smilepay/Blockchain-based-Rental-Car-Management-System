package com.example.sookmyung.myapplication1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;

import java.util.Vector;

public class MyView_check_right extends View {
    Paint paint = new Paint();
    Path path = new Path();

    Block previous_block = Blockchain.getLatestBlock();
    Vector<Pair> scretch_right = new Vector<>();

    public MyView_check_right(DefectCheck context) {
        super(context);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(path, paint);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);

        scretch_right = previous_block.getScretch_rightb();

        for(int i=0; i<scretch_right.size(); i++){
            Pair pair = new Pair(0,0,0,0);
            pair = scretch_right.elementAt(i);
            canvas.drawLine((int)pair.getSource_x(),(int)pair.getSource_y(),(int)pair.getDestination_x(),(int)pair.getDestination_y(),paint);
        }
    }
    public MyView_check_right(Context context, AttributeSet attr)
    {
        super(context, attr);
    }
}