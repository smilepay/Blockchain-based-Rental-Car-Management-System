package com.example.sookmyung.myapplication1.history_total;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sookmyung.myapplication1.R;
import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;


public class History extends AppCompatActivity {
    public static int history_index=0;
    protected void onCreate(Bundle savedInstanceState) {


       super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        Block latest_block = Blockchain.getLatestBlock();
        int index =latest_block.getIndex();

       LinearLayout lm = (LinearLayout) findViewById(R.id.history1);
        LinearLayout.LayoutParams pm = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT
        );
        Typeface typeface = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            typeface = getResources().getFont(R.font.bm);
        }


        for(int i=1;i<=index;i++){
            LinearLayout ll=new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView text = new TextView(this);
            text.setText("번호"+i+"");
            text.setTypeface(typeface);
            ll.addView(text);

            Button mButton=new Button(this);
            mButton.setId(i + 1);
            mButton.setText("Check History");
            mButton.setTypeface(typeface);
            mButton.setLayoutParams(pm);
            final int position = i;


            mButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.d("log", "position :" + position);
                    Toast.makeText(getApplicationContext(), "클릭한 position:" + position, Toast.LENGTH_LONG).show();
                    history_index=position;
                    Intent intent= new Intent(History.this, History_choice.class);
                    startActivity(intent);
                }
            });

        //버튼 add
        ll.addView(mButton);
        //LinearLayout 정의된거 add
        lm.addView(ll);
    }
        }
    }






