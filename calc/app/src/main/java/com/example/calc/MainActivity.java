package com.example.calc;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.example.utils.tools;

import java.util.Random;

public class MainActivity extends Activity {
    TextView tvx;
    TextView tvy;
    TextView tvz;
    TextView tva;
    TextView tvb;
    TextView tv_score;
    TextView tv_time;

    EditText res;

    Button bt_sub;
    Button bt_stop;
    LinearLayout test;
    int score=0;
    int result;
    boolean flag=true;
    char[] chars={'+','-','*','/'};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_main);
        tvx=(TextView)findViewById(R.id.tv_x);
        tvy=(TextView)findViewById(R.id.tv_y);
        tvz=(TextView)findViewById(R.id.tv_z);
        tva=(TextView)findViewById(R.id.tv_a);
        tvb=(TextView)findViewById(R.id.tv_b);
        tv_score=(TextView)findViewById(R.id.tv_score);
        tv_time=(TextView)findViewById(R.id.tv_time);
        res=(EditText)findViewById(R.id.et_result);
        bt_sub=findViewById(R.id.bt_submit);
        bt_stop=findViewById(R.id.bt_stop);
        test=findViewById(R.id.test);
        set();
        bt_sub.setOnClickListener(listener);
        bt_stop.setOnClickListener(listener);
        timer.start();
    }
    CountDownTimer timer=new CountDownTimer(10000,1000){
        @Override
        public void onTick(long l) {
            tv_time.setText("Time:"+l/1000);
        }
        @Override
        public void onFinish() {
            set();
            Toast.makeText(MainActivity.this,"时间到",Toast.LENGTH_SHORT).show();
            timer.start();
        }
    };
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                //设置提交按钮事件
                case R.id.bt_submit:{
                    if(""+res.getText()=="")
                        Toast.makeText(MainActivity.this,"请输入答案",Toast.LENGTH_SHORT).show();
                    else {
                        if(Integer.parseInt(String.valueOf(res.getText())) == result){
                            score++;
                            tv_score.setText("Score:"+score);
                            set();
                            res.setText("");
                            Toast.makeText(MainActivity.this,"恭喜你答对了",Toast.LENGTH_SHORT).show();
                            timer.start();
                        }
                        else{
                            set();
                            res.setText("");
                            Toast.makeText(MainActivity.this,"答错了",Toast.LENGTH_SHORT).show();
                            timer.start();
                        }
                    }
                    break;
                    }
                    //暂停时间
                case R.id.bt_stop:{
                    if(flag) {
                        timer.cancel();
                        //防偷窥
                        test.setVisibility(View.INVISIBLE);
                        bt_stop.setText("开始");
                        flag=false;
                    }
                    else {
                        timer.start();
                        test.setVisibility(View.VISIBLE);
                        bt_stop.setText("暂停");
                        flag=true;
                    }
                    break;
                }
            }
        }
    };
    //重置表达式
    public void set(){
        int a,b;
        int x,y,z;
        Random ran=new Random();
        do {
            a=ran.nextInt(3);
            b=ran.nextInt(3);
            x=ran.nextInt(100);
            y=ran.nextInt(100);
            z=ran.nextInt(100);
            tvx.setText("" + x);
            tvy.setText("" + y);
            tvz.setText("" + z);
            tva.setText(String.valueOf(chars[a]));
            tvb.setText(String.valueOf(chars[b]));
            result=tools.check(x,y,z,chars[a],chars[b]);
            Log.i("mytag",""+result);
        }while(result==-1);


    }
}
