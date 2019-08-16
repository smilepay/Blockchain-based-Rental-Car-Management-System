package com.example.sookmyung.myapplication1.history_total;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.sookmyung.myapplication1.DefectCheck;
import com.example.sookmyung.myapplication1.Pair;
import com.example.sookmyung.myapplication1.R;
import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;
import com.example.sookmyung.myapplication1.extra_check.Extra_check1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import static com.example.sookmyung.myapplication1.history_total.History.history_index;

public class History_choice extends AppCompatActivity {
    ViewPager vp;
    TextView nameinput;
    Pair pair=new Pair(0,0,0,0);
    public static Vector<Pair> scretch_back_history = new Vector<>();
    public static Vector<Pair> scretch_front_history = new Vector<>();
    public static Vector<Pair> scretch_left_history = new Vector<>();
    public static Vector<Pair> scretch_right_history = new Vector<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.history_choice);
        System.out.print("여기다여기 히얼"+history_index);

        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
        ImageButton button_extra= (ImageButton) findViewById(R.id.history_extra_button);
        scretch_right_history.clear();
        scretch_left_history.clear();
        scretch_front_history.clear();
        scretch_back_history.clear();

        scretch_front_history.add(pair);
        scretch_back_history.add(pair);
        scretch_right_history.add(pair);
        scretch_left_history.add(pair);

        Block previous_block = Blockchain.getIndexBlock(history_index);
        String name = previous_block.getName();
        nameinput = findViewById(R.id.history_nameinput);
        nameinput.setText(name);

        String sCurrentLine;
        int source_x = 0;
        int source_y = 0;
        int destination_x = 0;
        int destination_y = 0;

        try {
            FileInputStream fis = openFileInput("ma" + history_index + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            while ((sCurrentLine = br.readLine()) != null) {
                if(sCurrentLine.equals("scretch_front")){
                    for (int element_num = 1; !((sCurrentLine = br.readLine()).equals("right")); element_num++) {
                        for (int num = 1; num <= 4; num++) {
                            if (num == 1) {
                                source_x = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else if (num == 2) {
                                source_y = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else if (num == 3) {
                                destination_x = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else {
                                destination_y = Integer.parseInt(sCurrentLine);
                                scretch_front_history.insertElementAt(new Pair(source_x, source_y, destination_x, destination_y), element_num);
                            }
                        }
                    }
                }  else if(sCurrentLine.equals("scretch_right")){
                    for (int element_num = 1; !((sCurrentLine = br.readLine()).equals("left")); element_num++) {
                        for (int num = 1; num <= 4; num++) {
                            if (num == 1) {
                                source_x = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else if (num == 2) {
                                source_y = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else if (num == 3) {
                                destination_x = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else {
                                destination_y = Integer.parseInt(sCurrentLine);
                                scretch_right_history.insertElementAt(new Pair(source_x, source_y, destination_x, destination_y), element_num);
                            }
                        }
                    }
                }else if(sCurrentLine.equals("scretch_left")){
                    for (int element_num = 1; !((sCurrentLine = br.readLine()).equals("back")); element_num++) {
                        for (int num = 1; num <= 4; num++) {
                            if (num == 1) {
                                source_x = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else if (num == 2) {
                                source_y = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else if (num == 3) {
                                destination_x = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else {
                                destination_y = Integer.parseInt(sCurrentLine);
                                scretch_left_history.insertElementAt(new Pair(source_x, source_y, destination_x, destination_y), element_num);
                            }
                        }
                    }
                }
                else if (sCurrentLine.equals("scretch_back")) {
                    for (int element_num = 1; !((sCurrentLine = br.readLine()).equals("batter1")); element_num++) {
                        for (int num = 1; num <= 4; num++) {
                            if (num == 1) {
                                source_x = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else if (num == 2) {
                                source_y = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else if (num == 3) {
                                destination_x = Integer.parseInt(sCurrentLine);
                                sCurrentLine = br.readLine();
                            } else {
                                destination_y = Integer.parseInt(sCurrentLine);
                                scretch_back_history.insertElementAt(new Pair(source_x, source_y, destination_x, destination_y), element_num);
                            }
                        }
                    }
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        button_extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(History_choice.this, History_extra.class);
                intent.putExtra("name",nameinput.getText().toString());
                startActivity(intent);
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
                    return new History_front();
                case 1:
                    return new History_right();
                case 2:
                    return new History_left();
                case 3:
                    return new History_back();
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

