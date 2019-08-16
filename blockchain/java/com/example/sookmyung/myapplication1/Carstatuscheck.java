package com.example.sookmyung.myapplication1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;
import com.example.sookmyung.myapplication1.extra_check.Defect_check_extra;


public class Carstatuscheck extends AppCompatActivity {
    ViewPager vp;
    TextView nameinput;
    Button extradefect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.carcheck);

        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

        Block previous_block = Blockchain.getLatestBlock();
        String name = previous_block.getName();
        nameinput = findViewById(R.id.nameinput);
        nameinput.setText(name);
        System.out.println("제발 같아라..");
        System.out.println(previous_block.getHash());
        ImageButton extradefect = (ImageButton) findViewById(R.id.extradefect);

        extradefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Carstatuscheck.this,Defect_check_extra.class);
                startActivity(intent1);
            }
        });
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new check_front();
                case 1:
                    return new check_right();
                case 2:
                    return new check_left();
                case 3:
                    return new check_back();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}

