package com.example.sookmyung.myapplication1.history_total;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sookmyung.myapplication1.R;
import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;
import static com.example.sookmyung.myapplication1.history_total.History.history_index;

public class History_extra extends AppCompatActivity {
    TextView batterys, tires, plugs, breaks, motors, oil_quantity,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_extra);
        int oil_int;
        String oil_string;

        Block current_block = Blockchain.getIndexBlock(history_index);

        batterys = findViewById(R.id.bettery);
        tires = findViewById(R.id.tire);
        plugs = findViewById(R.id.flag);
        breaks = findViewById(R.id.breaks);
        motors = findViewById(R.id.motor);
        oil_quantity = findViewById(R.id.oil_quantity);
        add = findViewById(R.id.add);
        oil_int=current_block.getOil_quantity();
        oil_string=Integer.toString(oil_int);

        batterys.setText(current_block.getBattery());
        tires.setText(current_block.getTire());
        plugs.setText(current_block.getPlug());
        breaks.setText(current_block.getbreaks());
        motors.setText(current_block.getMotor());
        oil_quantity.setText(oil_string);
        add.setText(current_block.getadd());
    }
}

