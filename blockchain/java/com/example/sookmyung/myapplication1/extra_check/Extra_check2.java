package com.example.sookmyung.myapplication1.extra_check;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sookmyung.myapplication1.Pair;
import com.example.sookmyung.myapplication1.R;
import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.chain.Blockchain;
import com.example.sookmyung.myapplication1.init.Init;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import static com.example.sookmyung.myapplication1.MyView_front.s;

public class Extra_check2 extends AppCompatActivity {
    Button store1,read;
    String batterys,tires,plugs,motors,breaks;
    boolean checks_1,checks_2,checks_3,checks_4,checks_5;
    TextView oilstore;
    EditText extra;
    String add;
    String worker;
    CheckBox battery,tire,plug,motor,breakK;
    String line;
    String name;
    int index_lastLine;
    private static final String TAG = "DefectCheck";
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.extra_check2);

        Intent intent = getIntent();
        worker = intent.getStringExtra("name");
        battery = (CheckBox) findViewById(R.id.checkbox);
        plug = (CheckBox) findViewById(R.id.plug_checkbox);
        motor = (CheckBox) findViewById(R.id.motor_checkbox);
        extra = findViewById(R.id.extra);
        store1 = findViewById(R.id.save1);
        store1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = null;
                    FileOutputStream fos_index=null;
                    Vector<Pair> scretch_frontst = new Vector<>();
                    scretch_frontst = s.getScretch_frontsc();
                    Vector<Pair> scretch_backst = new Vector<>();
                    scretch_backst = s.getScretch_backsc();
                    Vector<Pair> scretch_rightst = new Vector<>();
                    scretch_rightst= s.getScretch_rightsc();
                    Vector<Pair> scretch_leftst = new Vector<>();
                    scretch_leftst = s.getScretch_leftsc();

                    add = extra.getText().toString();

                    if(battery.isChecked()) {
                        SimpleDateFormat bat=new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                        batterys=bat.format(new Date());
                    }
                    if(Extra_check1.tire_e.isChecked()) {
                        SimpleDateFormat ti=new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                        tires=ti.format(new Date());
                    }
                    System.out.println("skdfkjsl");
                    if(plug.isChecked()) {
                        SimpleDateFormat pl = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                        plugs = pl.format(new Date());
                    }
                    if(Extra_check1.breakK_e.isChecked()) {
                        SimpleDateFormat br = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                        breaks = br.format(new Date());
                    }
                    if(motor.isChecked()) {
                        SimpleDateFormat mo = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
                        motors = mo.format(new Date());
                    }

                    Block latest_block = Blockchain.getLatestBlock();
                    int index =latest_block.getIndex();
                    index++;
                    index_lastLine=index;
                    String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                    System.out.println(sdPath);
                    String index_string=Integer.toString(index_lastLine);

                    try {
                        fos= openFileOutput("co"+index+".txt", Context.MODE_APPEND);
                        System.out.println(index);
                        fos_index=openFileOutput("Index17.txt", Context.MODE_APPEND);
                    }catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    PrintWriter out=new PrintWriter(fos);
                    PrintWriter out_index=new PrintWriter(fos_index);
                    Init.defectstore(worker,scretch_frontst,scretch_backst,scretch_rightst,scretch_leftst,batterys,tires,plugs,breaks,motors,Extra_check1.oil_quantity_e,add);

                    Toast.makeText(Extra_check2.this,"저장 완료",Toast.LENGTH_LONG).show();
                    latest_block.setIndex(index);
                    out_index.println(index_lastLine);
                    index_lastLine=Integer.parseInt(index_string);

                    out.println(worker);
                    Block previous_block1 = Blockchain.getLatestBlock();
                    Vector<Pair> scretch_back = new Vector<>();
                    Vector<Pair> scretch_front = new Vector<>();
                    Vector<Pair> scretch_left = new Vector<>();
                    Vector<Pair> scretch_right = new Vector<>();
                    scretch_back = previous_block1.getScretch_backb();
                    scretch_front = previous_block1.getScretch_frontb();
                    scretch_left = previous_block1.getScretch_leftb();
                    scretch_right = previous_block1.getScretch_rightb();


                    out.println("scretch_front");
                    System.out.println("시작");
                    Pair pair = new Pair(0,0,0,0);
                    for(int i=0; i<scretch_front.size(); i++){
                        pair = scretch_front.elementAt(i);
                        out.println(pair.getSource_x());
                        out.println(pair.getSource_y());
                        out.println(pair.getDestination_x());
                        out.println(pair.getDestination_y());
                    }
                    System.out.println("front");
                    System.out.println(scretch_rightst.size());
                    out.println("right");
                    out.println("scretch_right");
                    for(int i=0; i<scretch_right.size(); i++){
                        System.out.println("오른쪽");
                        pair = scretch_right.elementAt(i);
                        out.println(pair.getSource_x());
                        out.println(pair.getSource_y());
                        out.println(pair.getDestination_x());
                        out.println(pair.getDestination_y());
                    }
                    out.println("left");
                    out.println("scretch_left");
                    System.out.println(scretch_left.size());
                    for(int i=0; i<scretch_left.size(); i++){
                        System.out.println("왼쪽");

                        pair = scretch_left.elementAt(i);
                        out.println(pair.getSource_x());
                        out.println(pair.getSource_y());
                        out.println(pair.getDestination_x());
                        out.println(pair.getDestination_y());
                    }
                    out.println("back");
                    out.println("scretch_back");
                    System.out.println(scretch_back.size());
                    for(int i=0; i<scretch_back.size(); i++){
                        pair = scretch_back.elementAt(i);
                        out.println(pair.getSource_x());
                        out.println(pair.getSource_y());
                        out.println(pair.getDestination_x());
                        out.println(pair.getDestination_y());
                    }
                    out.println("batter1");
                    out.println("battery");
                    out.println(batterys);
                    out.println("tire");
                    out.println(tires);
                    out.println("plug");
                    out.println(plugs);
                    out.println("breakK");
                    out.println(breaks);
                    out.println("motor");
                    out.println(motors);
                    out.println("oil");
                    out.println(Extra_check1.oil_quantity_e);
                    out.println("add");
                    out.println(add);
                    out.close();
                    out_index.close();

                    //System.out.println("배터리" + batterys + "타이어" + tires + "브레이크" + breaks + "모터" + motors + "오일" + oil_quantity + "추가사항" + add);
                    System.out.println(Blockchain.blockchain.size());

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (DigestException e) {
                    e.printStackTrace();
                } catch (InvalidKeyException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (SignatureException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
