package com.example.sookmyung.myapplication1;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sookmyung.myapplication1.block.Block;
import com.example.sookmyung.myapplication1.block.BlockUtil;
import com.example.sookmyung.myapplication1.chain.Blockchain;
import com.example.sookmyung.myapplication1.history_total.History;
import com.example.sookmyung.myapplication1.init.Init;

import static com.example.sookmyung.myapplication1.chain.Blockchain.blockchain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Stack;
import java.util.Vector;
import static com.example.sookmyung.myapplication1.MyView_front.s;



public class MainActivity extends AppCompatActivity {
    ImageView sonata,levante,suv,santafe,benz;
    Button button1;
    int index_lastLine=0;
    String index_lastLine_string=null;
    Vector<Pair> scretch_front= new Vector<>();
    Vector<Pair> scretch_back= new Vector<>();
    Vector<Pair> scretch_left= new Vector<>();
    Vector<Pair> scretch_right= new Vector<>();


//인덱스만 연결해주면 된다 블록 생성할때마다 인덱스 증가시켜서 만들어주면 될듯 아싸링
//index_last line은 생각해보니까 사용자앱에서 받을때 필요한거고 여기서는 getindex해서 증가만 시켜주면 될듯 ㅇㅋㅇㅋ
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcar);
        sonata=(ImageView)findViewById(R.id.sonata);
        levante=(ImageView)findViewById(R.id.levante) ;
        suv=(ImageView)findViewById(R.id.suv);
        button1 = findViewById(R.id.k5);
        santafe=(ImageView)findViewById(R.id.santafe) ;
        benz=(ImageView)findViewById(R.id.benz);


        try {
            initBlockchain();
            System.out.println("박아영 바보");
        } catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException | SignatureException e) {
            e.printStackTrace();
            System.out.println("실패에에에에");
        }

        //처음 실행시에는 여기부분만 공개하고 바로 밑인 2)부분은 주석처리를 해주세요
        //1)
    /*try {
            File f=new File("Index17.txt");
            if(f.exists()) {
                String s_currentLine;
                FileInputStream fis = openFileInput("Index9.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                while ((s_currentLine = br.readLine()) != null) {
                    index_lastLine_string = s_currentLine;
                }
                Toast.makeText(MainActivity.this, "성공~" + index_lastLine_string, Toast.LENGTH_LONG).show();
                br.close();
                index_lastLine = Integer.parseInt(index_lastLine_string);

            }
            else{
                index_lastLine=0;
                System.out.println("아직 index 파일 없음");
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(MainActivity.this, "실패", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
     //여기까지 해주시면 됩니다..굽신굽신
        //2) 여기는 처음이 아니면 여기를 주석처리하지 않고 해주시면 됩니다!!(index파일 새로 만들때는 -처음할때는 이부분을 주석처리)
   try{
            String s_currentLine;
            FileInputStream fis = openFileInput("Index17.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while ((s_currentLine = br.readLine()) != null) {
                index_lastLine_string = s_currentLine;
            }
            Toast.makeText(MainActivity.this, "성공~" + index_lastLine_string, Toast.LENGTH_LONG).show();
            br.close();
            index_lastLine = Integer.parseInt(index_lastLine_string);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }

    //여기까지

            Block previous_block = Blockchain.getLatestBlock();
            String batterys = previous_block.getBattery();
            String tires = previous_block.getTire();
            String plugs = previous_block.getPlug();
            String breaks = previous_block.getbreaks();
            String motors = previous_block.getMotor();
            String oil_quantity_string;
            int oil_quantity = previous_block.getOil_quantity();
            String add = previous_block.getadd();
            int index = previous_block.getIndex();
            try {

                String sCurrentLine;
                int source_x = 0;
                int source_y = 0;
                int destination_x = 0;
                int destination_y = 0;

                scretch_back = previous_block.getScretch_backb();
                scretch_front = previous_block.getScretch_frontb();
                scretch_left = previous_block.getScretch_leftb();
                scretch_right = previous_block.getScretch_rightb();
                for (int i=1;i<=index_lastLine;i++) {
                    FileInputStream fis = openFileInput("co"+i+".txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    StringBuffer data = new StringBuffer();
                    String name = br.readLine();
                    System.out.println("여기요");
                    while ((sCurrentLine = br.readLine()) != null) {
                        if (sCurrentLine.equals("scretch_front")) {
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
                                        System.out.println("hererererer");
                                        System.out.println(element_num);
                                        scretch_front.insertElementAt(new Pair(source_x, source_y, destination_x, destination_y), element_num);
                                        s.setScretch_frontsc(scretch_front);
                                        System.out.println(s.getScretch_frontsc().elementAt(element_num).getSource_x());
                                    }
                                }
                            }

                            System.out.println(scretch_front.elementAt(0).getSource_x());

                            System.out.println("front");
                        } else if (sCurrentLine.equals("scretch_right")) {
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
                                        scretch_right.insertElementAt(new Pair(source_x, source_y, destination_x, destination_y), element_num);
                                        s.setScretch_rightsc(scretch_right);
                                    }
                                }
                            }
                            System.out.println(scretch_right.elementAt(0).getSource_x());

                            System.out.println("r");
                        } else if (sCurrentLine.equals("scretch_left")) {
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
                                        scretch_left.insertElementAt(new Pair(source_x, source_y, destination_x, destination_y), element_num);
                                        s.setScretch_leftsc(scretch_left);

                                    }
                                }
                            }
                            System.out.println(scretch_left.elementAt(0).getSource_x());

                            System.out.println("l");
                        } else if (sCurrentLine.equals("scretch_back")) {
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
                                        scretch_back.insertElementAt(new Pair(source_x, source_y, destination_x, destination_y), element_num);
                                        s.setScretch_backsc(scretch_back);

                                    }
                                }
                            }
                            System.out.println(scretch_back.elementAt(0).getSource_x());

                            System.out.println("b");
                        }
                        else if (sCurrentLine.equals("battery")) {
                            batterys = br.readLine();
                            System.out.println("여기다");
                        }
                        else if(sCurrentLine.equals("tire")){
                            tires=br.readLine();
                        }
                        else if(sCurrentLine.equals("plug")){
                            plugs=br.readLine();
                        }
                        else if(sCurrentLine.equals("breakK")){
                            breaks=br.readLine();
                        }
                        else if(sCurrentLine.equals("motor")){
                            motors=br.readLine();
                        }
                        else if(sCurrentLine.equals("oil")){
                            oil_quantity_string=br.readLine();
                            oil_quantity=Integer.parseInt(oil_quantity_string);
                        }
                        else if(sCurrentLine.equals("add")){
                            add=br.readLine();
                        }
                    }

                        Init.defectstore(name, scretch_front, scretch_back, scretch_right, scretch_left, batterys, tires, plugs, breaks, motors, oil_quantity, add);


                       index++;
                        previous_block.setIndex(index);
                        System.out.println("gef");
                        System.out.println(blockchain.size());

                        br.close();


                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("실패여어어");
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (SignatureException e) {
                e.printStackTrace();
            } catch (DigestException e) {
                e.printStackTrace();
            }
            System.out.println(previous_block.getIndex());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Car_num.class);
                startActivity(intent);
            }
        });



    }


        private static void initBlockchain() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, SignatureException{

            blockchain = new Stack<Block>();
            blockchain.addElement(BlockUtil.generateGenesisBlock());
            System.out.println("박아영 멍청이");
        }
}
