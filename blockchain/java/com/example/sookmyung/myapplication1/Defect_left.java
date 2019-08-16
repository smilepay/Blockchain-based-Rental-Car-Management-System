package com.example.sookmyung.myapplication1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Defect_left extends Fragment {
    Button draw,erase;
    public Defect_left(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.defect_left, container, false);
        draw = (Button) layout.findViewById(R.id.blackline);
        erase = (Button)layout.findViewById(R.id.whiteline);
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyView_left.blackpen();
            }
        });
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyView_left.whitepen();
            }
        });
        return layout;
    }

}