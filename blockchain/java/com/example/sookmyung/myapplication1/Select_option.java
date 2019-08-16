package com.example.sookmyung.myapplication1;


    import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sookmyung.myapplication1.history_total.History;


    public class Select_option extends AppCompatActivity {
        Button button1, button2, button_history;
        public static int index_lastLine = 0;
        String index_lastLine_string = null;
        public static int index_battery = 0;
        String index_battery_string = null;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            button2 = findViewById(R.id.button);
            button_history = findViewById(R.id.button_history1);


            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(Select_option.this, Carstatuscheck.class);
                    startActivity(intent2);
                }
            });
            button_history.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent3 = new Intent(Select_option.this, History.class);
                    startActivity(intent3);
                }
            });
        }
    }


