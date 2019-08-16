package com.example.sookmyung.myapplication1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;
import static com.example.sookmyung.myapplication1.MyView_front.s;

import java.util.Vector;

public class MyView_back extends View {
    static Paint paint = new Paint();
    Path path = new Path();
    Pair pair;
    Paint canvasPaint;
    Canvas drawCanvas;
    Bitmap canvasBitmap;
    int source_x;
    int source_y;
    int flag = 0;
    static int cmd=1;
    int iWidth,iHeight;
    int[] colors;


    Block previous_block = Blockchain.getLatestBlock();
    Vector<Pair> scretch_back = new Vector<>();

    public MyView_back(Context context, AttributeSet attr)
    {
        super(context, attr);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    public MyView_back(DefectCheck context) {
        super(context);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
        iWidth = canvasBitmap.getWidth();
        iHeight = canvasBitmap.getHeight();
        colors = new int[iWidth * iHeight];
        canvasBitmap.getPixels(colors, 0, iWidth, 0, 0, iWidth, iHeight);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        canvas.drawPath(path, paint);
        scretch_back = previous_block.getScretch_backb();


        for(int i=0; i<scretch_back.size(); i++){
            Pair pair = new Pair(0,0,0,0);
            pair = scretch_back.elementAt(i);
            canvas.drawLine((int)pair.getSource_x(),(int)pair.getSource_y(),(int)pair.getDestination_x(),(int)pair.getDestination_y(),paint);
        }
    }
    public static void blackpen() {
        cmd=1;
    }
    public static void whitepen(){
        cmd=0;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        Toast.makeText(super.getContext(), "X =" + x + " Y = " + y, Toast.LENGTH_LONG).show();

        if(cmd == 1) {
            //invalidate();
            //patherase.reset();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(x, y);
                    path.lineTo(x, y);
                    if (flag == 0) {
                        source_x = x;
                        source_y = y;
                    }
                    flag = 1;
                    break;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(x, y);
                    break;
                case MotionEvent.ACTION_UP:
                    drawCanvas.drawPath(path, paint);
                    scretch_back.add(new Pair(source_x, source_y, x, y));
                    s.setScretch_backsc(scretch_back);
                    flag = 0;
                    path.reset();
                    break;
            }
        }
        else if(cmd == 0){
            //invalidate();
            //path.reset();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //path.moveTo(x, y);
                    //path.lineTo(x, y);
                    if (flag == 0) {
                    source_x = x;
                    source_y = y;
                }
                    flag = 1;
                    break;
                case MotionEvent.ACTION_MOVE:
                    //path.lineTo(x, y);
                    break;
                case MotionEvent.ACTION_UP:
                    //drawCanvas.drawPath(path, paint);
                    scretch_back = s.getScretch_backsc();
                    System.out.println(scretch_back.size());
                    for(int i=1; i<scretch_back.size(); i++){
                                if((scretch_back.elementAt(i).getSource_x()-30<=source_x && scretch_back.elementAt(i).getSource_x()+30>=source_x ) && (scretch_back.elementAt(i).getSource_y()-30 <= source_y && scretch_back.elementAt(i).getSource_y()+30 >=source_y)){
                                        scretch_back.removeElementAt(i);
                                    s.setScretch_backsc(scretch_back);
                                    break;
                        }
                    }
                    scretch_back = s.getScretch_backsc();
                    canvasBitmap.setPixels(colors, 0, iWidth, 0, 0, iWidth, iHeight);

                    for(int i=1; i<scretch_back.size(); i++){
                        Pair pair = new Pair(0,0,0,0);
                        pair = scretch_back.elementAt(i);
                        drawCanvas.drawLine((int)pair.getSource_x(),(int)pair.getSource_y(),(int)pair.getDestination_x(),(int)pair.getDestination_y(),paint);
                    }
                    flag = 0;
                    path.reset();
                    break;
            }
        }
        invalidate();
        return true;
    }
}