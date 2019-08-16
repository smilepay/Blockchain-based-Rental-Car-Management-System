package com.example.sookmyung.myapplication1.extra_check;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sookmyung.myapplication1.R;



public class Extra_check1 extends AppCompatActivity {
    Button next;
    public static int oil_quantity_e;
    TextView oilstore;
    EditText extra;
    public static String add_e;
    public static String worker_e;
    public static CheckBox tire_e,breakK_e;
    String line;
    public static String name_e;
    private static final String TAG = "DefectCheck";
//내일 myview다시보고 블록생성한거 연결히야할듯 blocksize도 출력해봐야것다

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.extra_check1);

        Intent intent = getIntent();
        worker_e = intent.getStringExtra("name");


        //battery = (CheckBox) findViewById(R.id.checkbox);
        tire_e = (CheckBox) findViewById(R.id.tire_checkbox);
        // plug = (CheckBox) findViewById(R.id.plug_checkbox);
        //motor = (CheckBox) findViewById(R.id.motor_checkbox);
        oilstore = (TextView) findViewById(R.id.quantity_text_view);
        breakK_e = (CheckBox) findViewById(R.id.breaks_checkbox);

        //final TextView tv = (TextView) findViewById(R.id.textView5);
        //extra = findViewById(R.id.extra);
        findViewById(R.id.increment).setOnClickListener(clickListener);
        findViewById(R.id.decrement).setOnClickListener(clickListener);

        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Extra_check1.this,Extra_check2.class);
                intent.putExtra("name",worker_e);
                startActivity(intent);
            }
        });
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                    case R.id.decrement:
                        System.out.println("체크박스");
                        oil_quantity_e--;
                        oilstore.setText(""+oil_quantity_e);
                        break;
                    case R.id.increment:
                        System.out.println("체크박스");
                        oil_quantity_e++;
                        oilstore.setText(""+oil_quantity_e);
                        break;
                    default:
                        break;
            }
        }
    };
}