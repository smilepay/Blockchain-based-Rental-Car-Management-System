package com.example.sookmyung.myapplication1.extra_check;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.sookmyung.myapplication1.R;
import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Defect_check_extra extends AppCompatActivity {
    TextView batterys, oil_quantity;
    int oil_i;
    String oil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.carcheck_extra);


        Block previous_block = Blockchain.getLatestBlock();

        batterys = findViewById(R.id.car_battery);
        oil_quantity = findViewById(R.id.oil_car);

        oil_i=previous_block.getOil_quantity();
        oil=Integer.toString(oil_i);

        batterys.setText(previous_block.getBattery());
        oil_quantity.setText(oil);
    }
}