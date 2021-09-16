package com.lisitor.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCal, btnDel, btnSum, btnSub, btnDop, btnUsd, btnAdd, btnPro;
    List<Button> buttons = new ArrayList<>();
    TextView name, result;
    EditText editName;
    int number1, number2, res, op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.tvResult);
        name = (TextView) findViewById(R.id.tvName);
        editName = (EditText) findViewById(R.id.editName);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnCal = (Button) findViewById(R.id.btEqu);
        btnDel = (Button) findViewById(R.id.btnClear);
        btnSub = (Button) findViewById(R.id.btRes);
        btnSum = (Button) findViewById(R.id.btSum);
        btnPro = (Button) findViewById(R.id.btPro);
        btnUsd = (Button) findViewById(R.id.btDolar);
        btnDop = (Button) findViewById(R.id.btnPeso);

        btn0 = (Button) findViewById(R.id.bt0);
        btn1 = (Button) findViewById(R.id.bt1);
        btn2 = (Button) findViewById(R.id.bt2);
        btn3 = (Button) findViewById(R.id.bt3);
        btn4 = (Button) findViewById(R.id.bt4);
        btn5 = (Button) findViewById(R.id.bt5);
        btn6 = (Button) findViewById(R.id.bt6);
        btn7 = (Button) findViewById(R.id.bt7);
        btn8 = (Button) findViewById(R.id.bt8);
        btn9 = (Button) findViewById(R.id.bt9);

        buttons.add(btn0);
        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        buttons.add(btn9);
        buttons.add(btnCal);
        buttons.add(btnDel);
        buttons.add(btnSub);
        buttons.add(btnSum);
        buttons.add(btnPro);
        buttons.add(btnUsd);
        buttons.add(btnDop);

        if (name.getText().toString().isEmpty()){
            for(Button button :buttons) {
                button.setEnabled(false);
            }
        }
        for(Button button :buttons) {
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnAdd) {
            String nameText = editName.getText().toString();
            name.setText(nameText);
            editName.setText("");
            if (!name.getText().toString().isEmpty()) {
                for (Button button : buttons) {
                    button.setEnabled(true);
                }
                if(!result.getText().toString().contains("$")){
                    btnDop.setEnabled(false);
                }
            }
        }

        if (view.getId() == R.id.btDolar) {
            number1 = Integer.parseInt(result.getText().toString());
            res = number1 * 57;
            String resultOp = "$"+res;
            result.setText(resultOp);
            if(result.getText().toString().contains("$")){
                btnDop.setEnabled(true);
            }
        }
        if (view.getId() == R.id.btnPeso) {
            int number = result.getText().toString().length();
            number1 = Integer.parseInt(result.getText().toString().substring(1,number));
            int resultConv = (int) Math.round(number1 * 0.018);
            String resultOp = ""+ resultConv;
            result.setText(resultOp);
            if(!result.getText().toString().contains("$")){
                btnDop.setEnabled(false);
            }
        }

        if (view.getId() == R.id.btnClear) {
            result.setText("");
        }

        if (view.getId() == R.id.btSum) {
            op = 1;
            number1 = Integer.parseInt(result.getText().toString());
            result.setText("");
        }
        if (view.getId() == R.id.btRes) {
            op = 2;
            number1 = Integer.parseInt(result.getText().toString());
            result.setText("");
        }
        if (view.getId() == R.id.btPro) {
            op = 3;
            number1 = Integer.parseInt(result.getText().toString());
            result.setText("");
        }

        if (view.getId() == R.id.btEqu) {
            number2 = Integer.parseInt(result.getText().toString());
            switch (op) {
                case 1:
                    res = number1 + number2;
                    break;
                case 2:
                    res = number1 - number2;
                    break;
                case 3:
                    res = number1 * number2;
                    break;

                default:
                    res = 0;
                    break;
            }
            String resultOp = ""+res;
            result.setText(resultOp);
        }


        if (view.getId() == R.id.bt0) {
            String number0 = result.getText().toString() + "0";
            result.setText(number0);
        }

        if (view.getId() == R.id.bt1) {
            String number1 = result.getText().toString() + "1";
            result.setText(number1);
        }
        if (view.getId() == R.id.bt2) {
            String number2 = result.getText().toString() + "2";
            result.setText(number2);
        }

        if (view.getId() == R.id.bt3) {
            String number3 = result.getText().toString() + "3";
            result.setText(number3);
        }

        if (view.getId() == R.id.bt4) {
            String number4 = result.getText().toString() + "4";
            result.setText(number4);
        }

        if (view.getId() == R.id.bt5) {
            String number5 = result.getText().toString() + "5";
            result.setText(number5);
        }

        if (view.getId() == R.id.bt6) {
            String number6 = result.getText().toString() + "6";
            result.setText(number6);
        }

        if (view.getId() == R.id.bt7) {
            String number7 = result.getText().toString() + "7";
            result.setText(number7);
        }

        if (view.getId() == R.id.bt8) {
            String number8 = result.getText().toString() + "8";
            result.setText(number8);
        }

        if (view.getId() == R.id.bt9) {
            String number9 = result.getText().toString() + "9";
            result.setText(number9);
        }




    }


}