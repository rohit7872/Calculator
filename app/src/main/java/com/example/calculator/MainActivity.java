package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display = findViewById(R.id.img);
        Display.setShowSoftInputOnFocus(false);
        Display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(getString(R.string.display).equals(Display.getText().toString()));
               Display.setText("");
            }
        });
    }

    private void updateText(String strToadd){

        String oldStr = Display.getText().toString();
        int cursorPos = Display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if(getString(R.string.display).equals(Display.getText().toString())) {
            Display.setText(strToadd);
            Display.setSelection(cursorPos + 1);
        }
        else {
            Display.setText(String.format("%s%s%s" , leftStr,strToadd,rightStr));
            Display.setSelection(cursorPos + 1);
        }

    }

    public void img(View view) {
    }



    public void clear(View view) {
        Display.setText("");
    }



    public void exponent(View view) {
        updateText("^");

    }

    public void divide(View view) {
        updateText("/");
    }

    public void seven(View view) {
        updateText("7");
    }

    public void eight(View view) {
        updateText("8");
    }

    public void nine(View view) {
        updateText("9");
    }

    public void multiply(View view) {
        updateText("*");
    }

    public void four(View view) {
        updateText("4");
    }

    public void five(View view) {
        updateText("5");
    }

    public void six(View view) {
        updateText("6");
    }

    public void minus(View view) {
        updateText("-");
    }

    public void one(View view) {
        updateText("1");
    }

    public void two(View view) {
    updateText("2");
    }

    public void three(View view) {
        updateText("3");
    }

    public void add(View view) {
        updateText("+");
    }

    public void plusminus(View view) {
        updateText("-");
    }

    public void zero(View view) {
        updateText("0");
    }

    public void point(View view) {
        updateText(".");
    }

    public void equal(View view) {

        String userExp = Display.getText().toString();
         Expression Exp =  new Expression(userExp);
          String Result = String.valueOf(Exp.calculate());
           Display.setText(Result);
           Display.setSelection(Result.length());




    }
    public void parentheses(View view) {
        int cursorPos = Display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = Display.getText().length();

        for (int i = 0; i < cursorPos; i++) {
            if (Display.getText().toString().substring(i, i + 1).equals("(")) {
                openPar += 1;

            }
            if (Display.getText().toString().substring(i, i + 1).equals(")")) {
                closedPar += 1;
            }
        }
        if(openPar == closedPar || Display.getText().toString().substring(textLen - 1 , textLen).equals("(")){
            updateText("(");

        }
       else if(closedPar < openPar && ! Display.getText().toString().substring(textLen - 1 , textLen).equals("(")){
            updateText(")");

        }
        Display.setSelection(cursorPos+1);
    }
    public void text(View view) {
        int cursorPos = Display.getSelectionStart();
        int textlen = Display.getText().length();

          if(cursorPos !=0 && textlen !=0){
             SpannableStringBuilder selection = (SpannableStringBuilder) Display.getText();
              selection.replace(cursorPos - 1 , cursorPos , "");
              Display.setText(selection);
              Display.setSelection(cursorPos - 1);
          }

    }

}