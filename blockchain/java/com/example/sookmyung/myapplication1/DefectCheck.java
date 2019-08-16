package com.example.sookmyung.myapplication1;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sookmyung.myapplication1.extra_check.Extra_check1;

public class DefectCheck extends AppCompatActivity {
    ViewPager vp;
    TextView nameinput;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.defect);

        nameinput = findViewById(R.id.textView3);
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

        Button btn_front = (Button) findViewById(R.id.button_front);
        Button btn_right = (Button) findViewById(R.id.button_right);
        Button btn_left = (Button) findViewById(R.id.button_left);
        Button btn_back = (Button) findViewById(R.id.button_back);
        Button button3= findViewById(R.id.button4);

        btn_front.setOnClickListener(movePageListener);
        btn_front.setTag(0);
        btn_right.setOnClickListener(movePageListener);
        btn_right.setTag(1);
        btn_left.setOnClickListener(movePageListener);
        btn_left.setTag(2);
        btn_back.setOnClickListener(movePageListener);
        btn_back.setTag(3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(DefectCheck.this, Extra_check1.class);
                intent.putExtra("name",nameinput.getText().toString());
                startActivity(intent);
            }
        });
    }
    View.OnClickListener movePageListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            int tag = (int) v.getTag();
            vp.setCurrentItem(tag);
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter
        {
            public pagerAdapter(android.support.v4.app.FragmentManager fm)
            {
                super(fm);
            }
            @Override
            public android.support.v4.app.Fragment getItem(int position)
            {
            switch(position)
            {
                case 0:
                    return new Defect_front();
                case 1:
                    return new Defect_right();
                case 2:
                    return new Defect_left();
                case 3:
                    return new Defect_back();
                default:
                    return null;
            }
        }
        @Override
        public int getCount()
        {
            return 4;
        }
    }
}