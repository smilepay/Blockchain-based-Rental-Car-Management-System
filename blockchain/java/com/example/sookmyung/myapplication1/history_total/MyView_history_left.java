package com.example.sookmyung.myapplication1.history_total;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


import com.example.sookmyung.myapplication1.Pair;
import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;
import static com.example.sookmyung.myapplication1.history_total.History.history_index;
import com.example.sookmyung.myapplication1.history_total.History_choice;

import java.util.Vector;

public class MyView_history_left extends View {
    Paint paint = new Paint();
    Path path = new Path();






    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(path, paint);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);
       // scretch_lefth=history_choice.getScretch_left_history();

        //System.out.println("스택 사이즈" + scretch_lefth.size());
        System.out.println(history_index);
        for(int i=0; i<History_choice.scretch_left_history.size(); i++){
            Pair pair = new Pair(0,0,0,0);
            pair = History_choice.scretch_left_history.elementAt(i);
            canvas.drawLine((int)pair.getSource_x(),(int)pair.getSource_y(),(int)pair.getDestination_x(),(int)pair.getDestination_y(),paint);
        }

    }
    public MyView_history_left(Context context, AttributeSet attr)
    {
        super(context, attr);
    }

}
