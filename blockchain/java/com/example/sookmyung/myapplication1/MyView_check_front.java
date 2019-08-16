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

public class MyView_check_front extends View {
    Paint paint = new Paint();
    Path path = new Path();

    Block previous_block = Blockchain.getLatestBlock();
    Vector<Pair> scretch_front= new Vector<>();

    public MyView_check_front(DefectCheck context) {
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

        scretch_front = previous_block.getScretch_frontb();

        System.out.println("스택 사이즈" + scretch_front.size());
        for(int i=0; i<scretch_front.size(); i++){
            Pair pair = new Pair(0,0,0,0);
            pair = scretch_front.elementAt(i);
            canvas.drawLine((int)pair.getSource_x(),(int)pair.getSource_y(),(int)pair.getDestination_x(),(int)pair.getDestination_y(),paint);
        }
    }
    public MyView_check_front(Context context, AttributeSet attr)
    {
        super(context, attr);
    }
}