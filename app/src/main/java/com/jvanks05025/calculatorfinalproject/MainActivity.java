package com.jvanks05025.calculatorfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button Btambah, Bkali,Bkurang,Bbagi, Bmodulus;
    Button Bsatu,Bdua, Btiga, Bempat,Blima,Benam,Btujuh,Bdelapan,Bsembilan,Bnoll;
    Button clearALL,backspace,Bresult;
    TextView resulttv,inputtv;
    double input1,input2,result;
    String input="",inputresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clearALL=findViewById(R.id.clear);
        backspace=findViewById(R.id.backspace);
        Bresult=findViewById(R.id.hasil);

        inputtv=findViewById(R.id.inputtv);
        resulttv=findViewById(R.id.resulttv);

        Btambah=findViewById(R.id.tambah);
        Bkurang=findViewById(R.id.kurang);
        Bkali=findViewById(R.id.kali);
        Bbagi=findViewById(R.id.bagi);
        Bmodulus=findViewById(R.id.modulus);

        Bsatu=findViewById(R.id.one);
        Bdua=findViewById(R.id.two);
        Btiga=findViewById(R.id.three);
        Bempat=findViewById(R.id.four);
        Blima=findViewById(R.id.five);
        Benam=findViewById(R.id.six);
        Btujuh=findViewById(R.id.seven);
        Bdelapan=findViewById(R.id.eight);
        Bsembilan=findViewById(R.id.nine);
        Bnoll=findViewById(R.id.zero);

        Bsatu.setOnClickListener(this);
        Bdua.setOnClickListener(this);
        Btiga.setOnClickListener(this);
        Bempat.setOnClickListener(this);
        Blima.setOnClickListener(this);
        Benam.setOnClickListener(this);
        Btujuh.setOnClickListener(this);
        Bdelapan.setOnClickListener(this);
        Bsembilan.setOnClickListener(this);
        Bnoll.setOnClickListener(this);

        clearALL.setOnClickListener(this);
        backspace.setOnClickListener(this);
        Bresult.setOnClickListener(this);

        Btambah.setOnClickListener(this);
        Bkurang.setOnClickListener(this);
        Bbagi.setOnClickListener(this);
        Bkali.setOnClickListener(this);
        Bmodulus.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int viewId=view.getId();
        switch (viewId){
            case (R.id.one):
               checkResultTextView("1");
                break;
            case (R.id.two):
                checkResultTextView("2");
                break;
            case (R.id.three):
                checkResultTextView("3");
                break;
            case (R.id.four):
                checkResultTextView("4");
                break;
            case (R.id.five):
                checkResultTextView("5");
                break;
            case (R.id.six):
                checkResultTextView("6");
                break;
            case (R.id.seven):
                checkResultTextView("7");
                break;
            case (R.id.eight):
                checkResultTextView("8");
                break;
            case (R.id.nine):
                checkResultTextView("9");
                break;
                case (R.id.zero):
                checkResultTextView("0");
                break;
            case(R.id.clear):
                if(inputtv.getText().length()!=0 || resulttv.getText().length()!=0){
                    input="";
                    inputresult="";
                    resulttv.setText(inputresult);
                    inputtv.setText(input);
                }
                break;
            case(R.id.backspace):
                if(inputtv.getText().length()!=0){
                    input=input.substring(0,input.length()-1);
                    inputtv.setText(input);
                }
                break;
            case(R.id.hasil):
                if(resulttv.getText().length()!=0 && inputtv.getText().length()!=0){
                    operation(inputresult,inputtv.getText().toString());
                    resulttv.setText(result+"");
                    inputresult=result+"";
                    input="";
                    inputtv.setText(input);
                }
                break;
            case(R.id.tambah):
                declareOperation(" +","+");
                break;
            case(R.id.kurang):
                declareOperation(" -","-");
                break;
            case(R.id.bagi):
               declareOperation(" /","/");
                break;
            case(R.id.kali):
              declareOperation(" *","*");
                break;
            case(R.id.modulus):
                declareOperation(" %","%");
                break;
        }
    }
    //    angka 1=inputresult ;
    //    angka 2 =inputtv.getText().toString();
    public double operation (String angka1,String angka2){
        if(resulttv.getText().toString().contains("+")){
            input1=Double.parseDouble(angka1);
            input2=Double.parseDouble(angka2);
           result=input1+input2;
        }
        else if(resulttv.getText().toString().contains("-")){
            input1=Double.parseDouble(angka1);
            input2=Double.parseDouble(angka2);
             result=input1-input2;
        }
        else if(resulttv.getText().toString().contains("/")){
            input1=Double.parseDouble(angka1);
            input2=Double.parseDouble(angka2);
            result=input1/input2;
        }else if(resulttv.getText().toString().contains("*")){
            input1=Double.parseDouble(angka1);
            input2=Double.parseDouble(angka2);
            result=input1*input2;
        }
        else if(resulttv.getText().toString().contains("%")){
            input1=Double.parseDouble(angka1);
            input2=Double.parseDouble(angka2);
             result=input1%input2;

        }
        return result;
    }
//    Koperasi= " %"
//    operasi="%"
    public void declareOperation (String KOperasi,String operasi){
        if(resulttv.getText().length()==0&& inputtv.getText().length()!=0){
            resulttv.setText(input+ KOperasi);
            inputresult=input;
            input="";
            inputtv.setText(input);
        }
        else if(resulttv.getText().length()==0 && inputtv.getText().length()==0){
//            jika resulttv kosong dan input kosong
            if(operasi == "-"){
//                kalau inputnya tidak ada tetapi menekan tombol -/+
                input="-";
                Log.i("informasi",input);
                inputtv.setText(operasi);

            }
            else{
                input="";
                inputresult="";
                inputtv.setText(input);
                resulttv.setText(inputresult);
            }
        }
        else if (resulttv.getText().length()!=0&& inputtv.getText().length()!=0) {

            operation(inputresult,inputtv.getText().toString());
            resulttv.setText(result+KOperasi);
            inputresult=result+"";
            input="";
            inputtv.setText(input);
        }
        else if(
        !resulttv.getText().toString().endsWith(KOperasi)
        ){
//? kalau - sama - tidak bisa
            resulttv.setText(inputresult + KOperasi);
            result=Double.parseDouble(inputresult);
        }
    }

    public void checkResultTextView(String number){
        if(     resulttv.getText().length()==0||
                resulttv.getText().toString().endsWith("*")||
                resulttv.getText().toString().endsWith("-")||
                resulttv.getText().toString().endsWith("+")||
                resulttv.getText().toString().endsWith("/")||
                resulttv.getText().toString().endsWith("%")
        ){
            input=input+number;
            inputtv.setText(input);
        }else{
            input="";
            inputresult="";
            resulttv.setText(inputresult);
            input=input+number;
            inputtv.setText(input);
        }
    }


}