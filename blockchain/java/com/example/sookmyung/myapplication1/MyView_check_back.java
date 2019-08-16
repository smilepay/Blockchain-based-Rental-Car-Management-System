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

public class MyView_check_back extends View {
    Paint paint = new Paint();
    Path path = new Path();

    Block previous_block = Blockchain.getLatestBlock();
    Vector<Pair> scretch_back = new Vector<>();

    public MyView_check_back(DefectCheck context) {
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

        scretch_back = previous_block.getScretch_backb();

        for(int i=0; i<scretch_back.size(); i++){
            Pair pair = new Pair(0,0,0,0);
            pair = scretch_back.elementAt(i);
            canvas.drawLine((int)pair.getSource_x(),(int)pair.getSource_y(),(int)pair.getDestination_x(),(int)pair.getDestination_y(),paint);
        }
    }
    public MyView_check_back(Context context, AttributeSet attr)
    {
        super(context, attr);
    }
}